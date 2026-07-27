package com.example.logistics.service;
import com.example.logistics.dto.WarehouseRequest;
import com.example.logistics.entity.Warehouse;
import com.example.logistics.exception.ResourceNotFoundException;
import com.example.logistics.repository.WarehouseRepository; 
import org.springframework.stereotype.Service; 
import java.util.List;
@Service public class WarehouseService { private final WarehouseRepository repo; public WarehouseService(WarehouseRepository repo){this.repo=repo;}
 public Warehouse create(WarehouseRequest r){return repo.save(map(new Warehouse(),r));} public List<Warehouse> all(){return repo.findAll();} public Warehouse one(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Warehouse not found: "+id));}
 public Warehouse update(Long id,WarehouseRequest r){return repo.save(map(one(id),r));} public void delete(Long id){repo.delete(one(id));}
 private Warehouse map(Warehouse e,WarehouseRequest r){e.setName(r.name());e.setLocation(r.location());e.setCapacity(r.capacity());return e;}}
