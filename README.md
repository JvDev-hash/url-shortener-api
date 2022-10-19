# API Url Shortener

## Sobre
Esta é uma API que tem o objetivo de Encurtar URLs. São utilizadas as tecnologias:

- Java 11
- Maven 3+
- Spring Boot
- Spring Web
- Spring Data JPA
- [Lombok](https://www.devmedia.com.br/uma-visao-sobre-o-projeto-lombok/28321), para redução de código
- [H2](https://www.baeldung.com/spring-boot-h2-database), o BD relacional em memória

Para execução do projeto basta entrar na pasta raiz do projeto e executar `mvn clean install`.

Obs: Para a execução do projeto é necessário que algumas IDEs tenham o plugin do **Lombok**, abaixo segue a instalação do plugin:

- [IntelliJ IDEA / Eclipse](https://www.baeldung.com/lombok-ide)

## Utilização

- `[POST] localhost:8080/api/v1/create-short` - Endpoint de Criação da url encurtada, passando no corpo `longUrl` com a url longa;
- `[GET] localhost:8080/api/v1/{url-curta}` - Endpoint de Acesso à url curta que redirecionará para a url original;
