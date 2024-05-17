package com.example.demo.controller;

import com.example.demo.model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController     // CSR
@RequestMapping("/data")
public class DataController {

    // 取得今日時間
    @GetMapping("/today")
    public ResponseEntity<ApiResponse<String>> today() {
        Date today = new Date();
        // "yyyy-MM-dd HH:mm:ss E" ,"yyyy-MM-dd a hh:mm:ss E"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");
        String todayString = sdf.format(today);
        ApiResponse<String> apiResponse = new ApiResponse<>(true, "success", todayString);
        return ResponseEntity.ok(apiResponse);
    }

    // 取得樂透幸運數字
    @GetMapping("/lotto")
    public ResponseEntity<ApiResponse<Integer>> lotto() {
        Integer data = new Random().nextInt(100);
        ApiResponse<Integer> apiResponse = new ApiResponse<>(true, "success", data);
        return ResponseEntity.ok(apiResponse);
    }
}
