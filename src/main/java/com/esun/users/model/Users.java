package com.esun.users.model;



import java.util.List;

import com.esun.likelist.model.Likelist;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {
	
	@Id
    @Column(name = "user_id")
	private String userId;
	

    @Column(name = "user_name")
	private String userName;
	

    @Column(name = "email")
	private String email;

    
    @Column(name = "debit_account")
	private String debitAccount;
    
    // 對應 Likelist
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Likelist> likelists;
}

