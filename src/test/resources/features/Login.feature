# language: pt

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
| Nomes             |Mail1  |

Esquema do Cenario: Nao realizar login com senha incorreta
	E no campo Username informo "<nome de usuario>"
	E no campo Password informo "<senha>"
	E clico na opcao Sign In
	Entao o sistema mostra a mensagem "<mensagem>"

Exemplos:
| nome de usuario   | senha | mensagem |
| Conta de Teste    | pass  |Incorrect user name or password.|