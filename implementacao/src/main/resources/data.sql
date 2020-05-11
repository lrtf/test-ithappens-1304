INSERT INTO PRODUTO(CODIGO_PRODUTO, DESCRICAO, CODIGO_BARRAS, VALOR_UNITARIO)
VALUES 
(1, 'PAO QUEIJO SAO GERALDO TRAD 1KG', '07896074603215', 10.29),
(2, 'GRANOLA TIA SONIA LIGHT 200G', '07898115750650', 6.69),
(3, 'CAFE 3 CORACOES EXT FORTE AVAC 250G', '07896005801819', 3.89),
(4, 'FAR TRIGO D BENTA SFERM 1KG', '07896005202074', 3.89),
(5, 'OVOS GALINHA AVINE BC G', '07896304100149', 15.99),
(6, 'LEITE L VIDA ITALAC INT CTAMPA 1L', '07898080640611', 4.55),
(7, 'SARDINHA 88 OLEO 125G', '07891167023017', 2.79);

INSERT INTO FILIAL(CODIGO_FILIAL, CNPJ, NOME)
VALUES
(1, '03995515004154', 'MATEUS SUPERMERCADOS CENTRO CAJAZEIRAS'),
(2, '03995515004155', 'MATEUS SUPERMERCADOS COHAMA'),
(3, '03995515004156', 'MATEUS SUPERMERCADOS SHOPPING DA ILHA');

INSERT INTO ESTOQUE(CODIGO_ESTOQUE, QUANTIDADE, FK_PRODUTO_CODIGO_PRODUTO, FK_FILIAL_CODIGO_FILIAL)
VALUES
(1, 50, 1, 1),
(2, 28, 2, 1),
(3, 17, 3, 1),
(4, 34, 6, 2);

INSERT INTO USUARIO(CODIGO_USUARIO, NOME, MATRICULA, PERFIL)
VALUES
(1, 'DARTH VADER', '202001', 'USER'),
(2, 'LUKE SKYWALKER', '202002', 'USER'),
(3, 'YODA', '202003', 'ADMIN');

INSERT INTO CLIENTE(CODIGO_CLIENTE, NOME, CPF, TELEFONE, CELULAR, EMAIL, LOGRADOURO, COMPLEMENTO, CEP , CIDADE, BAIRRO)
VALUES
(1, 'BRUNO CORREIA GONCALVES', '170.428.350-77', '', '(51) 95056-8157', 'BRUNMUITAOCORREIAGONCALVES@DAYREP.COM', 'RUA JAQUIRANA, 288', 'APTO', '94060-350', 'GRAVATAÍ-RS', 'CENTRO'),
(2, 'VITOR ROCHA CARDOSO', '801.019.014-45', '', '(11) 97269-2836', 'VITORROCHACARDOSO@DAYREP.COM', 'TRAVESSA BOM JESUS DA LAPA, 1393', 'BL C', '02311-070', 'SÃO PAULO-SP', 'CENTRO'),
(3, 'SOPHIA MARTINS FERREIRA', '334.633.893-20 ', '', '(12) 99075-3830', 'SOPHIAMARTINSFERREIRA@RHYTA.COM ', 'RUA SÃO PEDRO, 1328', 'CASA AZUL', '12445-020 ', 'PINDAMONHANGABA-SP', 'CENTRO');

INSERT INTO PEDIDO_ESTOQUE(CODIGO_PEDIDO, TIPO, FK_FILIAL_CODIGO_FILIAL, FK_USUARIO_CODIGO_USUARIO, FK_CLIENTE_CODIGO_CLIENTE, OBSERVACAO_ENTREGA)
VALUES
(1, 'SAIDA', 1, 2, 1, 'ENTREGAR NA PORTARIA');

INSERT INTO ITENS_PEDIDO(ITEM, FK_PRODUTO_CODIGO_PRODUTO, QUANTIDADE, VALOR_UNITARIO, TOTAL, STATUS, FK_PEDIDO_ESTOQUE_CODIGO_PEDIDO)
VALUES
(1, 2, 2, 6.69, 13.38 ,'ATIVO', 1),
(2, 3, 4, 3.89, 7.78,'ATIVO', 1),
(3, 3, 4, 3.89, 7.78,'CANCELADO', 1);

INSERT INTO FORMA_PAGAMENTO (CODIGO, DESCRICAO) VALUES (1, 'A VISTA'), (2, 'BOLETO'),(3, 'CARTAO');
