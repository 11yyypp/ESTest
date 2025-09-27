package com.esun.likelist.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikelistRepository extends JpaRepository<Likelist, Integer> {
	List<Likelist> findByUserId(String userId);
	

}

