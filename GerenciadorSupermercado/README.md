## GerenciadorSupermercado (MVC)

Projeto de Práticas em Desenvolvimento de Sistemas II (IFSC) usando MVC, Java Swing + MySQL.

### Requisitos (runtime)

- Java (JDK)
- MySQL
- Driver MySQL (`mysql-connector-j`) no classpath do projeto

### Banco de dados

- Por padrão a aplicação conecta em:
  - URL: `jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC`
  - Usuário: `root`
  - Senha: `admin`
- Script de criação: `src/database/schema.sql`

Você pode sobrescrever via propriedades do Java:

- `-DDB_URL=...`
- `-DDB_USER=...`
- `-DDB_PASS=...`

### Fluxo / Telas

- **Login** (tela inicial): nome + CPF
- **Cadastro de Usuário**: Cliente/Administrador + senha
- **Administrador**: cadastro/edição/remoção/listagem de produtos
- **Cliente**: compra com carrinho, total e emissão de nota fiscal (na tela e em alerta)
- **Deslogar**: botão em telas de admin e cliente

### Executar

Execute a classe `view.JFrame` (ela inicializa `view.MainFrame`).

