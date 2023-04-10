package com.example.medicalappapi.controllers;

import com.example.medicalappapi.models.Order;
import com.example.medicalappapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<Iterable<Order>> getOrders(@RequestParam(required = false) String idPac){
        if(idPac!=null && !idPac.isEmpty()){
            return ResponseEntity.ok(this.orderService.findByPacientId(idPac));
        }
        return ResponseEntity.ok(this.orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Integer id){
        return ResponseEntity.ok(this.orderService.findById(id));
    }
}
