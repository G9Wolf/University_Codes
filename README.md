# University_Codes

rabalho realizado na disciplina de " ANÁLISE E PROJETO DE ALGORITMOS " pelo estudante GABRIEL RITTA CORREIA - UNIPAMPA CAMPUS BAGÉ

Este código recebe 3 documentos TXT sendo estes:

1 - Uma lista de compras , no formato -> (( FORNECEDOR - NOTA ))

Exemplo:  

Peruzzo 5
Nicoline 6
Nacional 7
Nicoline 8

É realizada uma média das notas para saber a nota média da empresa "todas compras realizadas adicionam novas notas a empresa, estas influenciam na nota 
final da empresa"

// 2 - Uma lista de compras , no formato -> (( ITEM - QUANTIDADE ))

Exemplo:

Banana 4
Massa  1
Farinha 2
Arroz 2

// 3 - Uma lista de itens disponíveis, no formato -> (( FORNECEDOR - PRODUTO - VALOR ))

Exemplo:

Nicoline Banana 3,5
Nacional Farinha 5
Peruzzo Arroz 8
Nacional Arroz 7,5

Após a leitura destes documentos "todos alocados dinamicamente", é criada a tabelaT, onde esta compoem:

Exemplo:  (( FORNECEDOR - PRODUTO - VALOR - NOTAMÉDIA ))

Nicoline Banana 3,5 (NOTAMÉDIA)
Nacional Farinha 5 (NOTAMÉDIA) 
Peruzzo Arroz 8 (NOTAMÉDIA)
Nacional Arroz 7,5 (NOTAMÉDIA)

Por fim, o cliente entra qual valor máximo deseja pagar por esta compra, o software então,
irá calcular qual é a compra com o menor preço a se pagar.




