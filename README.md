# Encurtador de URL em Java 25

Este projeto é um **encurtador de URLs** desenvolvido em **Java 25** com **Spring Boot**, usando **MySQL** dockerizado como banco de dados. Ele permite criar URLs curtas a partir de URLs longas e redirecionar para a URL original usando a URL encurtada.

---

## Tecnologias Utilizadas

- **Java 25**
- **Spring Boot**
- **MySQL** (dockerizado)
- **Docker / Docker Compose**
- **Maven** como gerenciador de dependências

---

## Estrutura da API

### 1. Criar uma URL encurtada

- **Endpoint:** `POST /shorten`
- **Request Body (JSON):**
```json
{
  "url": "https://www.twitch.tv/"
}
```
Response (JSON):
```txt
aCZXCA92
```
### 2. Redirecionar para a URL original
    - Endpoint: GET /{shortCode}
    - Exemplo: GET /aCZXCA92
    Redireciona automaticamente para a URL original associada.

## Banco de Dados

O projeto utiliza MySQL dockerizado. A tabela principal url possui a seguinte estrutura:
```sql
CREATE TABLE url (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    url VARCHAR(2048) NOT NULL,
    shortener_url VARCHAR(255) NOT NULL UNIQUE,
    expire_at DATETIME
);
```

## Rodando com Docker
### 1. Crie um arquivo docker-compose.yml:
```yaml
services:
  mysql:
    image: mysql:latest
    environment:
      MYSQL_ROOT_PASSWORD: admin
      MYSQL_DATABASE: encurtador
      MYSQL_USER: admin
      MYSQL_PASSWORD: admin
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql
volumes:
  mysql_data:
```
Não precisa se preocupar em subir o Docker, ele já será iniciado automaticamente.

### 2. Configure a aplicação Spring Boot (application.properties ou application.yml):
```properties
    spring.application.name=encurtador-url
    spring.datasource.url=jdbc:mysql://mysql:3306/encurtador?useSSL=false&serverTimezone=UTC
    spring.datasource.username=admin
    spring.datasource.password=admin
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.docker.compose.file=docker/compose.yaml
```
### 3. Executando a aplicação
```bash
  mvn clean install
  mvn spring-boot:run
```
A API estará disponível em: http://localhost:8080

## Exemplo de Fluxo
1. Encurtar URL:
```bash
    curl -X POST http://localhost:8080/shorten \
    -H "Content-Type: application/json" \
    -d '{"url":"https://www.twitch.tv/"}'
```
2. Redirecionar:
```bash
   curl -v http://localhost:8080/abc123
```
O navegador ou cliente será redirecionado para https://www.twitch.tv/.% 
