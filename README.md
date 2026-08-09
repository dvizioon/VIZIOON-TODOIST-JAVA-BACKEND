<h1 align="center">VIZIOON-TODOIST-JAVA-BACKEND</h1>

<p align="center">
  API REST de <strong>tarefas</strong>, CRUD completo com Spring Boot, JPA e H2<br />
  Projeto Todoist da aula Java · StackUp
</p>

<p align="center">
  <img src="https://img.shields.io/badge/SPRING_BOOT-4.0.7-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
  <img src="https://img.shields.io/badge/JAVA-21-EA2D2E?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/MAVEN-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
  <br />
  <img src="https://img.shields.io/badge/JPA-Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />
  <img src="https://img.shields.io/badge/H2-1C9CD8?style=for-the-badge&logo=h2&logoColor=white" />
  <img src="https://img.shields.io/badge/DOCKER-2496ED?style=for-the-badge&logo=docker&logoColor=white" />
</p>

---

## Links

- [Repositório](https://github.com/dvizioon/VIZIOON-TODOIST-JAVA-BACKEND)

---

## Funcionalidades

- **CRUD completo:** Criar, listar, buscar, atualizar e deletar tarefas.
- **JPA + H2:** Entidade `Tarefa` mapeada para tabela; id auto incremento (`GenerationType.IDENTITY`).
- **JSON automático:** Spring converte objetos Java e JSON nas requisições.
- **CORS:** Rotas `/api/**` liberadas para front e Postman.
- **Health check:** Endpoint `/health` para monitoramento.
- **Docker:** Build pronto para container.

## Tecnologias Utilizadas

- **Spring Boot 4:** API REST, injeção de dependências, servidor embutido.
- **Spring Data JPA:** `JpaRepository` com métodos prontos (`findAll`, `save`, `deleteById`).
- **H2:** Banco em memória para desenvolvimento e demo.
- **Java 21:** Linguagem e runtime.
- **Maven:** Build e dependências.
- **Docker:** Imagem multi-stage para deploy.

> [!IMPORTANT]
> O campo `id` é gerado pelo banco ao criar (`POST`). Não envie `id` no body da criação.

> [!NOTE]
> H2 em memória: os dados somem ao reiniciar o serviço.

## Model `Tarefa`: tipos dos dados

| Campo | Tipo Java | Tipo JSON | Exemplo |
|-------|-----------|-----------|---------|
| `id` | `Long` | `number` | `1` |
| `nome` | `String` | `string` | `"Estudar Java"` |
| `descricao` | `String` | `string` | `"Revisar JPA"` |
| `lembrete` | `LocalDate` | `string` (data) | `"2026-08-15"` |

**Package:** `com.vizioon.todoist.model`

## Endpoints

| Método | URL | Ação |
|--------|-----|------|
| `GET` | `/api/tarefa` | Lista todas |
| `GET` | `/api/tarefa/{id}` | Busca por id |
| `POST` | `/api/tarefa` | Cria tarefa |
| `PUT` | `/api/tarefa/{id}` | Atualiza tarefa |
| `DELETE` | `/api/tarefa/{id}` | Remove tarefa |
| `GET` | `/health` | Status do serviço |

## Exemplo JSON (`POST` / `PUT`)

```json
{
  "nome": "Estudar Java",
  "descricao": "Revisar JPA",
  "lembrete": "2026-08-15"
}
```

## Estrutura do Projeto

```bash
src/main/java/com/vizioon/todoist/
│
├── TodoistApplication.java      # Classe principal (@SpringBootApplication)
├── config/
│   └── CorsConfig.java          # CORS para /api/**
├── controller/
│   ├── TarefaController.java  # Rotas REST
│   └── HealthController.java    # GET /health
├── model/
│   └── Tarefa.java              # Entidade JPA (@Entity, @Id)
└── repository/
    └── TarefaRepository.java    # extends JpaRepository<Tarefa, Long>
```

## Instalação

### Desenvolvimento local

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/dvizioon/VIZIOON-TODOIST-JAVA-BACKEND
   cd VIZIOON-TODOIST-JAVA-BACKEND
   ```

2. **Execute:**

   ```bash
   ./mvnw spring-boot:run
   ```

3. **Acesse:**

   | Recurso | URL local |
   |---------|-----------|
   | API | `http://localhost:8080/api/tarefa` |
   | Health | `http://localhost:8080/health` |
   | H2 Console | `http://localhost:8080/h2-console` |

   **H2 Console:** JDBC `jdbc:h2:mem:todoist`, user `daniel`, senha `1234`

### Docker

```bash
docker build -t vizioon-todoist-java-backend .
docker run -p 8080:8080 vizioon-todoist-java-backend
```

## Contato

Dúvidas e suporte: [danielmartinsjob@gmail.com](mailto:danielmartinsjob@gmail.com)

**Créditos:** Desenvolvido por Daniel Estevão · **DVIZIOON**

## Licença

[![License: MIT](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](https://opensource.org/licenses/MIT)
