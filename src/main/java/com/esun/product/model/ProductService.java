package com.esun.product.model;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

//	public void add(Map<String, Object> body) {
//		productRepository.insert(body);
//	}
//
//	public void update(Map<String, Object> body) {
//		productRepository.update(body);
//	}
//
//	public void delete(Integer productId) {
//		productRepository.delete(productId);
//	}
//
//	public List<Map<String, Object>> list() {
//		return productRepository.list();
//	}
}
