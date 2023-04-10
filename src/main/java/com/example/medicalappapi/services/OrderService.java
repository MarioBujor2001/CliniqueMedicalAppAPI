package com.example.medicalappapi.services;

import com.example.medicalappapi.models.Order;
import com.example.medicalappapi.models.Patient;
import com.example.medicalappapi.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    PatientService patientService;

    public Order newOrder(String id, Order order) {
        Patient patient = this.patientService.findById(id);
        if(patient!=null){
            order.setPatient(patient);
            order.setDate(LocalDateTime.now());
            this.orderRepo.save(order);
            return order;
        }
        return null;
    }

    public List<Order> findByPacientId(String idPac) {
        return this.orderRepo.findByPatient_IdLike(idPac);
    }

    public List<Order> findAll() {
        return (List<Order>) this.orderRepo.findAll();
    }

    public Order findById(Integer id){
        return this.orderRepo.findById(id).orElse(null);
    }
}
