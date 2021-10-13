# language: pt

@consultar_produto
Funcionalidade: Consultar Produto

Como um usuario logado
Quero consultar produtos
Para visualizar os produtos para compra

Contexto: Usuario logado
	Dado que eu acesso a aplicacao
	Quando clico no icone de usuario
	E no campo Username informo "Nomes"
	E no campo Password informo "Mail1"
	E clico na opcao Sign In


Cenario: Consultar produto existente
	E clico no icone de Pesquisa
	E no campo de pesquisa preencho "Tablet"
 	E pressiono a tecla Enter para pesquisar
	E clico em um dos produtos da lista
	Entao o produto eh exibido
	

Esquema do Cenario: Consultar produto inexistente
	E clico no icone de Pesquisa
	E no campo de pesquisa preencho "<produto>"
	E pressiono a tecla Enter para pesquisar
	Entao o sistema exibe mensagem "No results for \"<produto>\""
	
Exemplos:
| produto  |
|computador|


Cenario: Consultar produto por categoria
	E clico na categoria Mice
	E clico no filtro Price
	E seleciono a faixa de preco
	E clico no filtro Scroller Type
	E seleciono o tipo Scroll Ball
	E clico no produto
	Entao a pagina do produto eh exibida