package com.example.logistics.controller;
import com.example.logistics.dto.TrackingRequest;
import com.example.logistics.entity.Tracking; 
import com.example.logistics.service.TrackingService; 
import jakarta.validation.Valid;
import org.springframework.http.*; 
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/tracking")
public class TrackingController { private final TrackingService service; public TrackingController(TrackingService service){this.service=service;}
 @PostMapping 
 public ResponseEntity<Tracking> create(@Valid @RequestBody TrackingRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
 @GetMapping 
 public List<Tracking> all(){return service.all();}
 @GetMapping("/{id}")
 public Tracking one(@PathVariable Long id){return service.one(id);}
 @PutMapping("/{id}")
 public Tracking update(@PathVariable Long id,@Valid @RequestBody TrackingRequest request){return service.update(id,request);}
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
