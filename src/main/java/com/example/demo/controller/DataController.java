package com.example.demo.controller;

import com.example.demo.model.po.Ship;
import com.example.demo.model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

    // 取得船隻資料
    @GetMapping("/ship")
    public ResponseEntity<ApiResponse<Ship>> getShip() {
        // 模擬船隻資料
        Ship ship = new Ship("Titanic", "郵輪", 280, 30);
        ApiResponse<Ship> apiResponse = new ApiResponse<>(true, "success", ship);
        return ResponseEntity.ok(apiResponse);
    }

    // 取得多筆船隻資料
    @GetMapping("/ships")
    public ResponseEntity<ApiResponse<List<Ship>>> getShips() {
        // 模擬多艘船隻資料
        List<Ship> ships = List.of(
                new Ship("Titanic", "郵輪", 280, 30),
                new Ship("Evergreen", "貨輪", 200, 40),
                new Ship("順風一號", "客船", 30, 10)
        );
        ApiResponse<List<Ship>> apiResponse = new ApiResponse<>(true, "success", ships);
        return ResponseEntity.ok(apiResponse);
    }
}
