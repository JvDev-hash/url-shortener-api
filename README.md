# API Url Shortener

## Sobre
Esta é uma API que tem o objetivo de Encurtar URLs. São utilizadas as tecnologias:

- Java 11
- Maven 3+
- Spring Boot
- Spring Web
- Spring Data JPA
- [Lombok](https://www.devmedia.com.br/uma-visao-sobre-o-projeto-lombok/28321), para redução de código
- [H2](https://www.baeldung.com/spring-boot-h2-database), BD relacional em memória

Para execução do projeto basta entrar na pasta raiz do projeto e executar `mvn clean install`.

Obs: Em alguns casos é necessário que algumas IDEs tenham o plugin do **Lombok**, abaixo segue a instalação do plugin:

- [IntelliJ IDEA / Eclipse](https://www.baeldung.com/lombok-ide)

## Utilização

- `[POST] /shortener/create-short` - Endpoint de Criação da url encurtada, passando no corpo `longUrl` com a url longa;
- `[GET] /shortener/{url-curta}` - Endpoint de Acesso à url curta que redirecionará para a url original;
- `[GET] /shortener/statistics` - Endpoint de Acesso às estatísticas de quantos acessos às urls encurtadas;
- `[DELETE] /shortener/{url-curta}` - Endpoint para deletar uma url encurtada;
