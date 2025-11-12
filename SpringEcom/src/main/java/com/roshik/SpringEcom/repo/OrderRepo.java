package com.roshik.SpringEcom.repo;

import com.roshik.SpringEcom.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    Optional<Order> findByOrderId(String orderId);
}
