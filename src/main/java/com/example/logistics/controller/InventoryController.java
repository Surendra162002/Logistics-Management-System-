package com.example.logistics.controller;
import com.example.logistics.dto.InventoryRequest;
import com.example.logistics.entity.Inventory;
import com.example.logistics.service.InventoryService; 
import jakarta.validation.Valid; 
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*; 
import java.util.List;
@RestController @RequestMapping("/api/inventory")
public class InventoryController { private final InventoryService service; public InventoryController(InventoryService service){this.service=service;}
 @PostMapping
 public ResponseEntity<Inventory> create(@Valid @RequestBody InventoryRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
 @GetMapping
 public List<Inventory> all(){return service.all();} 
 @GetMapping("/{id}") 
 public Inventory one(@PathVariable Long id){return service.one(id);}
 @PutMapping("/{id}")
 public Inventory update(@PathVariable Long id,@Valid @RequestBody InventoryRequest request){return service.update(id,request);}
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
