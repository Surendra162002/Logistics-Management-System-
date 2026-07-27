package com.example.logistics.scheduler;

import com.example.logistics.entity.Inventory;
import com.example.logistics.enums.ShipmentStatus;
import com.example.logistics.repository.InventoryRepository;
import com.example.logistics.repository.ShipmentRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class LogisticsSchedulerTest {

    @Test
    void dailyShipmentSummaryTest() {
        ShipmentRepository shipments = mock(ShipmentRepository.class);
        InventoryRepository inventory = mock(InventoryRepository.class);
        LogisticsScheduler scheduler = new LogisticsScheduler(shipments, inventory);

        scheduler.printDailyShipmentSummary();

        verify(shipments).countByStatus(ShipmentStatus.CREATED);
        verify(shipments).countByStatus(ShipmentStatus.IN_TRANSIT);
        verify(shipments).countByStatus(ShipmentStatus.DELIVERED);
    }

    @Test
    void lowStockCheckTest() {
        ShipmentRepository shipments = mock(ShipmentRepository.class);
        InventoryRepository inventory = mock(InventoryRepository.class);
        LogisticsScheduler scheduler = new LogisticsScheduler(shipments, inventory);
        Inventory item = new Inventory();
        item.setItemName("Laptop");
        item.setSku("LAP-101");
        item.setQuantity(5);
        when(inventory.findByQuantityLessThanEqual(10)).thenReturn(List.of(item));

        scheduler.checkLowStockInventory();

        verify(inventory).findByQuantityLessThanEqual(10);
    }
}
