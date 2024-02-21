package com.example.productList.repository;

import com.example.productList.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("select count(p) from Product p")
    long countById(Integer id);
}
