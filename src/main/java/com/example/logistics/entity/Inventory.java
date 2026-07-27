package com.example.logistics.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="inventory")
public class Inventory {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String itemName;
 @Column(nullable=false,unique=true) private String sku;
 @Column(nullable=false) private Integer quantity;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal unitPrice;
 @ManyToOne(optional=false) @JoinColumn(name="warehouse_id",nullable=false) private Warehouse warehouse;
 public Inventory() {}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getItemName(){return itemName;} public void setItemName(String itemName){this.itemName=itemName;}
 public String getSku(){return sku;} public void setSku(String sku){this.sku=sku;}
 public Integer getQuantity(){return quantity;} public void setQuantity(Integer quantity){this.quantity=quantity;}
 public BigDecimal getUnitPrice(){return unitPrice;} public void setUnitPrice(BigDecimal unitPrice){this.unitPrice=unitPrice;}
 public Warehouse getWarehouse(){return warehouse;} public void setWarehouse(Warehouse warehouse){this.warehouse=warehouse;}
}
