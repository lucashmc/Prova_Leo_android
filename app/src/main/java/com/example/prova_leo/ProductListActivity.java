package com.example.prova_leo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ProductDatabase database;
    // Executor para buscar os dados em segundo plano
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        // Habilita o botão de voltar na barra superior
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Lista de Produtos");
        }

        database = ProductDatabase.getInstance(this);

        // Configuração do RecyclerView
        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);

        // Carrega a lista do banco de dados
        loadProducts();
    }

    private void loadProducts() {
        executorService.execute(() -> {
            // Obtém todos os produtos do banco de dados
            List<Product> products = database.productDao().getAllProducts();
            // Atualiza a interface gráfica na thread principal
            runOnUiThread(() -> {
                adapter.setProducts(products);
            });
        });
    }

    // Configura a ação do botão de voltar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Fecha a Activity atual e volta para a anterior
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}