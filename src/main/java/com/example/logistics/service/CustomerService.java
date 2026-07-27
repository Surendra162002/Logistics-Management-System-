package com.example.logistics.service;
import com.example.logistics.dto.CustomerRequest; 
import com.example.logistics.entity.Customer; 
import com.example.logistics.exception.ResourceNotFoundException;
import com.example.logistics.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class CustomerService { private final CustomerRepository repo; public CustomerService(CustomerRepository repo){this.repo=repo;}
 public Customer create(CustomerRequest r){return repo.save(map(new Customer(),r));} public List<Customer> all(){return repo.findAll();} public Customer one(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not found: "+id));}
 public Customer update(Long id,CustomerRequest r){return repo.save(map(one(id),r));} public void delete(Long id){repo.delete(one(id));}
 private Customer map(Customer e,CustomerRequest r){e.setName(r.name());e.setEmail(r.email());e.setPhone(r.phone());e.setAddress(r.address());return e;}}
