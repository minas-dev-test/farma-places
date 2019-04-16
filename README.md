# api-pda

Projeto criado utilizando Spring-boot, Maven, MongoDB e Docker
  
Rotas:  
- "/pontos_de_apoio" :  
    - get: retorna uma lista(json) com todos os pontos  
    - post: insere um novo ponto enviado em formato json pelo body  
 - "/pontos_de_apoio/{id}"
    - get: retorna o ponto(json) referente ao id
    - put: atualiza o ponto referente ao id, com o json enviado pelo body
    - delete: remove o ponto referente ao id  
 - "/pontos_de_apoio/q/{campo}={param}"
    - get: retorna uma lista resultante da query realizada sobre o {campo} buscando o {param}  
      Ex: "/pontos_de_apoio/q/cidade=juiz" retorna uma lista com todas os PDAs que contem 'juiz' no campo cidade  
      Campos suportados: rua, bairro, cidade, cep

Para compilar, é necessário ter instalado o Maven: https://maven.apache.org/download.cgi
Utilize: 
  - mvn clean install
  
No docker, crie a imagem da api:
  - docker build --rm -f Dockerfile -t api-pda:latest .
  
E faça o compose:
  - docker-compose -f docker-compose.yml up -d --build
