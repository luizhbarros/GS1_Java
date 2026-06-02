# Monitoramento de Recursos da Base Lunar - API Backend

## Descrição do Projeto
API desenvolvida em Java com Spring Boot para o controle dos recursos essenciais da base lunar (sensores, reservatórios, energia, climatização e alertas).

## Integrantes
* Luiz Henrique Barros - **RM:** 561311
* Rafael Lucca Bazan - **RM:** 561920

## Arquitetura
* **Controller:** Endpoints HTTP para operações CRUD.
* **Service:** Lógica de negócio do monitoramento.
* **Repository:** Persistência de dados via Spring Data JPA.
* **Model:** Entidades representativas do sistema.
* **Banco de Dados:** H2 configurado em modo persistente (file mode).