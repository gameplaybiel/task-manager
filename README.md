# 🚀 Task Manager API

![Java](https://img.shields.io/badge/Java-17-%23ED8B00?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-%236DB33F?logo=spring)
![Swagger](https://img.shields.io/badge/Swagger-UI-%2385EA2D?logo=swagger)
![Tests](https://img.shields.io/badge/Tests-3_passed-%2300C853)

API para gerenciamento de tarefas com documentação interativa e testes automatizados.

## 🔍 Documentação da API
Acesse a documentação interativa:  
🔗 [http://localhost:8083/swagger-ui.html](http://localhost:8083/swagger-ui.html)

*(A aplicação deve estar rodando localmente)*

## 📦 Endpoints Principais
| Método | Endpoint       | Descrição               |
|--------|----------------|-------------------------|
| POST   | `/tasks`       | Cria nova tarefa        |
| GET    | `/tasks/{id}`  | Busca tarefa por ID     |
| PUT    | `/tasks/{id}`  | Atualiza tarefa         |
| DELETE | `/tasks/{id}`  | Remove tarefa           |

## 🛠️ Como Executar

### Pré-requisitos
- Java 17
- Maven 3.8+

```bash
# Clone o repositório
git clone https://github.com/gameplaybiel/task-manager.git

# Execute a aplicação
./mvnw spring-boot:run

# Rodar testes
./mvnw test
```

📄 Licença
Este projeto está sob licença MIT. Veja o arquivo LICENSE para detalhes.

## 👨💻 Autor
[![GitHub](https://img.shields.io/badge/GameplayBiel-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/gameplaybiel)  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/gabriel-de-souza-concei%C3%A7%C3%A3o-89a047230/)
