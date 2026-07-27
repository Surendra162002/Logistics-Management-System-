package com.example.logistics.service;
import com.example.logistics.dto.ShipmentRequest;
import com.example.logistics.entity.Shipment; 
import com.example.logistics.exception.ResourceNotFoundException;
import com.example.logistics.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class ShipmentService { private final ShipmentRepository repo; private final CustomerService customers; public ShipmentService(ShipmentRepository repo,CustomerService customers){this.repo=repo;this.customers=customers;}
 public Shipment create(ShipmentRequest r){return repo.save(map(new Shipment(),r));} public List<Shipment> all(){return repo.findAll();} public Shipment one(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Shipment not found: "+id));}
 public Shipment update(Long id,ShipmentRequest r){return repo.save(map(one(id),r));} public void delete(Long id){repo.delete(one(id));}
 private Shipment map(Shipment e,ShipmentRequest r){e.setTrackingNumber(r.trackingNumber());e.setOrigin(r.origin());e.setDestination(r.destination());e.setWeight(r.weight());e.setStatus(r.status());e.setExpectedDeliveryDate(r.expectedDeliveryDate());e.setCustomer(customers.one(r.customerId()));return e;}}
