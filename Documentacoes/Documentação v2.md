**Projeto Canivete - Processo de Desenvolvimento**

Bem-vindo ao Projeto Canivete! Aqui, contarei todo o processo de desenvolvimento, desde a idealização da aplicação até os dias atuais.

*Esta aplicação ainda se encontra em desenvolvimento.*

Vamos lá!

**IDEALIZAÇÃO**

No meu trabalho no setor da Central Técnica (CT) do Sistema Globo de Rádio (Grupo Globo), identifiquei algumas falhas operacionais. Havia muitas informações sensíveis espalhadas em pastas e arquivos locais nos computadores da CT: senhas, manuais, contatos, ramais, rotinas, calendários e alarmes, todos em sistemas diferentes e dispersos.

Isso causava uma enorme falha operacional, pois a CT é responsável por manter o pleno funcionamento do Sistema Globo de Rádio. Portanto, o acesso rápido e eficiente à informação é crucial para atenuar falhas e possíveis erros. No entanto, um sistema com funções dispersas dificulta essa agilidade.

Eu idealizei esse projeto logo no início da minha faculdade, mas já sentia esses problemas antes mesmo de entrar no mundo da programação. Quando comecei o curso, tive matérias excelentes que me ajudaram no processo de idealização, como Levantamento de Requisitos e Prototipação.

Assim, após compreender o que o app precisava fazer, quais problemas resolveria e qual seria sua essência, iniciei uma prototipação de baixo nível no papel para organizar as ideias. Depois, transferi esse protótipo para o Figma, para ter uma visão mais clara da aplicação.

**PROTOTIPAÇÃO FIGMA:** [https://www.figma.com/board/5xvkGaAKX3YyR5xrYYP1T8/Projeto-Utility-Tools?node-id=1-865&t=xc6VUbz5JNbB8jg7-1](https://www.figma.com/board/5xvkGaAKX3YyR5xrYYP1T8/Projeto-Utility-Tools?node-id=1-865&t=xc6VUbz5JNbB8jg7-1)

A aplicação foi pensada da seguinte forma: uma interface principal estática controlaria as funcionalidades, listadas em uma barra lateral esquerda, por onde eu poderia navegar. As funcionalidades planejadas inicialmente seriam:

*   **Dashboard:** com atalhos rápidos.
*   **Bloco de Notas Interno:** semelhante a quadros Kanban, para tarefas e rotinas.
*   **Cofre de Senhas:** para armazenar senhas de forma criptografada, segura e centralizada.
*   **Documentos:** para armazenar arquivos, manuais e outros documentos importantes da CT, com um sistema de "pré-visualização" (um card com descrição e conteúdo).
*   **Ramais e Contatos:** para armazenar contatos importantes, com ferramenta de busca para agilizar o acionamento de setores específicos (como os transmissores).
*   **Relógio:** uma aba com funções de timer, cronômetro (stopwatch) e alarme, para tarefas com prazos específicos.
*   **Agenda:** para agendamento de tarefas e um calendário para eventos específicos.

Além de outras funcionalidades para agilizar processos, como uma aba com um link direto para a folha de ponto.

**DESENVOLVIMENTO - A Primeira Iteração (JavaFX)**

Com a prototipação pronta e a maioria das funcionalidades definidas, chegou a hora do desenvolvimento. Como iniciei esse projeto no começo da faculdade, eu ainda não tinha ideia de qual linguagem, framework ou banco de dados utilizar, nem se precisaria de um banco. O projeto, então, migrou da idealização para a parte técnica.

Meu primeiro objetivo foi entender as principais falhas e pensar em uma solução viável. Após reunir todas as informações, enfrentei um grande desafio: eu queria um aplicativo **modular, atualizável e acessível de qualquer lugar**. Se eu adicionasse um documento ou uma rotina na agenda, essa alteração deveria ser refletida em todos os computadores com a aplicação instalada.

Paralelamente à faculdade, após consolidar a base em Lógica de Programação com C, parti para estudar uma linguagem para o projeto. Sempre achei Java interessante, então decidi iniciar meus estudos nela e em suas interfaces. Escolhi o MySQL como banco de dados e planejei construir uma aplicação desktop usando Java e Swing para a interface. No entanto, ao perceber que o Swing era uma tecnologia legada, decidi migrar para o **JavaFX**.

Para prosseguir, montei um *roadmap* simples de estudos: sintaxe Java, POO, JavaFX, Collections, tratamento de exceções e banco de dados.

E como nem tudo são flores... Percebi diversas dificuldades no projeto: arquivos bagunçados, funcionalidades misturadas e *controllers* fazendo de tudo (desde a lógica até a troca de telas). Logo no início, precisei fazer uma pausa para estudar sobre a gestão de projetos maiores. Foi assim que conheci a **Arquitetura de Software**.

Primeiro, arquitetei meu projeto em **Camadas** para organizar as funções, deixar o app modular e melhorar a manutenibilidade. Antes, para mexer em um simples botão de uma aba específica, eu precisava alterar todo o sistema.

Depois, adotei o padrão **MVC**, que se encaixou como uma luva para esse projeto. A estrutura ficou assim:

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
    │       │   │
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

Resumidamente, essa foi a estrutura do projeto.

**A VIAGEM DE PIVOT: DE DESKTOP PARA WEB**

E assim seguiria esse grande projeto, se a palavra "grande" não estivesse sendo empregada corretamente. Meus objetivos e desafios originais (sincronização, atualização fácil) ainda estavam presentes. O JavaFX foi ficando cada vez mais complexo para atender a essas necessidades, e, durante o desenvolvimento, eu sentia que o processo poderia ser mais "simples" e "direto".

Foi então, após muitos estudos, que tomei uma decisão estratégica: **transformar essa aplicação .exe em uma aplicação web empacotada como desktop** (usando soluções como Electron ou similar). Isso resolveria **TODOS** os meus problemas de sincronização, atualização, manutenibilidade e extensibilidade, além de estar perfeitamente alinhado com as demandas do mercado atual.

Esse é o próximo passo!

Não deixarei o projeto anterior com JavaFX totalmente de lado. Ele será extremamente útil como base lógica e de aprendizado para a nova versão.

**O PRÓXIMO CAPÍTULO: ARQUITETURA FULL STACK**

Agora, planejarei meus estudos para a nova arquitetura:

*   **Backend:** Java (Spring Boot)
*   **Frontend:** HTML + CSS + JS (ou um *framework* como React/Vue)
*   **Banco de Dados:** MySQL

Dessa forma, elevarei meu nível como desenvolvedor, não apenas no *back-end*, mas também no *front-end*, me tornando um profissional **Full Stack**.

Hoje, **07/02/2026**, registro aqui o próximo passo da minha aplicação. Agora é iniciar os estudos a fundo e desenvolver, de fato, essa grande aplicação que está crescendo junto comigo como profissional.

---