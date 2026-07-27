package com.example.logistics.repository;
import com.example.logistics.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
    boolean existsByShipmentId(Long shipmentId);
}
