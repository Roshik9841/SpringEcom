package com.roshik.SpringEcom.controller;

import com.roshik.SpringEcom.model.Product;
import com.roshik.SpringEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

   @GetMapping("/products")
    public ResponseEntity<List<Product>> products(){
       return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
   }
   @GetMapping("/product/{id}")
   public ResponseEntity<Product> getProductById(@PathVariable int id){
       Product product = productService.getProductById(id);
        if(product!=null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

   }

   @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
       try {


           Product savedProduct = productService.addProduct(product, imageFile);

           return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
       }catch(IOException e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }

   }

}
