package com.example.productList.controller;


import com.example.productList.product.Product;
import com.example.productList.service.ProductNotFounfException;
import com.example.productList.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ListController {

    @Autowired private ProductService service;
    
    @GetMapping("/product")
    public String showList(Model model){
        List<Product> listProduct = service.listAll();
        model.addAttribute("listProduct", listProduct);
        return "product";
    }

    @GetMapping("/product/new")
    public String showForm(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("pageTitle","Add new product");
        return "form";
    }

    @PostMapping("/product/save")
    public String saveInput(Product product, RedirectAttributes ra){
        service.save(product);
        ra.addFlashAttribute("message", "Product successfully saved");
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model,RedirectAttributes ra){
       try {
           Product product = service.get(id);
           model.addAttribute("product", product);
           model.addAttribute("pageTitle","Edit product (ID : " + id +")");
           return "form";
       } catch (ProductNotFounfException e){
           ra.addFlashAttribute("message",e.getMessage());
           return "redirect:/product";
       }
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            service.delete(id);
            ra.addFlashAttribute("message","Product " + id + " is deleted");
        } catch (ProductNotFounfException e){
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/product";
    }

}
