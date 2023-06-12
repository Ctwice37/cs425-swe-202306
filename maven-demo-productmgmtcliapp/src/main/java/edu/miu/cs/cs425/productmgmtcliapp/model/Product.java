package edu.miu.cs.cs425.productmgmtcliapp.model;

import java.time.LocalDate;

public class Product {
    private Long productId;
    private String name;
    private Double unitPrice;
    private LocalDate dateSupplied;

    public Product(Long productId, String name, Double unitPrice, LocalDate dateSupplied) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.dateSupplied = dateSupplied;
    }

    public Product() {
        this(null, null, null, null);
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", dateSupplied=" + dateSupplied +
                '}';
    }
}
