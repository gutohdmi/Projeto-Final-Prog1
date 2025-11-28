# Projeto-Final-Prog1
Quiosque de Autoatendimento em Java

Este projeto consiste no desenvolvimento de um sistema de quiosque de autoatendimento utilizando a linguagem Java e os conceitos da programação orientada a objetos. A aplicação simula o funcionamento de um quiosque utilizado em restaurantes e lancherias, permitindo ao cliente realizar pedidos e ao gestor acompanhar e gerenciar os atendimentos.

Tecnologias Utilizadas

Java
JavaFX
Maven
VS Code

Funcionalidades

Área do Cliente
Visualização dos produtos disponíveis
Adição e remoção de itens do pedido
Visualização do valor total da compra
Confirmação do pedido com geração de número de atendimento

Área do Gestor
Visualização de todos os atendimentos
Acompanhamento do status dos pedidos
Atualização do status do atendimento

Estrutura do Projeto

O projeto está organizado em pacotes conforme as responsabilidades de cada parte do sistema:

model contém as classes de domínio do sistema
repository contém as classes responsáveis pelos dados
service contém a lógica de controle dos pedidos
ui contém as classes da interface gráfica
resources contém os arquivos FXML da interface

Como Executar o Projeto

Certifique-se de ter instalado o Java JDK 17 ou superior.
Tenha o Maven configurado no seu ambiente.
Abra o projeto no VS Code ou em uma IDE de sua preferência.
Importe o projeto como um projeto Maven.
Execute a classe principal App localizada no pacote com.feevale.ui.

Ao iniciar a aplicação, a interface gráfica será exibida com as telas de cliente e gestor disponíveis em abas.

Como Testar o Sistema

Na aba de cliente, selecione um produto, defina a quantidade e clique em adicionar.
Repita o processo para incluir mais itens no pedido.
Confira o valor total exibido na tela.
Clique em confirmar pedido para gerar um novo atendimento.
Na aba de gestor, visualize o pedido gerado.
Altere o status do pedido conforme o andamento.

Observações

O sistema foi desenvolvido com foco na aplicação dos conceitos de orientação a objetos, como encapsulamento, herança, polimorfismo, interfaces e uso de coleções. O projeto possui fins acadêmicos e pode ser facilmente expandido para cenários reais.
