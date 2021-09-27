# language: pt

Funcionalidade: Consultar Produto

Como um usuario logado
Quero consultar produtos
Para visualizar os produtos para compra

Cenario: Consultar produto existente
	Dado que eu acesso a aplicacao
	Quando clico no icone de usuario
	E no campo Username preencho "Nomes"
	E no campo Password preencho "Mail1"
	E clico na opcao Sign In
	E clico no icone de Pesquisa
	E no campo de pesquisa preencho "Tablet"
	E clico na opcao Pesquisar
	E clico em um dos produtos da lista
	Entao o produto eh exibido