package com.example.prova_leo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Define a entidade "Product" que representa uma tabela no banco de dados Room
@Entity(tableName = "products")
public class Product {
    // Chave primária autoincrementada
    @PrimaryKey(autoGenerate = true)
    private int id;
    
    private String name;
    private String code;
    private double price;
    private int quantity;

    // Construtor da classe
    public Product(String name, String code, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}