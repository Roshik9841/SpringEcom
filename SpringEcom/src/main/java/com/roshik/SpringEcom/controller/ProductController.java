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
           Product savedProduct = productService.addOrUpdateProduct(product, imageFile);

           return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
       }catch(IOException e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }

   }

   @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
       Product product = productService.getProductById(productId);

       return new ResponseEntity<>(product.getImageData(),HttpStatus.OK);
   }

   @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile){
       try{
           Product updatedProduct = productService.updateProduct(product,imageFile);
           return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
       }catch(IOException e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }

   }

   @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
       Product product= productService.getProductById(id);
       if(product!=null){
           productService.deleteProduct(id);
           return new ResponseEntity<>("Deleted",HttpStatus.OK);
       }else{
           return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
       }

   }

}
