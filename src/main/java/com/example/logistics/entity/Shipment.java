package com.example.logistics.entity;
import com.example.logistics.enums.ShipmentStatus;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity @Table(name="shipments")
public class Shipment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String trackingNumber;
 @Column(nullable=false) private String origin;
 @Column(nullable=false) private String destination;
 @Column(nullable=false) private Double weight;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private ShipmentStatus status;
 private LocalDate expectedDeliveryDate;
 @ManyToOne(optional=false) @JoinColumn(name="customer_id",nullable=false) private Customer customer;
 public Shipment() {}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getTrackingNumber(){return trackingNumber;} public void setTrackingNumber(String trackingNumber){this.trackingNumber=trackingNumber;}
 public String getOrigin(){return origin;} public void setOrigin(String origin){this.origin=origin;}
 public String getDestination(){return destination;} public void setDestination(String destination){this.destination=destination;}
 public Double getWeight(){return weight;} public void setWeight(Double weight){this.weight=weight;}
 public ShipmentStatus getStatus(){return status;} public void setStatus(ShipmentStatus status){this.status=status;}
 public LocalDate getExpectedDeliveryDate(){return expectedDeliveryDate;} public void setExpectedDeliveryDate(LocalDate d){this.expectedDeliveryDate=d;}
 public Customer getCustomer(){return customer;} public void setCustomer(Customer customer){this.customer=customer;}
}
