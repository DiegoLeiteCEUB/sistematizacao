# SISTEMATIZAÇÃO
UniCEUB - Análise e Desenvolvimento de Sistemas EAD <br/>
Disciplina: Programação Orientada a Objetos <br/>
Professor: Leonardo Rebouças de Carvalho <br/>
Aluno: Diego dos Santos Leite - RA 72350086 <br/>
<br/>
<b> API  para gerenciamento do cadastro de entregadores da empresa Dianome </b> <br/>
Construída com o framework Spring, esta aplicação soluciona o problema nr. 1 proposto na sistematização. <br/>
<br/>
<b> Instruções para operação </b> <br/>
Executar a classe EntregadoresApplication em uma máquina virtual Java, com banco de dados MySQL instalado. <br/>
Aviso: não foi implementada uma camada de visão para esta API, apenas os controladores e repositório, com o respectivo modelo de dados. <br/>
Seu acionamento ocorre por meio de requisições HTTP simples, com as seguintes funcionalidades:
1) Saudação inicial: acessar http://localhost:8080
2) Cadastrar um entregador: http://localhost:8080/entregadores (método POST)
   - Exemplo de formulário JSON válido: {"cpf":"11122233344","nome":"Fulano de Tal","capacidadeVeiculo":"9999.99"}
4) Listar todos os entregadores cadastrados: http://localhost:8080/entregadores (método GET)
5) Detalhar um entregador específico: http://localhost:8080/entregadores/# (método GET)
   - Onde # é o número de identificação recebido no momento do cadastramento.
7) Atualizar o cadastro de um entregador: http://localhost:8080/entregadores/# (método PUT)
   - Onde # é o número de identificação recebido no momento do cadastramento.
   - Utiliza o mesmo formulário de cadastramento.
9) Excluir um entregador do cadastro: http://localhost:8080/entregadores/# (método DELETE)
   - Onde # é o número de identificação recebido no momento do cadastramento. <br/>
<br/>
Todas as funcionalidades acima podem ser testadas por meio de um cliente REST, como o Postman. <br/>
<br/>
<b> Requisitos </b> <br/>
- Java 21 <br/>
- MySQL Server <br/>
- Database: dianome <br/>
- Username: root <br/>
- Password: admin <br/>
