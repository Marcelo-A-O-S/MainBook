# MainBook

Projeto desenvolvido para avaliação da disciplina de desenvolvimento de sistemas do senai.

# Como executar
Faça download do arquivo do repositorio do git indo em Code> "Download ZIP"> E extraia o arquivo.

Na ide do eclipse siga os seguintes passos:
Vá para "File" (Arquivo) > "Open Projects from File System..." (Abrir Projetos do Sistema de Arquivos).
Navegue até o diretório do projeto e selecione-o.
Clique em "Finish" (Concluir).
Siga os passos de configuração de banco de dados para que as configurações posssam ser refletidas no seu banco de dados local.
Clique com o botão direito em cima do projeto.
Escolha "Run As" (Executar Como) > "Run on Server".

# Configurar banco de dados
No arquivo application.properties, configure o host do seu banco de dados local, adicionando o código abaixo e substitua {Port} pela porta correta do seu banco de dados do mysql 
```bash
spring.datasource.url = jdbc:mysql://localhost:{Port}/Sa4?createDatabaseIfNotExists=true
```
Adicione o username e password do seu banco de dados local:
```bash
spring.datasource.username= 
spring.datasource.password=
```
