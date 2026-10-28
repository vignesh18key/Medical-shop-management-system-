package com.example.medicalshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @NotBlank private String name;
    private String category;
    private String manufacturer;
    @DecimalMin("0.0") private double price;
    @Min(0) private int stock;
    private LocalDate expiryDate;
    public Medicine() {}
    public Medicine(String name, String category, String manufacturer, double price, int stock, LocalDate expiryDate) { this.name=name; this.category=category; this.manufacturer=manufacturer; this.price=price; this.stock=stock; this.expiryDate=expiryDate; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getCategory(){return category;} public void setCategory(String category){this.category=category;}
    public String getManufacturer(){return manufacturer;} public void setManufacturer(String manufacturer){this.manufacturer=manufacturer;}
    public double getPrice(){return price;} public void setPrice(double price){this.price=price;}
    public int getStock(){return stock;} public void setStock(int stock){this.stock=stock;}
    public LocalDate getExpiryDate(){return expiryDate;} public void setExpiryDate(LocalDate expiryDate){this.expiryDate=expiryDate;}
}
