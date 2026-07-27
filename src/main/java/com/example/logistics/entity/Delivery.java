package com.example.logistics.entity;
import com.example.logistics.enums.DeliveryStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="deliveries")
public class Delivery {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private LocalDateTime deliveryDate;
 @Column(nullable=false) private String receivedBy;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private DeliveryStatus status;
 @Column(length=500) private String notes;
 @OneToOne(optional=false) @JoinColumn(name="shipment_id",nullable=false,unique=true) private Shipment shipment;
 public Delivery() {}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public LocalDateTime getDeliveryDate(){return deliveryDate;} public void setDeliveryDate(LocalDateTime d){this.deliveryDate=d;}
 public String getReceivedBy(){return receivedBy;} public void setReceivedBy(String receivedBy){this.receivedBy=receivedBy;}
 public DeliveryStatus getStatus(){return status;} public void setStatus(DeliveryStatus status){this.status=status;}
 public String getNotes(){return notes;} public void setNotes(String notes){this.notes=notes;}
 public Shipment getShipment(){return shipment;} public void setShipment(Shipment shipment){this.shipment=shipment;}
}
