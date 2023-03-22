package com.api.ascii.product;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "price",
            nullable = false
    )
    private int price;

    @Column(
            name = "batch",
            nullable = false
    )
    private int batch;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "manufacture_date",
            nullable = false
    )
    private LocalDate manufactureDate;

    @Column(
            name = "expiration_date",
            nullable = false
    )
    private LocalDate expirationDate;

    @Column(
            name = "total_count",
            nullable = false
    )
    private int totalCount;

    public ProductModel() {
    }

    public ProductModel(String name, int price, int batch, String description, LocalDate manufactureDate, LocalDate expirationDate, int totalCount) {
        this.name = name;
        this.price = price;
        this.batch = batch;
        this.description = description;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.totalCount = totalCount;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.toLowerCase();
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", batch=" + batch +
                ", description='" + description + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", expirationDate=" + expirationDate +
                ", totalCount=" + totalCount +
                '}';
    }
}
