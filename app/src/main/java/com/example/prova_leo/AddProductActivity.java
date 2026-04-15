package com.example.prova_leo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddProductActivity extends AppCompatActivity {

    // Componentes da interface
    private EditText editTextName, editTextCode, editTextPrice, editTextQuantity;
    private Button buttonSave, buttonToList;
    
    // Banco de dados Room
    private ProductDatabase database;
    
    // Executor para rodar as tarefas em segundo plano (evitar travar a UI)
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        // Inicializa a instância do banco de dados
        database = ProductDatabase.getInstance(this);

        // Vincula os componentes do layout às variáveis
        editTextName = findViewById(R.id.editTextName);
        editTextCode = findViewById(R.id.editTextCode);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        buttonSave = findViewById(R.id.buttonSave);
        buttonToList = findViewById(R.id.buttonToList);

        // Configura o clique do botão de salvar
        buttonSave.setOnClickListener(v -> saveProduct());

        // Configura o clique para abrir a lista de produtos
        buttonToList.setOnClickListener(v -> {
            Intent intent = new Intent(AddProductActivity.this, ProductListActivity.class);
            startActivity(intent);
        });
    }

    private void saveProduct() {
        // Obtém os dados inseridos
        String name = editTextName.getText().toString().trim();
        String code = editTextCode.getText().toString().trim();
        String priceStr = editTextPrice.getText().toString().trim();
        String quantityStr = editTextQuantity.getText().toString().trim();

        // Validação: Nenhum campo em branco
        if (name.isEmpty() || code.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            // Validação: Preço positivo
            if (price <= 0) {
                Toast.makeText(this, "O preço deve ser maior que zero", Toast.LENGTH_SHORT).show();
                return;
            }
            
            // Validação: Quantidade positiva
            if (quantity <= 0) {
                Toast.makeText(this, "A quantidade deve ser um número inteiro positivo", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cria o objeto produto
            Product product = new Product(name, code, price, quantity);

            // Salva no banco de dados em uma thread separada
            executorService.execute(() -> {
                database.productDao().insert(product);
                // Volta para a thread principal para mostrar o Toast
                runOnUiThread(() -> {
                    Toast.makeText(AddProductActivity.this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    clearFields();
                });
            });

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Preço ou quantidade inválidos", Toast.LENGTH_SHORT).show();
        }
    }

    // Limpa os campos após salvar
    private void clearFields() {
        editTextName.setText("");
        editTextCode.setText("");
        editTextPrice.setText("");
        editTextQuantity.setText("");
    }
}