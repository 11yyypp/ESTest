package com.esun.likelist.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esun.product.model.Product;
import com.esun.product.model.ProductRepository;
import com.esun.likelist.model.Likelist;






@Service
public class LikelistService {

    @Autowired
    private LikelistRepository likelistRepo;
    
    @Autowired
    private ProductRepository productRepo;

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
            l.getTotalFee(),
            l.getTotalAmount(),
            l.getDebitAccount(),
            l.getUsers() != null ? l.getUsers().getEmail() : null
        );
    }
    
    // 新增喜好商品
    public LikelistDto addDto(LikelistAddDto dto) {
        Likelist entity = new Likelist();
        entity.setUserId(dto.getUserId());
        entity.setQuantity(dto.getQuantity());
        entity.setDebitAccount(dto.getDebitAccount());

        Product product = productRepo.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        entity.setProduct(product);

     // 計算總手續費與總金額
        BigDecimal totalFee = product.getPrice()
                                     .multiply(BigDecimal.valueOf(dto.getQuantity()))
                                     .multiply(product.getFeeRate());
        BigDecimal totalAmount = product.getPrice()
                                        .multiply(BigDecimal.valueOf(dto.getQuantity()))
                                        .add(totalFee);

        entity.setTotalFee(totalFee);
        entity.setTotalAmount(totalAmount);

        Likelist saved = likelistRepo.save(entity);
        return toDto(saved);
    }

}
