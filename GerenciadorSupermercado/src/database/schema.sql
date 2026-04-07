-- Banco: MySQL
-- Ajuste o nome do banco conforme `BancoDeDados` (padrão: mydb)
-- Mantém nomes de tabelas/colunas conforme o projeto.

CREATE TABLE IF NOT EXISTS Usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(120) NOT NULL,
  CPF VARCHAR(20) NOT NULL,
  senha VARCHAR(120) NOT NULL,
  tipo BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS Produtos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome_produto VARCHAR(120) NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  qtde_estoque INT NOT NULL,
  descricao VARCHAR(255) NULL
);

