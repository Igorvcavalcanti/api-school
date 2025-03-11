# API School

API desenvolvida com Spring Boot para gerenciamento de dados escolares.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

## Estrutura do Projeto
```
api-school/
├── src/
│   ├── main/
│   │   ├── java/org/generation/brazil/school/
│   │   │   ├── configuration/
│   │   │   ├── controller/
│   │   │   ├── domain/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── SchoolApplication.java
│   ├── resources/
│   ├── test/java/org/generation/brazil/school/
```

## Instalação e Execução

### Pré-requisitos
- Java 17+
- Maven
- Banco de dados PostgreSQL configurado

### Passos para Rodar a Aplicação
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/api-school.git
   cd api-school
   ```
2. Configure o **application.properties** com as credenciais do banco de dados.
3. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

## Endpoints
A API conta com endpoints para gerenciar alunos, professores e turmas. Exemplos:

- **GET /alunos** - Retorna a lista de alunos.
- **POST /alunos** - Cadastra um novo aluno.
- **GET /professores** - Retorna a lista de professores.
- **POST /professores** - Cadastra um novo professor.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

---
🚀 Desenvolvido por [Seu Nome]

