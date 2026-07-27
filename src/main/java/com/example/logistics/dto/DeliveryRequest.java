package com.example.logistics.dto;
import com.example.logistics.enums.DeliveryStatus; 
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
public record DeliveryRequest(LocalDateTime deliveryDate,@NotBlank String receivedBy,@NotNull DeliveryStatus status,String notes,@NotNull @Positive Long shipmentId) {}
