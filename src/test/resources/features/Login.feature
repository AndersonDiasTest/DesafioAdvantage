# language: pt

Funcionalidade: Login

Como um usuario
Quero realizar login
Para acessar a tela inicial

Esquema do Cenario: Realizar login com sucesso
	Dado que eu acesso a aplicacao
	Quando clico no icone de usuario
	E no campo Username preencho "<nome de usuario>"
	E no campo Password preencho "<senha>"
	E clico na opcao Sign In
	Entao o sistema exibe o nome do usuario logado no canto superior da tela
	
Exemplos:
| nome de usuario   | senha |
| Nomes             |Mail1  |

@ignore
Esquema do Cenario: Nao realizar login com senha incorreta
	Dado que eu acesso a aplicacao
	Quando clico no icone de usuario
	E no campo Username preencho "<nome de usuario>"
	E no campo Password preencho "<senha>"
	E clico na opcao Sign In
	Entao o sistema exibe a mensagem "<mensagem>"

Exemplos:
| nome de usuario   | senha | mensagem |
| Conta de Teste    | pass  |Incorret user name or password.|