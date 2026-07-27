package com.example.logistics.dto;
import jakarta.validation.constraints.*;
public record WarehouseRequest(@NotBlank String name,@NotBlank String location,@NotNull @Positive Integer capacity) {}
