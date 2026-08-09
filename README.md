# VIZIOON-TODOIST-JAVA-BACKEND

API REST de tarefas (projeto Todoist da aula Java/StackUp).

## Rodar local

```bash
./mvnw spring-boot:run
```

- API: `http://localhost:8080/api/tarefa`
- Health: `http://localhost:8080/health`
- H2 Console: `http://localhost:8080/h2-console` (JDBC: `jdbc:h2:mem:todoist`, user: `daniel`, senha: `1234`)

## Endpoints

| Método | URL | Ação |
|--------|-----|------|
| GET | `/api/tarefa` | Lista todas |
| GET | `/api/tarefa/{id}` | Busca por id |
| POST | `/api/tarefa` | Cria tarefa |
| PUT | `/api/tarefa/{id}` | Atualiza tarefa |
| DELETE | `/api/tarefa/{id}` | Remove tarefa |
| GET | `/health` | Status do serviço |

## Exemplo JSON (POST / PUT)

```json
{
  "nome": "Estudar Java",
  "descricao": "Revisar JPA",
  "lembrete": "2026-08-15"
}
```

O campo `lembrete` é **data** (`LocalDate`), formato `AAAA-MM-DD`.

## Package Java

`com.vizioon.todoist`
