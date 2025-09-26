package com.esun.users.model;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsersService {

	private final UsersRepository usersRepository;

	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

//	public void add(Map<String, Object> body) {
//		usersRepository.insert(body);
//	}
//
//	public void update(Map<String, Object> body) {
//		usersRepository.update(body);
//	}
//
//	public void delete(String userId) {
//		usersRepository.delete(userId);
//	}
//
//	public List<Map<String, Object>> list() {
//		return usersRepository.list();
//	}
}
