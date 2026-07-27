package com.example.logistics.service;

import com.example.logistics.dto.*;
import com.example.logistics.entity.*;
import com.example.logistics.enums.*;
import com.example.logistics.exception.ResourceNotFoundException;
import com.example.logistics.repository.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LogisticsServiceTests {

    @Test
    void customerCreateTest() {
        CustomerRepository repository = mock(CustomerRepository.class);
        CustomerService service = new CustomerService(repository);
        CustomerRequest request = new CustomerRequest(
                "Ravi", "ravi@email.com", "9876543210", "Hyderabad");

        when(repository.save(any(Customer.class))).thenAnswer(call -> call.getArgument(0));

        Customer result = service.create(request);

        assertEquals("Ravi", result.getName());
        assertEquals("ravi@email.com", result.getEmail());
        verify(repository).save(any(Customer.class));
    }

    @Test
    void warehouseNotFoundTest() {
        WarehouseRepository repository = mock(WarehouseRepository.class);
        WarehouseService service = new WarehouseService(repository);
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.one(99L));
    }

    @Test
    void inventoryCreateTest() {
        InventoryRepository repository = mock(InventoryRepository.class);
        WarehouseService warehouseService = mock(WarehouseService.class);
        InventoryService service = new InventoryService(repository, warehouseService);
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        when(warehouseService.one(1L)).thenReturn(warehouse);
        when(repository.save(any(Inventory.class))).thenAnswer(call -> call.getArgument(0));

        Inventory result = service.create(new InventoryRequest(
                "Laptop", "LAP-101", 20, new BigDecimal("45000"), 1L));

        assertEquals("LAP-101", result.getSku());
        assertEquals(warehouse, result.getWarehouse());
    }

    @Test
    void shipmentCreateTest() {
        ShipmentRepository repository = mock(ShipmentRepository.class);
        CustomerService customerService = mock(CustomerService.class);
        ShipmentService service = new ShipmentService(repository, customerService);
        Customer customer = new Customer();
        customer.setId(1L);
        when(customerService.one(1L)).thenReturn(customer);
        when(repository.save(any(Shipment.class))).thenAnswer(call -> call.getArgument(0));

        Shipment result = service.create(new ShipmentRequest(
                "TRK1001", "Hyderabad", "Vijayawada", 5.5,
                ShipmentStatus.CREATED, LocalDate.now().plusDays(2), 1L));

        assertEquals("TRK1001", result.getTrackingNumber());
        assertEquals(customer, result.getCustomer());
    }

    @Test
    void trackingUsesCurrentTimeWhenTimeIsMissingTest() {
        TrackingRepository repository = mock(TrackingRepository.class);
        ShipmentService shipmentService = mock(ShipmentService.class);
        TrackingService service = new TrackingService(repository, shipmentService);
        Shipment shipment = new Shipment();
        shipment.setId(1L);
        when(shipmentService.one(1L)).thenReturn(shipment);
        when(repository.save(any(Tracking.class))).thenAnswer(call -> call.getArgument(0));

        Tracking result = service.create(new TrackingRequest(
                "Hyderabad Hub", TrackingStatus.IN_TRANSIT, null, "Moving", 1L));

        assertNotNull(result.getUpdatedAt());
        assertEquals(shipment, result.getShipment());
    }

    @Test
    void deliveryDuplicateShipmentTest() {
        DeliveryRepository repository = mock(DeliveryRepository.class);
        ShipmentService shipmentService = mock(ShipmentService.class);
        DeliveryService service = new DeliveryService(repository, shipmentService);
        when(repository.existsByShipmentId(1L)).thenReturn(true);

        DeliveryRequest request = new DeliveryRequest(
                null, "Ravi", DeliveryStatus.DELIVERED, "Received", 1L);

        assertThrows(IllegalArgumentException.class, () -> service.create(request));
        verify(repository, never()).save(any(Delivery.class));
    }
}
