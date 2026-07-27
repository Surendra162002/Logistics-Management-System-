package com.example.logistics.scheduler;

import com.example.logistics.entity.Inventory;
import com.example.logistics.enums.ShipmentStatus;
import com.example.logistics.repository.InventoryRepository;
import com.example.logistics.repository.ShipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogisticsScheduler {

    private static final Logger log = LoggerFactory.getLogger(LogisticsScheduler.class);

    private final ShipmentRepository shipmentRepository;
    private final InventoryRepository inventoryRepository;

    public LogisticsScheduler(ShipmentRepository shipmentRepository,
                              InventoryRepository inventoryRepository) {
        this.shipmentRepository = shipmentRepository;
        this.inventoryRepository = inventoryRepository;
    }

    // Runs every day at 8:00 AM.
    @Scheduled(cron = "0 0 8 * * *")
    public void printDailyShipmentSummary() {
        long created = shipmentRepository.countByStatus(ShipmentStatus.CREATED);
        long inTransit = shipmentRepository.countByStatus(ShipmentStatus.IN_TRANSIT);
        long delivered = shipmentRepository.countByStatus(ShipmentStatus.DELIVERED);

        log.info("Daily shipment summary - Created: {}, In transit: {}, Delivered: {}",
                created, inTransit, delivered);
    }

    // Runs every six hours and reports items having ten units or fewer.
    @Scheduled(fixedRate = 21600000)
    public void checkLowStockInventory() {
        List<Inventory> lowStockItems = inventoryRepository.findByQuantityLessThanEqual(10);

        for (Inventory item : lowStockItems) {
            log.warn("Low stock - SKU: {}, Item: {}, Quantity: {}",
                    item.getSku(), item.getItemName(), item.getQuantity());
        }
    }
}
