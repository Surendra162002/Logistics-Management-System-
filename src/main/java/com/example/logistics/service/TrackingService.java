package com.example.logistics.service;
import com.example.logistics.dto.TrackingRequest; 
import com.example.logistics.entity.Tracking;
import com.example.logistics.exception.ResourceNotFoundException; 
import com.example.logistics.repository.TrackingRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime; 
import java.util.List;
@Service public class TrackingService { private final TrackingRepository repo; private final ShipmentService shipments; public TrackingService(TrackingRepository repo,ShipmentService shipments){this.repo=repo;this.shipments=shipments;}
 public Tracking create(TrackingRequest r){return repo.save(map(new Tracking(),r));} public List<Tracking> all(){return repo.findAll();} public Tracking one(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Tracking entry not found: "+id));}
 public Tracking update(Long id,TrackingRequest r){return repo.save(map(one(id),r));} public void delete(Long id){repo.delete(one(id));}
 private Tracking map(Tracking e,TrackingRequest r){e.setLocation(r.location());e.setStatus(r.status());e.setUpdatedAt(r.updatedAt()==null?LocalDateTime.now():r.updatedAt());e.setRemarks(r.remarks());e.setShipment(shipments.one(r.shipmentId()));return e;}}
