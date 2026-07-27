package com.example.logistics.controller;
import com.example.logistics.dto.CustomerRequest;
import com.example.logistics.entity.Customer;
import com.example.logistics.service.CustomerService; 
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/customers")
public class CustomerController { private final CustomerService service; public CustomerController(CustomerService service){this.service=service;}
 @PostMapping 
 public ResponseEntity<Customer> create(@Valid @RequestBody CustomerRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
 @GetMapping 
 public List<Customer> all(){return service.all();} 
 @GetMapping("/{id}") 
 public Customer one(@PathVariable Long id){return service.one(id);}
 @PutMapping("/{id}"
		 ) public Customer update(@PathVariable Long id,@Valid @RequestBody CustomerRequest request){return service.update(id,request);}
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
