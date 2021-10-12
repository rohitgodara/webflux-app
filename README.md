# cat-services-api
Resources::
//https://spring.io/blog/2018/12/07/reactive-programming-and-relational-databases
//https://docs.spring.io/spring-framework/docs/5.0.0.M5/spring-framework-reference/html/web-reactive.html
//https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-exception-handler
//https://docs.spring.io/spring-data/r2dbc/docs/current-SNAPSHOT/reference/html/#r2dbc.entityoperations

why R2DBC was created is the need for a non-blocking application stack to handle concurrency with a small number of threads 
and scale with fewer hardware resources. This need cannot be satisfied by reusing standardized relational database access 
APIs — namely JDBC –- as JDBC is a fully blocking API. Attempts to compensate for blocking behavior with a ThreadPool are of 
limited use.


