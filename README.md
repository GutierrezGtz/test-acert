# test-acert
Aplicação Spring Boot 

Foi utilizado um banco  H2 em memoria
Para acessa  http://localhost:8080/h2-console
o servidor inicializa com 5 registros "fake" na base 
Para acessar o swagger  http://localhost:8080/swagger-ui.html

Protocolos de comunicação 

GET /calculator/list
{}

POST /calculator/convert
{
   "origin": valores aceitos "celsius" ou "fahrenheit",
	 "originValue":(valor em graus long)
}
