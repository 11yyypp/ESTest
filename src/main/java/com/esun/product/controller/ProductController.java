//package com.esun.product.controller;
//
//import com.esun.product.model.ProductService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/product")
//public class ProductController {
//
//	private final ProductService productService;
//
//	public ProductController(ProductService productService) {
//		this.productService = productService;
//	}
//
//	@PostMapping
//	public ResponseEntity<Void> add(@RequestBody Map<String, Object> body) {
//		productService.add(body);
//		return ResponseEntity.ok().build();
//	}
//
//	@PutMapping
//	public ResponseEntity<Void> update(@RequestBody Map<String, Object> body) {
//		productService.update(body);
//		return ResponseEntity.ok().build();
//	}
//
//	@DeleteMapping("/{product_id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer product_id) {
//		productService.delete(product_id);
//		return ResponseEntity.ok().build();
//	}
//
//	@GetMapping
//	public ResponseEntity<List<Map<String, Object>>> list() {
//		return ResponseEntity.ok(productService.list());
//	}
//}
//
//
