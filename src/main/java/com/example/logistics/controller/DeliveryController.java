package com.example.logistics.controller;
import com.example.logistics.dto.DeliveryRequest; 
import com.example.logistics.entity.Delivery;
import com.example.logistics.service.DeliveryService;
import jakarta.validation.Valid; 
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/delivery")
public class DeliveryController { private final DeliveryService service; public DeliveryController(DeliveryService service){this.service=service;}
 @PostMapping 
 public ResponseEntity<Delivery> create(@Valid @RequestBody DeliveryRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
 @GetMapping
public List<Delivery> all(){return service.all();} 
 @GetMapping("/{id}") 
 public Delivery one(@PathVariable Long id){return service.one(id);}
 @PutMapping("/{id}")
 public Delivery update(@PathVariable Long id,@Valid @RequestBody DeliveryRequest request){return service.update(id,request);}
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
