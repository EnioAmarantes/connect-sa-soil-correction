# connect-sa-soil-correction

Esta Api faz a conexão do projeto soil-corrections para ser servido em qualquer aplicação client.

Para este projeto será utilizado uma arquitetura cliente/servidor onde este projeto conterá o back-end servido pelo framework Spring Boot

O Client foi feito utilizando o Framework Angular e seu repositório está disponível pelo link abaixo:
https://github.com/EnioAmarantes/gui-sa-soilcorrection

Para a API está sendo inicializada uma arquitetura onde é separado a controller que receberá as requisições dos clients e utilizará uma model que se comunicará com o projeto inicial que fornece todos os cálculos, neste projeto foi necessário alterar a sua arquitetura para uma redução de acoplamento separando os pacotes de acordo com as suas responsabilidades conforme orienta-se as boas práticas. 

Para rodar esta aplicação basta seguir os comandos abaixo:

>mvnw spring-boot:run