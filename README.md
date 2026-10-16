# LojaTrab

## Nome do sistema
LojaTrab.

## Objetivo
Gerenciar operações básicas de uma loja de brinquedos, incluindo cadastro de dados, consulta de informações e movimentação de compras.

## Domínio escolhido
Loja de brinquedos.

## Integrantes
- Andrew Mikael de Souza Rodrigues.

## Principais funcionalidades
- Cadastro, edição e exclusão de produtos.
- Cadastro, edição e exclusão de clientes.
- Cadastro, edição e exclusão de funcionários.
- Consulta de produtos por faixa etária e faixa de preço.
- Consulta de funcionários por ocupação e faixa salarial.
- Consulta do histórico de compras com filtros por cliente, status e valor.
- Registro de compras com carrinho, cálculo de subtotal/total e forma de pagamento (Cartão/Pix).
- Finalização de compra (status concluído) e cancelamento de compra (com devolução ao estoque).

## Lista das entidades
- Cliente
- Funcionario
- Produto
- Compra
- ItemCompra
- FormaPagamento
- PagamentoCartao
- PagamentoPix
- Status
- FaixaEtaria
- Ocupacao

## Lista dos cadastros
- Cadastro de Produtos.
- Cadastro de Clientes.
- Cadastro de Funcionários.

## Lista das consultas
- Consulta de Produtos.
- Consulta de Funcionários.
- Consulta de Histórico de Compras.

## Lista dos movimentos
- Comprar (inclusão de itens no carrinho e finalização da compra).
- Cancelar Compra.
- Finalizar compra pendente no histórico.

## Instruções para execução
### Opção 1: Eclipse
1. Importe o projeto Java existente.
2. Execute a classe `app.Main`.

### Opção 2: Linha de comando
1. Acesse a pasta do código-fonte:
   ```bash
   cd /home/runner/work/LojaTrab/LojaTrab/LojaTrab
   ```
2. Compile:
   ```bash
   mkdir -p bin
   javac -d bin $(find src -name "*.java")
   ```
3. Execute:
   ```bash
   java -cp bin app.Main
   ```
