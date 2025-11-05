package com.roshik.SpringEcom.repo;

import com.roshik.SpringEcom.model.Product;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface ProductRepo extends JpaRepository<Product,Integer> {

}
