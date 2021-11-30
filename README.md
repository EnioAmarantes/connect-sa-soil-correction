# connect-sa-soil-correction

Esta Api faz a conexão do projeto soil-corrections para ser servido em qualquer aplicação client.

Para este projeto será utilizado uma arquitetura cliente/servidor onde este projeto conterá o back-end servido pelo framework Spring Boot

O Client foi feito utilizando o Framework Angular e seu repositório está disponível pelo link abaixo:
https://github.com/EnioAmarantes/gui-sa-soilcorrection

Para a API está sendo inicializada uma arquitetura onde é separado a controller que receberá as requisições dos clients e utilizará uma model que se comunicará com o projeto inicial que fornece todos os cálculos, neste projeto foi necessário alterar a sua arquitetura para uma redução de acoplamento separando os pacotes de acordo com as suas responsabilidades conforme orienta-se as boas práticas. 

Para rodar esta aplicação basta seguir os comandos abaixo:

>mvnw spring-boot:run


## TestarAPI
Para testar a API basta fazer uma requisição GET para o endereço raiz, deverá receber a resposta:

>A API SoilCorrectionAPI está funcionando e pronta para comunicar os dados.


## Fósforo
Para Receber os dados calculados de Fósforo basta fazer uma requisição do tipo POST para o endereço da API + /correcaofosforo

Será necessário enviar um objeto com as seguintes caracteristicas pelo body:
> double teor;
> 
> FonteFosforo fonteFosforo;
> 
>	double custoFonte;
>	
>	double eficiencia;

Será devolvido então um resultado com os seguintes campos:

>	double qtdAplicar;
>	
>	double custoHa;
>	
>	Set<NutrienteAdicional> nutrientesAdicionais;


## Potássio
Para Receber os dados calculados de Potássio basta fazer uma requisição do tipo POST para o endereço da API + /correcaopotassio

Será necessário enviar um objeto com as seguintes caracteristicas pelo body:
> double teor;
>
> FontePotassio fontePotassio;
>
>	double custoFonte;
>
>	double eficiencia;

Será devolvido então um resultado com os seguintes campos:

>	double qtdAplicar;
>
>	double custoHa;
>
>	Set<NutrienteAdicional> nutrientesAdicionais;


## Cálcio/Magnésio
Para Receber os dados calculados de Cálcio/Magnésio basta fazer uma requisição do tipo POST para o endereço da API + /correcaocalciomagnesio

Será necessário enviar um objeto com as seguintes caracteristicas pelo body:
> double participacaoAtual;
>
>	double participacaoDesejada;
>
> FonteCalcioMagnesio fonteCalcioMagnesio;
>
> double custoFonte;
>
> double prnt;
>
> double teorCao;
>
> double teorSolo;

Será devolvido então um resultado com os seguintes campos:

>	double qtdAplicar;
>
>	double custoHa;
>
>	Set<NutrienteAdicional> nutrientesAdicionais;
  
## Algumas considerações sobre a Arquitetura

Quando utilizado cada tipo de dado em uma controller separada obtemos uma consulta que em testes levaram 396 ms em média
![image](https://user-images.githubusercontent.com/37565576/144040234-0ea8e486-1e05-48ba-9e2f-da4990642219.png)

Quando se utiliza apenas uma controller repassando a rota esse tempo caiu em testes para 278 ms em média
![image](https://user-images.githubusercontent.com/37565576/144040339-b9bde82b-5ec8-47f5-94fd-bbcc5b3f1ad6.png)

A utilização de herança para os dados de correção e uma única classe de Resultado genérica para retorno reduziu ainda mais a média de tempo nos testes, chegando a 6 ms
![image](https://user-images.githubusercontent.com/37565576/144040453-d70fada7-2c39-4cdd-8c58-32aeada4492e.png)
  
**Estes testes foram realizados em localhost tanto api quanto a requisição, portanto utilizando redes externas esses valores podem ser alterados**
 
## Conclusão
Concluímos que uma centralização das controllers e utilização do recurso de herança e reaproveitamento da classe Resultado levam um ganho significativo de performance para a API, porém vale ressaltar que esta API possui uma gama de 3 tipos de dados que podem ser requisitados o que relativamente não dificulta a manutenção, caso essa quantidade aumente pode significar um aumento da complexidade de manutenção o que se fará necessário repensar a estratégia de separação das classes de controllers e um controle de rotas.
