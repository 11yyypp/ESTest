package com.esun.likelist.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LikelistService {

    @Autowired
    private LikelistRepository likelistRepo;

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

    // Entity -> DTO 映射
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
//    
//    public LikelistDto addDto(LikelistAddDto dto) {
//        Likelist entity = add(dto); // 呼叫原本的 add 方法
//        return toDto(entity);
//    }



}
