# language: pt

@cadastro_usuario
Funcionalidade: Cadastro de usuario

Como um usuario
Quero realizar meu cadastro no sistema
Para realizar login

Contexto:
	Dado que eu acesso a aplicacao
	Quando clico no icone de usuario
	E clico na opcao Create New Account

@ignore
Esquema do Cenario: Realizar cadastro com sucesso
	E no campo Username preencho "<nome de usuario>"
	E no campo Email preencho "<email>"
	E no campo Password preencho "<senha>"
	E no campo Confirm Password preencho "<confirmacao senha>"
	E no campo First Name preencho "<primeiro nome>"
	E no campo Last Name preencho "<ultimo nome>"
	E no campo Phone Number preencho "<telefone>"
	E no campo Country preencho "<pais>"
	E no campo City preencho "<cidade>"
	E no campo Address preencho "<endereco>"
	E no campo State Province Region preencho "<estado>"
	E no campo Postal Code preencho "<cep>"
	E verifico que a opcao Receber ofertas esta marcada
	E clico na opcao Aceitar termos
	E clico na opcao Register
	Entao o sistema realiza o login do usuario e exibe o nome no canto superior da tela
	E direciona para a home page
	
Exemplos:
| nome de usuario   | email        | senha  | confirmacao senha  | primeiro nome | ultimo nome | telefone | pais | cidade | endereco | estado | cep |
|ContaAdvantageD    |teste@mail.com|Adva1   |Adva1               |Lucio          |Mauro        |9999      |Brazil|Brasilia|Centro    |DF      |72000|

@ignore
Esquema do Cenario: Não realizar cadastro sem os campos obrigatorios
	E no campo Username preencho "<nome de usuario>"
	E no campo Email preencho "<email>"
	E no campo Password preencho "<senha>"
	E no campo Confirm Password preencho "<confirmacao senha>"
	E no campo First Name preencho "<primeiro nome>"
	E no campo Last Name preencho "<ultimo nome>"
	E no campo Phone Number preencho "<telefone>"
	E no campo Country preencho "<pais>"
	E no campo City preencho "<cidade>"
	E no campo Address preencho "<endereco>"
	E no campo State Province Region preencho "<estado>"
	E no campo Postal Code preencho "<cep>"
	E verifico que a opcao Receber ofertas esta marcada
	E clico na opcao Aceitar termos
	Entao o sistema exibe a mensagem "<mensagem>" abaixo do campo "<campo>"
	E a opcao Register fica desabilitado

Exemplos:
| nome de usuario   | email    | senha | confirmacao senha | primeiro nome | ultimo nome | telefone | pais | cidade | endereco | estado | cep |        mensagem                  |campo|
|                   |teste@mail|Adv1   |Adv1               |Jose           |Adriano      |9999      |Brazil|Brasilia|Centro    |DF      |72000|Username field is required        |usernameRegisterPage|
|Conta de Teste     |          |Adv1   |Adv1               |Jose           |Adriano      |9999      |Brazil|Brasilia|Centro    |DF      |72000|Email field is required           |emailRegisterPage|
|Conta de Teste     |teste@mail|       |Adv1               |Jose           |Adriano      |9999      |Brazil|Brasilia|Centro    |DF      |72000|Password field is required        |passwordRegisterPage|
|Conta de Teste     |teste@mail|Adv1   |                   |Jose           |Adriano      |9999      |Brazil|Brasilia|Centro    |DF      |72000|Confirm password field is required|confirm_passwordRegisterPage|


Esquema do Cenario: Realizar cadastro de um usuario que ja existe
	E no campo Username preencho "<nome de usuario>"
	E no campo Email preencho "<email>"
	E no campo Password preencho "<senha>"
	E no campo Confirm Password preencho "<confirmacao senha>"
	E no campo First Name preencho "<primeiro nome>"
	E no campo Last Name preencho "<ultimo nome>"
	E no campo Phone Number preencho "<telefone>"
	E no campo Country preencho "<pais>"
	E no campo City preencho "<cidade>"
	E no campo Address preencho "<endereco>"
	E no campo State Province Region preencho "<estado>"
	E no campo Postal Code preencho "<cep>"
	E verifico que a opcao Receber ofertas esta marcada
	E clico na opcao Aceitar termos
	E clico na opcao Register
	Entao o sistema exibe a mensagem "<mensagem>"

Exemplos:
| nome de usuario   | email        | senha | confirmacao senha | primeiro nome | ultimo nome | telefone | pais | cidade | endereco | estado | cep | mensagem |
|Nomes              |mail@mail.com |Mail1  |Mail1              |Jose           |Adriano      |9999      |Brazil|Brasilia|Centro    |DF      |72000|User name already exists|


#Cenario: Realizar cadastro de um usuario que ja existe com massa de testes do Excel
#	E preencho o campo "Username"
#	E preencho o campo "Email"
#	E preencho o campo "Password"
#	E preencho o campo "Confirm Password"
#	E preencho o campo "First Name"
#	E preencho o campo "Last Name"
#	E preencho o campo "Phone Number"
#	E preencho o campo "Country"
#	E preencho o campo "City"
#	E preencho o campo "Address"
#	E preencho o campo "State Province Region"
#	E preencho o campo "Postal Code"
#	E verifico que a opcao "Receber Ofertas" esta marcada
#	E clico na opcao "Aceitar Termos"
#	E clico na opcao Register
#	Entao o sistema exibe a "Mensagem"