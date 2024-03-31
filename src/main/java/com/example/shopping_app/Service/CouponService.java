package com.example.shopping_app.Service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;



import com.example.shopping_app.Model.Coupon;
import com.example.shopping_app.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;
//    private CouponRepository CouponRepository;
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Optional<Coupon> getCouponByCode(String code) {
        return couponRepository.findByCode(code);
    }

    public Map<String, Integer> getCoupons() {
        // Assume this method retrieves available coupons from a database or other source
        Map<String, Integer> coupons = new HashMap<>();
        coupons.put("OFF5", 5);
        coupons.put("OFF10", 10);
        return coupons;
    }
    public Map<String, Integer> getAvailableCoupons() {
        List<Coupon> coupons = couponRepository.findAll(); // Fetch all available coupons from the repository
        Map<String, Integer> couponMap = new HashMap<>();
        for (Coupon coupon : coupons) {
            couponMap.put(coupon.getName(), coupon.getDiscountPercentage());
        }
        return couponMap;
    }

}


