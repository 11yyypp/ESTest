package com.esun.likelist.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esun.product.model.Product;
import com.esun.product.model.ProductRepository;
import com.esun.users.model.Users;
import com.esun.users.model.UsersService;


@Service
public class LikelistService {

    @Autowired
    private LikelistRepository likelistRepo;
    
    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private UsersService usersSvc;



    public List<LikelistDto> getAllDto() {
        return likelistRepo.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<LikelistDto> getByUserIdDto(String userId) {
        return likelistRepo.findByUserId(userId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Entity -> DTO
    private LikelistDto toDto(Likelist l) {
        return new LikelistDto(
            l.getSn(),
            l.getUserId(),
            l.getProduct() != null ? l.getProduct().getProductId() : null,
            l.getProduct() != null ? l.getProduct().getProductName() : null,
            l.getTotalAmount(),
            l.getTotalFee(),
            l.getDebitAccount(),
            l.getUsers() != null ? l.getUsers().getEmail() : null // email
        );
    }


    
    // 新增喜好商品
    public LikelistDto addDto(LikelistAddDto dto) {
    	
    	// 驗證輸入
        if (dto.getUserId() == null || dto.getUserId().isEmpty()) {
            throw new IllegalArgumentException("請輸入使用者ID!");
        }
        if (dto.getQuantity() == null || dto.getQuantity() <= 0) {
            throw new IllegalArgumentException("請輸入購買數量!");
        }
        if (dto.getDebitAccount() == null || dto.getDebitAccount().isEmpty()) {
            throw new IllegalArgumentException("請輸入扣款帳號!");
        }
        if (dto.getProductId() == null) {
            throw new IllegalArgumentException("請選擇產品!");
        }
        if (dto.getDebitAccount().length() < 10 || dto.getDebitAccount().length() > 14) {
        	throw new IllegalArgumentException("請輸入正確扣款帳號!");
          }
        
        Likelist entity = new Likelist();
        entity.setUserId(dto.getUserId());
        entity.setQuantity(dto.getQuantity());
        entity.setDebitAccount(dto.getDebitAccount());

        // 取得 Product
        Product product = productRepo.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        entity.setProduct(product);

        // 取得 User
        Users user = usersSvc.getUserById(dto.getUserId());
        entity.setUsers(user);

        // 計算總手續費與總金額
        BigDecimal totalFee = product.getPrice()
                                     .multiply(BigDecimal.valueOf(dto.getQuantity()))
                                     .multiply(product.getFeeRate());
        BigDecimal totalAmount = product.getPrice()
                                        .multiply(BigDecimal.valueOf(dto.getQuantity()))
                                        .add(totalFee);

        entity.setTotalFee(totalFee);
        entity.setTotalAmount(totalAmount); 
        

        // 存入 DB
        Likelist saved = likelistRepo.save(entity);
        
        String email = usersSvc.getUserById(saved.getUserId()).getEmail();

        return new LikelistDto(
                saved.getSn(),
                saved.getUserId(),
                saved.getProduct().getProductId(),
                saved.getProduct().getProductName(),
                saved.getTotalAmount(),
                saved.getTotalFee(),
                saved.getDebitAccount(),
                email
            );
    }

    
    // 修改喜好商品
    public LikelistDto updateDto(Integer sn, LikelistAddDto dto) {
        
        Likelist entity = likelistRepo.findById(sn)
                .orElseThrow(() -> new RuntimeException("Likelist not found"));

        // 更新欄位
        entity.setUserId(dto.getUserId());
        entity.setQuantity(dto.getQuantity());
        entity.setDebitAccount(dto.getDebitAccount());

        Product product = productRepo.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        entity.setProduct(product);


        // 重新計算總手續費與總金額
        BigDecimal totalFee = product.getPrice()
                                     .multiply(BigDecimal.valueOf(dto.getQuantity()))
                                     .multiply(product.getFeeRate());
        BigDecimal totalAmount = product.getPrice()
                                     .multiply(BigDecimal.valueOf(dto.getQuantity()))
                                     .add(totalFee);

        entity.setTotalFee(totalFee);
        entity.setTotalAmount(totalAmount);

        // 存回 DB
        Likelist saved = likelistRepo.save(entity);
        return toDto(saved);
    }
    
    // 刪除喜好商品
    public void deleteBySn(Integer sn) {
        if (!likelistRepo.existsById(sn)) {
            throw new RuntimeException("Likelist not found");
        }
        likelistRepo.deleteById(sn);
    }

}
