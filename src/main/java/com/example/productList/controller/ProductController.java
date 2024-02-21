package com.example.productList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("")
    public String homePage(){
        return "index";
    }

}
