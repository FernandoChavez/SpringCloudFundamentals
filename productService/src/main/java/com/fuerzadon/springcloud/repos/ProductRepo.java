package com.fuerzadon.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuerzadon.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long > {

}
