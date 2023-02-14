# Denuncias API
## Api de denuncias

#
Executar a aplicação
```sh
docker compose up
```
#
Swagger
```sh
http://localhost:8080/swagger-ui.html#/
```

## Stack

- Java (v17)
- Maven
- Spring Boot (v2.7.8)
- Postgresql
- Swagger
- Junit 
- Docker
- Redis

## Paths - Denuncia

| Função | Caminho |
| ------ | ------ |
| POST | /v1/denuncias |

### Inserção de nova denuncia
POST /v1/denuncias
```
{
    "latitude": double,
    "longitude": double,
    "denunciante": {
        "nome": "string",
        "cpf": "string"
    },
    "denuncia": {
        "titulo": "string",
        "descricao": "string"
    }
}
```
