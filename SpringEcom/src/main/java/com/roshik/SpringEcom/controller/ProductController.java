package com.roshik.SpringEcom.controller;

import com.roshik.SpringEcom.model.Product;
import com.roshik.SpringEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

   @GetMapping("/products")
    public List<Product> products(){
       return productService.getAllProducts();
   }

}
