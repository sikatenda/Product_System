package com.example.productList.product;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;

    @Column(name = "Product_Name", nullable = false, unique = true, length = 25)
    private String prodName;

    @Column(name = "Manufacture_Name", nullable = false, length = 35)
    private String manufacture;

    @Column(name = "Expiring_Date", nullable = false)
    private LocalDate expireDate;

    @Column(name = "Unit_Price", nullable = false)
    private double price;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
