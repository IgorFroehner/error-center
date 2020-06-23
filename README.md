### Projeto Final do AceleraDev Java Online da Codenation

### links úteis:
https://spring.io/guides/tutorials/bookmarks/
https://www.baeldung.com/spring-date-parameters
https://www.baeldung.com/spring-boot-formatting-json-dates

# Central de Erros

Em projetos modernos é cada vez mais comum o uso de arquiteturas baseadas em serviços ou microsserviços. Nestes ambientes complexos, erros podem surgir em diferentes camadas da aplicação (backend, frontend, mobile, desktop) e mesmo em serviços distintos. Desta forma, é muito importante que os desenvolvedores possam centralizar todos os registros de erros em um local, de onde podem monitorar e tomar decisões mais acertadas. Neste projeto vamos implementar uma API Rest para centralizar registros de erros de aplicações.

Abaixo estão os requisitos desta API, o time terá total liberdade para tomar as decisões técnicas e de arquitetura da API, desde que atendam os requisitos abaixo.


# API

### Premissas:

* Pensada para atender diretamente um front-end
* Capaz de gravar logs de erro em um banco de dados relacional
* Acesso apenas por requisições com token

### Funcionalidades

- [x] Deve permitir a autenticação do sistema que deseja utilizar a API gerando o Token de Acesso
- [x] Pode ser acessado por multiplos sistemas
- [ ] Deve permitir gravar registros de eventos de log salvando informações de Level(error, warning, info), Descrição do Evento, LOG do Evento, ORIGEM(Sistema ou Serviço que originou o evento), DATA(Data do evento), QUANTIDADE(Quantidade de Eventos de mesmo tipo)
- [x] Deve permitir a listagem dos eventos juntamente com a filtragem de eventos por qualquer parâmetro especificado acima
- [x] Deve suportar Paginação
- [ ] Deve suportar Ordenação por diferentes tipos de atributos
- [x] A consulta de listagem não deve retornar os LOGs dos Eventos
- [ ] Deve permitir a busca de um evento por um ID, dessa maneira exibindo o LOG desse evento em específico

### Endpoint

* **Event:**
    * Event: save
    * Event: update
    * void: delete
    * Event: findById
    * List<Event> findAll
    * List<Event> findByOrigin
    * List<Event> findByOriginAndDate
    * List<Event> findByLevel
    * List<Event> findByLevelAndDate
    * List<Event> findByLevelAndDateAndOrigin
    * List<Event> findByDescription
    * List<Event> findByLog
    * List<Event> findByDate

* **Origin**
    * Origin save
    * Origin update
    * void delete
    * Origin findById
    * Origin findByLogin
