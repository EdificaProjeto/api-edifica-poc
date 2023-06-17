# api-edifica-poc

## Descrição do Projeto

Esse repositório é um projeto de demonstração de uma API para cadastro e visualização de materiais em reformas ou obras. Esta API permite o cadastro e organização de materiais (por meio da Curva ABC) utilizados em projetos de construção, fornecendo uma interface eficiente e fácil de usar para gerenciar informações relacionadas a esses materiais.

### Principais Recursos

- **CRUD de Materiais:** A API permite o cadastro de diferentes tipos de materiais utilizados em reformas e obras, como pisos, azulejos, tintas, ferramentas, entre outros. Cada material pode ser registrado com informações detalhadas, como nome, preço e quantidade, além de que qualquer material pode ser modificado ou excluído.

- **Consulta de Materiais:** Através da API, é possível realizar consultas para obter informações sobre os materiais cadastrados. 

- **Organização de Projetos:** Além do CRUD e consulta de materiais, a API também oferece a organização desse materiais de uma forma diferente, utilizando uma regra de negócio (Curva ABC) para organizar os materiais de acordo com seus estoque e preço.

### Tecnologias Utilizadas

- **Linguagem de Programação:** O API esta sendo desenvolvida em **Java**, aproveitando as vantagens da linguagem para construir uma API robusta e de alto desempenho.

- **Framework:** Utilizamos o **Spring Boot** como framework principal para o desenvolvimento da API. O Spring Boot oferece uma estrutura sólida e uma vasta gama de ferramentas para facilitar a construção e manutenção da aplicação.

- **Banco de Dados:** A API utiliza o **PostgreSQL** como banco de dados para armazenar as informações sobre os materiais, projetos e demais dados relacionados.
