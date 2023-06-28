package com.fuerzadon.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fuerzadon.springcloud.model.Coupon;
import com.fuerzadon.springcloud.model.Product;
import com.fuerzadon.springcloud.repos.ProductRepo;
import com.fuerzadon.springcloud.restclients.CouponClient;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	
	//We used feigh client to make clients in interfaces, in this case CouponClient interface, and I make dependency injection
	@Autowired
	CouponClient couponClient;
	
	@Autowired
	private ProductRepo repo;
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	private Product create(@RequestBody Product product) {
		//We get a coupon code from couponService storage in database at coupon table, CouponClient created by feigh
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		
		//We get the difference or subtract between product price and discount
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		
		return repo.save(product);
	}
}
