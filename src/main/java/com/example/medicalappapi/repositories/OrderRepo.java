package com.example.medicalappapi.repositories;

import com.example.medicalappapi.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Integer> {
    List<Order> findByPatient_IdLike(String id);
}
