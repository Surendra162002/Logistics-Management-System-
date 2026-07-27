package com.example.logistics.dto;
import com.example.logistics.enums.ShipmentStatus; 
import jakarta.validation.constraints.*; 
import java.time.LocalDate;
public record ShipmentRequest(@NotBlank String trackingNumber,@NotBlank String origin,@NotBlank String destination,@NotNull @Positive Double weight,@NotNull ShipmentStatus status,LocalDate expectedDeliveryDate,@NotNull @Positive Long customerId) {}
