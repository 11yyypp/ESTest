package com.esun.likelist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esun.likelist.model.Likelist;
import com.esun.likelist.model.LikelistAddDto;
import com.esun.likelist.model.LikelistDto;
import com.esun.likelist.model.LikelistService;

@RestController
@RequestMapping("/like")
public class LikelistController {

    @Autowired
    private LikelistService likelistSvc;

    // 取得全部喜好清單 DTO
    @GetMapping("/getAll")
    public ResponseEntity<List<LikelistDto>> getAll() {
        List<LikelistDto> list = likelistSvc.getAllDto();
        return ResponseEntity.ok(list);
    }

    // 根據使用者 ID 查詢 DTO
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LikelistDto>> getByUserId(@PathVariable String userId) {
        List<LikelistDto> list = likelistSvc.getByUserIdDto(userId);
        return ResponseEntity.ok(list);
    }
    
// // 新增喜好商品
//    @PostMapping("/add")
//    public ResponseEntity<Likelist> add(@RequestBody LikelistAddDto dto) {
//        Likelist saved = likelistSvc.add(dto);
//        return ResponseEntity.ok(saved);
//    }
//    
    
}
