package com.example.prova_leo;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    private static ProductDatabase instance;

    // Define o DAO que será usado para acessar os dados
    public abstract ProductDao productDao();

    // Método Singleton para garantir apenas uma instância do banco de dados
    public static synchronized ProductDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ProductDatabase.class, "product_database")
                    .fallbackToDestructiveMigration() // Recria o banco se a versão mudar
                    .build();
        }
        return instance;
    }
}