package com.esun.likelist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikelistDto {
    private Integer sn;
    private String userId;
    private BigDecimal totalFee;
    private BigDecimal totalAmount;
    private String debitAccount;
    private String email;  // 從 Users entity 取得
}




