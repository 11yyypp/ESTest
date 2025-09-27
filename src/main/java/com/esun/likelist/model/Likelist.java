package com.esun.likelist.model;

import java.math.BigDecimal;

import com.esun.product.model.Product;
import com.esun.users.model.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity	
@Table(name = "likelist")

public class Likelist {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    private Integer sn;
	
    @Column(name = "user_id")
	private String userId;
	

    @Column(name = "quantity")
	private Integer quantity;
	

    @Column(name = "debit_account")
	private String debitAccount;
	

    @Column(name = "totalFee")
	private BigDecimal totalFee;
	

    @Column(name = "total_amount")
	private BigDecimal totalAmount;
    
    
 // 關聯 Users
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private Users users;
    
 // 關聯 Users
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    
}


