//package com.esun.users.controller;
//
//import com.esun.users.model.UsersService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/users")
//public class UsersController {
//
//	private final UsersService usersService;
//
//	public UsersController(UsersService usersService) {
//		this.usersService = usersService;
//	}
//	
//	@GetMapping("/list")
//	public ResponseEntity<List<Map<String, Object>>> list() {
//		return ResponseEntity.ok(usersService.list());
//	}
//
//	@PostMapping("/add")
//	public ResponseEntity<Void> add(@RequestBody Map<String, Object> body) {
//		usersService.add(body);
//		return ResponseEntity.ok().build();
//	}
//
//	@PutMapping
//	public ResponseEntity<Void> update(@RequestBody Map<String, Object> body) {
//		usersService.update(body);
//		return ResponseEntity.ok().build();
//	}
//
//	@DeleteMapping("/{user_id}")
//	public ResponseEntity<Void> delete(@PathVariable String user_id) {
//		usersService.delete(user_id);
//		return ResponseEntity.ok().build();
//	}
//
//	
//}
//
//
