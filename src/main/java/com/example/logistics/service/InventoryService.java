package com.example.logistics.service;
import com.example.logistics.dto.InventoryRequest; 
import com.example.logistics.entity.Inventory; 
import com.example.logistics.exception.ResourceNotFoundException;
import com.example.logistics.repository.InventoryRepository; 
import org.springframework.stereotype.Service; 
import java.util.List;
@Service public class InventoryService { private final InventoryRepository repo; private final WarehouseService warehouses; public InventoryService(InventoryRepository repo,WarehouseService warehouses){this.repo=repo;this.warehouses=warehouses;}
 public Inventory create(InventoryRequest r){return repo.save(map(new Inventory(),r));} public List<Inventory> all(){return repo.findAll();} public Inventory one(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory not found: "+id));}
 public Inventory update(Long id,InventoryRequest r){return repo.save(map(one(id),r));} public void delete(Long id){repo.delete(one(id));}
 private Inventory map(Inventory e,InventoryRequest r){e.setItemName(r.itemName());e.setSku(r.sku());e.setQuantity(r.quantity());e.setUnitPrice(r.unitPrice());e.setWarehouse(warehouses.one(r.warehouseId()));return e;}}
