## 🚀 Diferenciais Técnicos (O que há sob o capô)

Diferente de um CRUD básico, esta API implementa padrões arquiteturais de nível enterprise:

* **Arquitetura em Camadas:** Separação clara entre Controller (Interface), Service (Business Logic) e Repository (Data Access).
* **Global Exception Handling:** Tratamento centralizado de erros, garantindo que o cliente da API (Mobile/Web) receba mensagens claras e códigos HTTP semânticos (400, 409, 500).
* **Data Integrity:** Restrições de unicidade e validações no nível de banco de dados e aplicação.
* **Offline Simulation:** Configurada com banco de dados em memória (H2) para prototipagem rápida e testes de integração.

## 🛠 Tech Stack

* **Linguagem:** Kotlin 2.2+ (Utilizando expressividade e Null-Safety)
* **Framework:** Spring Boot 4.0.1
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** H2 Database (In-memory)
* **Documentação:** OpenAPI 3 / Swagger UI
* **Gerenciador de Dependências:** Maven

## 🏗 Arquitetura do Projeto

```mermaid
graph TD;
    Client[Client: Mobile/Web] -->|JSON| Controller[LeitoController];
    Controller -->|DTO| Service[LeitoService];
    Service -->|Regras de Negócio| Repository[LeitoRepository];
    Repository <-->|Entity| DB[(H2 Database)];
    
    Handler[GlobalExceptionHandler] -.->|Intercepta Erros| Controller;