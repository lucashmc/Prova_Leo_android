# 📱 Cadastro de Produtos - Aplicativo Android

## 📌 Descrição do Projeto

Este projeto consiste no desenvolvimento de um aplicativo Android simples para uma loja de produtos eletrônicos, com o objetivo de substituir o controle manual (em caderno) por um sistema digital.

O aplicativo permite **cadastrar produtos** e **visualizar uma lista dos itens cadastrados**, facilitando o gerenciamento do estoque.

---

## 🎯 Objetivo

Criar um aplicativo funcional utilizando **Android Studio** com **Java/Kotlin** e **Room Database**, contendo no mínimo duas telas:

* Tela de Cadastro de Produto
* Tela de Listagem de Produtos

---

## ⚙️ Funcionalidades

### ✅ Cadastro de Produto

O usuário pode cadastrar um produto informando:

* Nome do produto
* Código do produto (alfanumérico)
* Preço (em reais)
* Quantidade em estoque

### 🔒 Validações

* Nenhum campo pode ficar vazio
* O campo **Preço**:

  * Deve aceitar apenas números positivos
  * Máximo de duas casas decimais
* O campo **Quantidade**:

  * Deve aceitar apenas números inteiros positivos

---

### 📋 Listagem de Produtos

* Exibição dos produtos cadastrados
* Informações exibidas:

  * Nome
  * Código
  * Preço
* Possibilidade de retornar à tela de cadastro

---

## 🗄️ Persistência de Dados

O aplicativo utiliza o **Room Database** para armazenamento local.

### Estrutura:

* **Entity**: `Product`
* **DAO**: `ProductDao`

  * Método de inserção
  * Método de listagem
* **Database**: `ProductDatabase`

---

## 🧩 Tecnologias Utilizadas

* Android Studio
* Java ou Kotlin
* Room Database
* Componentes de UI do Android (EditText, Button, RecyclerView, etc.)

---

## 🖥️ Interface

O aplicativo possui uma interface simples e funcional, contendo:

* Campos de entrada com `EditText`
* Botões para ações
* Lista de produtos com `RecyclerView`
* Navegação entre telas (Activities ou Fragments)

---

## 🔄 Navegação

* Tela de Cadastro ➜ Tela de Listagem
* Tela de Listagem ➜ Retorno para Cadastro

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Abra o projeto no Android Studio

3. Aguarde o download das dependências

4. Execute o projeto em um emulador ou dispositivo físico

---

## 📁 Estrutura Básica do Projeto

```
📦 app
 ┣ 📂 data
 ┃ ┣ 📜 Product.kt / Product.java
 ┃ ┣ 📜 ProductDao.kt / ProductDao.java
 ┃ ┗ 📜 ProductDatabase.kt / ProductDatabase.java
 ┣ 📂 ui
 ┃ ┣ 📜 MainActivity (Cadastro)
 ┃ ┗ 📜 ListActivity (Listagem)
 ┗ 📂 adapter
   ┗ 📜 ProductAdapter
```

---

## 👨‍💻 Autor

Projeto desenvolvido para fins acadêmicos na disciplina de desenvolvimento Android.

---

## 📄 Licença

Este projeto é apenas para fins educacionais.
