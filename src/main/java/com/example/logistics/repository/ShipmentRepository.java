package com.example.logistics.repository;
import com.example.logistics.entity.Shipment;
import com.example.logistics.enums.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ShipmentRepository extends JpaRepository<Shipment,Long> {
    long countByStatus(ShipmentStatus status);
}
