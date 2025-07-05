# Sistema de Tickets - Spring Boot

Este projeto foi convertido com sucesso de um projeto Java simples para uma aplicação Spring Boot completa com REST API, persistência de dados e arquitetura em camadas.

## � Funcionalidades

- **API REST completa** para gerenciamento de tickets, usuários e departamentos
- **Persistência de dados** com JPA/Hibernate e banco H2
- **Arquitetura em camadas** (Controller, Service, Repository, Entity, DTO)
- **Inicialização automática de dados** para facilitar testes
- **Console H2** para visualização do banco de dados
## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6 ou superior

### Compilar e Executar
```bash
# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

### Console do Banco H2
Para visualizar o banco de dados: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## 📊 API Endpoints

### Tickets
- `GET /api/tickets` - Lista todos os tickets
- `GET /api/tickets/{id}` - Busca ticket por ID
- `GET /api/tickets/user/{userId}` - Lista tickets de um usuário
- `GET /api/tickets/status/{status}` - Lista tickets por status
- `POST /api/tickets` - Cria novo ticket
- `PUT /api/tickets/{id}` - Atualiza ticket
- `DELETE /api/tickets/{id}` - Remove ticket

### Usuários
- `GET /api/users` - Lista todos os usuários
- `GET /api/users/{id}` - Busca usuário por ID
- `GET /api/users/email/{email}` - Busca usuário por email
- `GET /api/users/department/{departmentId}` - Lista usuários de um departamento
- `POST /api/users` - Cria novo usuário
- `PUT /api/users/{id}` - Atualiza usuário
- `DELETE /api/users/{id}` - Remove usuário

### Departamentos
- `GET /api/departments` - Lista todos os departamentos
- `GET /api/departments/{id}` - Busca departamento por ID
- `GET /api/departments/code/{code}` - Busca departamento por código
- `POST /api/departments` - Cria novo departamento
- `PUT /api/departments/{id}` - Atualiza departamento
- `DELETE /api/departments/{id}` - Remove departamento

## 🧪 Testando a API

### Exemplos com curl

```bash
# Listar todos os tickets
curl http://localhost:8080/api/tickets

# Buscar ticket específico
curl http://localhost:8080/api/tickets/1

# Listar usuários
curl http://localhost:8080/api/users

# Listar departamentos
curl http://localhost:8080/api/departments
```

## 🏗️ Arquitetura

### Tecnologias Utilizadas
- **Spring Boot 3.2.0** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST
- **H2 Database** - Banco de dados em memória
- **Hibernate** - ORM
- **Maven** - Gerenciamento de dependências
- **Jackson** - Serialização JSON

## � Dados Iniciais

A aplicação inicializa automaticamente com dados de exemplo:

### Departamentos
- **Tecnologia** (código: TEC)
- **Atendimento** (código: ATD)

### Usuários
- **Junior Backes** - Departamento Tecnologia
- **Junior Backes 2** - Departamento Atendimento

### Tickets
- 2 tickets de exemplo vinculados aos usuários acima

## ✅ Status da Conversão

**CONVERSÃO CONCLUÍDA COM SUCESSO!** ✅

A aplicação foi completamente convertida de um projeto Java simples para uma aplicação Spring Boot moderna com:

- ✅ API REST funcionando
- ✅ Persistência com JPA/H2
- ✅ Arquitetura em camadas
- ✅ DTOs para transferência de dados
- ✅ Queries otimizadas com JOIN FETCH
- ✅ Dados de exemplo inicializados
- ✅ Console H2 para visualização
- ✅ Documentação completa

---

**A aplicação está pronta para uso e desenvolvimento!** 🎉
