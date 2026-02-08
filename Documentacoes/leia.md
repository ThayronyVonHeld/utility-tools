Projeto Canivete - Processo de Desenvolvimento 

Bem vindo ao projeto canivete, aqui contarei todo o processo de desenvolvimento, desde a idealizaação da aplicação aos dias atuais, 

*Esta aplicação ainda se encontra em desenvolvimento

Vamos lá, IDEALIZAÇÃO 

- Em meu trabalho no setor da Central Técnica no Sistema globo de Rádio, do grupo globo. Encontrei algumas falhas operacionais, haviam muitas informações 
sensiveis espalhadas dentro de pastas e arquivos, local em computadores da CT(Central Técnica), eram senhas, manuais, contatos, ramais, rotinas, calendario, alarmes.
todos em sistemas diferentes e dispersos. Isso causava uma enorme falha operacional pois a CT é responsavel por manter o pleno funcionamento do Sistema Globo de Rádio.
então o acesso a informação, a ação de forma rapida e eficiente é crucial para atenuar as falhas e possiveis erros. Mas com um sistema com funções dispersas dificulta 

Esse projeto idealizei logo no começo da minha faculdade, porém esses erros foram sentidos por mim, antes mesmo de iniciar o no mundo da programação. 
Quando iniciei minha faculdade, tive materias excelentes para me ajudar nesse processos de idealização, como levantamento de requisitos e prototipação,

então após compreender, o que o app precisa, o que ele resolverá, e o que ele será, inicei uma prototipação de baixo nivel, em um papel para colocar as ideas e interesses
após passei esse prototipo para o figma, para ter uma idea melhor sobre a aplicação.

PROTOTIPAÇÃO FIGMA: https://www.figma.com/board/5xvkGaAKX3YyR5xrYYP1T8/Projeto-Utility-Tools?node-id=1-865&t=xc6VUbz5JNbB8jg7-1

Então o aplicativo ficou pensado da seguinte forma: Uma interface principal e estática que controlaria as funcionalidades que estariam na esquerda da interface onde eu poderia
navegar por essas funcionalidades. Que a principio seria: uma dashborad com atalhos rapidos, um bloco de notas internos semelhantes a quadros kanban, para tarefas e rotinas
um cofre de senhas criptografados para armazenas senhas de forma segura e centralizada, uma aba de documentos, para armazenar arquivos, manuais e outros documentos importantes 
da CT, e o interessante é ter uma "Pré-vizualização", um card com descrição do documento e seu conteudo. Uma outra aba ramais e contatos, para armazenar contatos importantes 
para aumentar a produtividade com uma ferramenta de pesquisa, para caso precise acionar algum setor especifico com agilidade, como os transmissores. Relogio, uma aba com funcões 
de Timer, stopwatch e alarm, para realização de tarefas que necessitem de um prazo em especifco. Agenda, uma aba para realizar agendamento de tarefas, e um calendario para
tarefas especificas, entre outras funcionalidades para agilizar como um aba com um link direto para folha de ponto.

Agora com a protipação pronta, e com a maioria das funcionalidades já pensadas chegou a hora do desenvolvimento. Como iniciei esse projeto antes de iniciar a faculdade e 
logo no inicio dela. Eu ainda não fazia ideia, de qual linguagem utilizar, qual framework, banco de dados, se precisaria de banco ou não. Então agora o projeto passou da
parte da idealização para a parte técnica.
Dito isso meu objetivo primeiro foi entender as principais falhas e pensar em uma possivel solução, após reunir todas as informações necessarias e os erros. Enfrentei 
desafios, eu gostaria de aplicativo modular, atualizavel, acessivel de qualquer lugar, que eu pudesse adicionar um documento, e ele seria visivel em todos os computadores que tiverem 
a aplicação, que eu adicionasse uma rotina na agenda e fosse atualizado em cada um dos computadores que estivesse a aplicação e etc...

Comitantemente a faculdade e após meus estudos em logica de programação em C onde consolidei toda a base necessaria para um desenvolvedor partir para aprender uma linguagem que fosse a que eu iria utilizar nesse projeto
Como eu sempre achei muito interessante a linguagem JAVA, decidir iniciar meus estudos nessa linguagem  e iniciar os estudos nas interfaces dessa linguagem. E já tinha decido em utilizar o banco de dados 
mysql para essa aplicação e de inicio era construir uma aplicação desktop utilizando Java, e Swing para interface. Porém ao notar que Swing já não fazia sentido por ser algo legado, decidir mudar para JAVAFX
 
E assim para prosseguir meus estudos para construir esse app montei um roadmap simples
como sintaxe java, poo, javaFX, Colletions frameworks, tratamento de excessões e banco de dados.

E como nem tudo são flores. Percebi as diversas dificuldades diante desse projeto, arquivos bagunçados, funcionalidades misturadas, controllers fazendo de tudo, controlando a logica, a troca de tela.
e logo no inicio da aplicação precisei fazer uma pausa para estudar mais sobre esses grandes projetos. E assim conheci a arquitetura de software.

primeiro arquitetei meu projeto em Camadas, para entender onde estão as funcões, deixar o app modular e melhorando a manutenibilidade. Pois, antes eu precisava mexer em um simples botão de uma 
aba especifica acaba precisando mexer em todo o sistema

E logo passei a utilizar o MVC pois para esse projeto, encaixou como uma luval. e assim ficou a estrutura do projeto 

```
src
└── main
├── java
│   └── com.sgr.utilitytools_v1
│       ├── app
│       │   ├── MainApp.java
│       │   └── MainController.java
│       │
│       ├── clock
│       │   ├── ClockController.java
│       │   ├── ClockNavigator.java
│       │
│       │   ├── alarm
│       │   │   ├── Alarm.java
│       │   │   ├── AlarmController.java
│       │   │   └── AlarmService.java
│       │   │
│       │   ├── stopwatch
│       │   │   └── (classes futuras)
│       │   │
│       │   └── timer
│       │       └── (classes futuras)
│       │
│       ├── dashboard
│       │   ├── DashboardController.java
│       │   └── DashboardService.java
│       │
│       ├── navigation
│       │   └── (navegação global)
│       │
│       └── module-info.java
│
└── resources
└── com.sgr.utilitytools_v1
├── calendar
│   ├── calendar.fxml
│   └── calendar.css
│
├── clock
│   ├── Clock.fxml
│   │
│   ├── alarm
│   │   ├── alarm.fxml
│   │   └── alarm.css
│   │
│   ├── stopwatch
│   │   └── (FXML/CSS futuros)
│   │
│   └── timer
│       └── (FXML/CSS futuros)
│
├── dashboard
│   ├── dashboard.fxml
│   └── dashboard.css
│
├── documents
│
├── main
│
└── passwordsafe
```

Resumidamente, assim ficou meu projeto. 

E assim seguiria esse grande projeto se a palavra "Grande", não fosse empregada corretamente, meus objetivos e desafios ainda estavam presentes. O javaFX foi ficando cada vez mais complexo
E enquanto estava fazendo a aplicação eu sentia que poderia ser "melhor", que eu poderia tornar aquele processo mais "simples", "direto". E foi quando, após muitos estudos
Decidir tornar essa aplicação .exe em uma aplicação .index. Em uma aplicação WEB empacotado como desktop.

Isso resolveria TODOS meus problemas de sincronização, atualização, manuntabilidade, extensividade. E estaria alinhado com o mercado atual.  

E esse é o proximo passo. 

Não deixarei o projeto anterior com JavaFX totalmente de Lado, ele será extremamente util para o proximo passo.

E bem, agora planejarei meus estudos, pensei como seria:

Arquitetura

Backend: Java (Spring Boot)

Frontend: HTML + CSS + JS (ou framework)

Banco: MySQL


Assim irei elevar meu nivel como desenvolvedor, não apenas no back end, como no front end, agora como FULL STACK. Hoje 07/02/2026, foi meu registro do proximo passo da minha aplicação
Agora é iniciar meus estudos a fundo e enfim desenvolver essa grande aplicação que está crescendo junto comigo como profissional.