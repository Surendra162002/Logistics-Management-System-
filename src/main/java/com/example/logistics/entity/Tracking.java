package com.example.logistics.entity;
import com.example.logistics.enums.TrackingStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="tracking_updates")
public class Tracking {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String location;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private TrackingStatus status;
 @Column(nullable=false) private LocalDateTime updatedAt;
 @Column(length=500) private String remarks;
 @ManyToOne(optional=false) @JoinColumn(name="shipment_id",nullable=false) private Shipment shipment;
 public Tracking() {}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getLocation(){return location;} public void setLocation(String location){this.location=location;}
 public TrackingStatus getStatus(){return status;} public void setStatus(TrackingStatus status){this.status=status;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
 public String getRemarks(){return remarks;} public void setRemarks(String remarks){this.remarks=remarks;}
 public Shipment getShipment(){return shipment;} public void setShipment(Shipment shipment){this.shipment=shipment;}
}
