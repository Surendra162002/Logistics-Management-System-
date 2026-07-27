package com.example.logistics.service;
import com.example.logistics.dto.DeliveryRequest; 
import com.example.logistics.entity.Delivery; 
import com.example.logistics.enums.ShipmentStatus; 
import com.example.logistics.exception.ResourceNotFoundException;
import com.example.logistics.repository.DeliveryRepository;
import org.springframework.stereotype.Service; 
import java.time.LocalDateTime; 
import java.util.List;
@Service public class DeliveryService { private final DeliveryRepository repo; private final ShipmentService shipments; public DeliveryService(DeliveryRepository repo,ShipmentService shipments){this.repo=repo;this.shipments=shipments;}
 public Delivery create(DeliveryRequest r){if(repo.existsByShipmentId(r.shipmentId()))throw new IllegalArgumentException("Delivery already exists for shipment: "+r.shipmentId()); Delivery d=repo.save(map(new Delivery(),r)); if(d.getStatus().name().equals("DELIVERED")){d.getShipment().setStatus(ShipmentStatus.DELIVERED);} return d;}
 public List<Delivery> all(){return repo.findAll();} public Delivery one(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Delivery not found: "+id));}
 public Delivery update(Long id,DeliveryRequest r){Delivery old=one(id); if(!old.getShipment().getId().equals(r.shipmentId())&&repo.existsByShipmentId(r.shipmentId()))throw new IllegalArgumentException("Delivery already exists for shipment: "+r.shipmentId()); return repo.save(map(old,r));} public void delete(Long id){repo.delete(one(id));}
 private Delivery map(Delivery e,DeliveryRequest r){e.setDeliveryDate(r.deliveryDate()==null?LocalDateTime.now():r.deliveryDate());e.setReceivedBy(r.receivedBy());e.setStatus(r.status());e.setNotes(r.notes());e.setShipment(shipments.one(r.shipmentId()));return e;}}
