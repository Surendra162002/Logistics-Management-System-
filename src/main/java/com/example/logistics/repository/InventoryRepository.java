package com.example.logistics.repository;
import com.example.logistics.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    List<Inventory> findByQuantityLessThanEqual(Integer quantity);
}
