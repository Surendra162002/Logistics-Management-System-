package com.example.logistics.entity;
import jakarta.persistence.*;
@Entity @Table(name="warehouses")
public class Warehouse {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String name;
 @Column(nullable=false) private String location;
 @Column(nullable=false) private Integer capacity;
 public Warehouse() {}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getName(){return name;} public void setName(String name){this.name=name;}
 public String getLocation(){return location;} public void setLocation(String location){this.location=location;}
 public Integer getCapacity(){return capacity;} public void setCapacity(Integer capacity){this.capacity=capacity;}
}
