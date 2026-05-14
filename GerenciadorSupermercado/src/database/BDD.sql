DROP DATABASE IF EXISTS mydb;
CREATE DATABASE mydb;
USE mydb;

CREATE TABLE Produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(100) UNIQUE NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    qtde_estoque INT NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    CPF CHAR(11) UNIQUE NOT NULL,
    senha VARCHAR(20) NOT NULL,
    admin BOOLEAN NOT NULL
);

CREATE TABLE Carrinho (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    data_compra TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_carrinho_usuario FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
    CONSTRAINT fk_carrinho_produto FOREIGN KEY (produto_id) REFERENCES Produtos(id)
);