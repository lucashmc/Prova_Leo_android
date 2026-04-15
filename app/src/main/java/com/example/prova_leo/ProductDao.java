package com.example.prova_leo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
    // Insere um novo produto no banco de dados
    @Insert
    void insert(Product product);

    // Retorna a lista de todos os produtos cadastrados
    @Query("SELECT * FROM products")
    List<Product> getAllProducts();
}