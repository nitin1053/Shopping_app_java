package com.example.shopping_app.Controller;

import com.example.shopping_app.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public ResponseEntity<Map<String, Integer>> fetchCoupons() {
        Map<String, Integer> coupons = couponService.getAvailableCoupons();
        return new ResponseEntity<>(coupons, HttpStatus.OK);
    }
}

