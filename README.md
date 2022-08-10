# Bridge Fullstack Challenge

Este desafio foi desenvolvido utilizando *React.js* no *frontend* e *Springboot* (Java) no *backend*. Pelo escopo e simplicidade do projeto, não foram adotadas bibliotecas adicionais além de react-router-dom. No *backend*, foi utilizado a biblioteca spring-boot-starter-validation para validar as requisições e h2 como banco de dados.

Para executar o projeto, primeiramente execute localmente o *backend*.

    cd bridge-backend-challenge
    ./mvnw spring-boot:run
Ao executar o *backend*, a API estará disponível via http://localhost:8080/results e http://localhost:8080/calculate.

Agora podemos executar o *frontend* localmente, em outro terminal:

    cd bridge-frontend-challenge
    npm install
    npm start
A aplicação estará disponível em http://localhost:3000.



