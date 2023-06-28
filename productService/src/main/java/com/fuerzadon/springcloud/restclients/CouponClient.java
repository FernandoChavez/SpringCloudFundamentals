package com.fuerzadon.springcloud.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fuerzadon.springcloud.model.Coupon;

//We create a feign rest client in a interface using "application id" in eureka server. We wil use it to do a getRequest, getting
//a discount code storaged in database
@FeignClient("COUPON-SERVICE")
public interface CouponClient {
	
	@GetMapping("/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);
}
