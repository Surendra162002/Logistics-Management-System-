package com.example.logistics.controller;
import com.example.logistics.dto.ShipmentRequest; import com.example.logistics.entity.Shipment; import com.example.logistics.service.ShipmentService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/shipments")
public class ShipmentController { private final ShipmentService service; public ShipmentController(ShipmentService service){this.service=service;}
 @PostMapping public ResponseEntity<Shipment> create(@Valid @RequestBody ShipmentRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
 @GetMapping public List<Shipment> all(){return service.all();} @GetMapping("/{id}") public Shipment one(@PathVariable Long id){return service.one(id);}
 @PutMapping("/{id}") public Shipment update(@PathVariable Long id,@Valid @RequestBody ShipmentRequest request){return service.update(id,request);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
