# language: pt

@login
Funcionalidade: Login

Como um usuario
Quero realizar login
Para acessar a tela inicial

Contexto:
	Dado que eu acesso a aplicacao
	Quando clico no icone de usuario


Esquema do Cenario: Realizar login com sucesso
	E no campo Username informo "<nome de usuario>"
	E no campo Password informo "<senha>"
	E clico na opcao Sign In
	Entao o sistema exibe o nome do usuario logado no canto superior da tela
	
Exemplos:
| nome de usuario   | senha |
| ContaAdvantageD   |Adva1  |


Esquema do Cenario: Nao realizar login com senha incorreta
	E no campo Username informo "<nome de usuario>"
	E no campo Password informo "<senha>"
	E clico na opcao Sign In
	Entao o sistema mostra a mensagem "<mensagem>"

Exemplos:
| nome de usuario   | senha | mensagem |
| Conta de Teste    | pass  |Incorrect user name or password.|


Esquema do Cenario: Nao realizar login sem os campos obrigatorios
	E no campo Username informo "<nome de usuario>"
	E no campo Password informo "<senha>"
	Entao o sistema mostra a mensagem "<mensagem>" abaixo do campo "<campo>"
	E exibe o botao Sign In desabilitado
	
Exemplos:
| nome de usuario   | senha | mensagem                     | campo  |
|                   | pass  |Username field is required    |username|
| Conta de Teste    |       |Password field is required    |password|


Esquema do Cenario: Relembrar dados do usuario
	E no campo Username informo "<nome de usuario>"
	E no campo Password informo "<senha>"
	E clico na opcao Remember Me
	E clico na opcao Sign In
	E clico no icone de usuario
	E clico na opcao Sign Out
	E clico no icone de usuario
	Entao o sistema exibe os campos "<nome de usuario>" e "<senha>" preenchidos com os dados do ultimo usuario logado
	
Exemplos:
| nome de usuario   | senha |
| ContaAdvantageD   |Adva1  |