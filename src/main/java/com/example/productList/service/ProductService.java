package com.example.productList.service;


import com.example.productList.product.Product;
import com.example.productList.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired private ProductRepository repo;

    public List<Product> listAll(){
        return (List<Product>) repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product get(Integer id) throws ProductNotFounfException {
        Optional<Product> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ProductNotFounfException("could not find a product with ID " + id);
    }

    public void delete(Integer id) throws ProductNotFounfException {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new ProductNotFounfException("could not find a product with ID " + id);
        }
        repo.deleteById(id);
    }

}
