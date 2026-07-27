package com.example.logistics.repository;
import com.example.logistics.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WarehouseRepository extends JpaRepository<Warehouse,Long> {
}
