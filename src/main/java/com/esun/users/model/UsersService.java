package com.esun.users.model;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepo;

    public UsersService(UsersRepository usersRepo) {
        this.usersRepo = usersRepo;
    }

    public Users getUserById(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("請輸入使用者ID!");
        }
        return usersRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("請輸入正確的使用者ID!"));
    }
}
