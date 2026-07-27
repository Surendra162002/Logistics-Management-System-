package com.example.logistics.dto;
import com.example.logistics.enums.TrackingStatus;
import jakarta.validation.constraints.*; 
import java.time.LocalDateTime;
public record TrackingRequest(@NotBlank String location,@NotNull TrackingStatus status,LocalDateTime updatedAt,String remarks,@NotNull @Positive Long shipmentId) {}
