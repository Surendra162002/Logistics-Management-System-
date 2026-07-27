package com.example.logistics.controller;
import com.example.logistics.dto.WarehouseRequest;
import com.example.logistics.entity.Warehouse; 
import com.example.logistics.service.WarehouseService; 
import jakarta.validation.Valid; 
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/warehouses")
public class WarehouseController { private final WarehouseService service; public WarehouseController(WarehouseService service){this.service=service;}
 @PostMapping
 public ResponseEntity<Warehouse> create(@Valid @RequestBody WarehouseRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
 @GetMapping 
 public List<Warehouse> all(){return service.all();}
 @GetMapping("/{id}")
public Warehouse one(@PathVariable Long id){return service.one(id);}
 @PutMapping("/{id}")
 public Warehouse update(@PathVariable Long id,@Valid @RequestBody WarehouseRequest request){return service.update(id,request);}
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
