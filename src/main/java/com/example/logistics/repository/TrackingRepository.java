package com.example.logistics.repository;
import com.example.logistics.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TrackingRepository extends JpaRepository<Tracking,Long> {
}
