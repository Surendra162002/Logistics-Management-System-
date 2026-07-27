package com.example.logistics.entity;
import jakarta.persistence.*;import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAudit{
@CreatedDate @Column(updatable=false) private LocalDateTime createdAt;
@LastModifiedDate private LocalDateTime updatedAt;
public LocalDateTime getCreatedAt(){return createdAt;}
public LocalDateTime getUpdatedAt(){return updatedAt;}
}
