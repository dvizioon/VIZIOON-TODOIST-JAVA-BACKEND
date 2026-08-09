# VIZIOON-TODOIST-JAVA-BACKEND

API REST de tarefas (projeto Todoist da aula Java/StackUp).

## Rodar local

```bash
./mvnw spring-boot:run
```

- API: `http://localhost:8080/api/tarefa`
- Health: `http://localhost:8080/health`
- H2 Console: `http://localhost:8080/h2-console` (JDBC: `jdbc:h2:mem:todoist`, user: `daniel`, senha: `1234`)

## Deploy no Render

1. Crie o repo **`VIZIOON-TODOIST-JAVA-BACKEND`** no GitHub e suba este projeto.
2. No [Render](https://render.com): **New +** → **Web Service** → conecte o repo.
3. **Runtime:** Docker
4. **Health Check Path:** `/health`
5. Deploy.

### Monorepo (ex.: dentro de `AULA JAVA - STACKUP`)

Se o código ficar em subpasta, defina **Root Directory** no Render (ex.: `Projeto/h2/h2`).

### Variáveis de ambiente (opcional)

| Variável | Padrão | Descrição |
|----------|--------|-----------|
| `PORT` | `8080` | Render define automaticamente |
| `SPRING_DATASOURCE_URL` | `jdbc:h2:mem:todoist` | URL do banco |
| `SPRING_DATASOURCE_USERNAME` | `daniel` | Usuário do banco |
| `SPRING_DATASOURCE_PASSWORD` | `1234` | Senha do banco |
| `H2_CONSOLE_ENABLED` | `true` | Console web `/h2-console` |
| `SPRING_JPA_SHOW_SQL` | `true` | SQL no log |

> Banco H2 em memória: dados somem ao reiniciar o serviço. Para produção, use PostgreSQL.

## Endpoints

| Método | URL | Ação |
|--------|-----|------|
| GET | `/api/tarefa` | Lista todas |
| GET | `/api/tarefa/{id}` | Busca por id |
| POST | `/api/tarefa` | Cria tarefa |
| PUT | `/api/tarefa/{id}` | Atualiza tarefa |
| DELETE | `/api/tarefa/{id}` | Remove tarefa |
| GET | `/health` | Status do serviço |

## Package Java

`com.vizioon.todoist`
