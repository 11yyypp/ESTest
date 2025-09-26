package com.esun.likelist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikelistAddDto {
    private String userId;
    private Integer productId;   // 改成 Product 關聯用
    private Integer quantity;
    private String debitAccount;
}
