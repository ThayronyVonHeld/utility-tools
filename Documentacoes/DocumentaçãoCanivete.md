# Projeto Canivete — Processo de Desenvolvimento

Bem-vindo ao Projeto Canivete. Aqui contarei todo o processo de desenvolvimento, desde a idealização da aplicação até os dias atuais.

*Esta aplicação ainda se encontra em desenvolvimento.*

Vamos lá.

## IDEALIZAÇÃO

Em meu trabalho no setor da Central Técnica no Sistema Globo de Rádio, do Grupo Globo, encontrei algumas falhas operacionais. Havia muitas informações sensíveis espalhadas em pastas e arquivos locais nos computadores da CT (Central Técnica): senhas, manuais, contatos, ramais, rotinas, calendário e alarmes — todos em sistemas diferentes e dispersos.

Isso causava uma grande falha operacional, pois a CT é responsável por manter o pleno funcionamento do Sistema Globo de Rádio. O acesso à informação e a capacidade de agir de forma rápida e eficiente são cruciais para atenuar falhas e possíveis erros. Porém, um sistema com funções dispersas dificulta esse processo.

Idealizei esse projeto logo no começo da faculdade, mas esses problemas já eram percebidos por mim antes mesmo de entrar no mundo da programação. Quando iniciei o curso, tive matérias excelentes que ajudaram nesse processo de idealização, como levantamento de requisitos e prototipação.

Após compreender o que o aplicativo precisava ser, o que resolveria e quais seriam suas funcionalidades, iniciei uma prototipação de baixo nível em papel, organizando ideias e interesses. Em seguida, passei esse protótipo para o Figma, para ter uma visão mais clara da aplicação.

PROTOTIPAÇÃO FIGMA:
[https://www.figma.com/board/5xvkGaAKX3YyR5xrYYP1T8/Projeto-Utility-Tools?node-id=1-865&t=xc6VUbz5JNbB8jg7-1](https://www.figma.com/board/5xvkGaAKX3YyR5xrYYP1T8/Projeto-Utility-Tools?node-id=1-865&t=xc6VUbz5JNbB8jg7-1)

O aplicativo foi pensado da seguinte forma: uma interface principal e estática controlando as funcionalidades disponíveis na lateral esquerda da interface, permitindo navegação entre elas.

As funcionalidades iniciais seriam:

* Uma dashboard com atalhos rápidos
* Um bloco de notas interno semelhante a quadros Kanban para tarefas e rotinas
* Um cofre de senhas criptografado para armazenamento seguro e centralizado
* Uma aba de documentos para armazenar manuais e arquivos importantes da CT, com pré-visualização em formato de card contendo descrição e conteúdo
* Uma aba de ramais e contatos com ferramenta de pesquisa para agilizar a comunicação com setores específicos
* Uma aba de relógio com Timer, Stopwatch e Alarm
* Uma agenda com calendário para organização de tarefas
* Uma aba com link direto para a folha de ponto

---

## DESENVOLVIMENTO

Com a prototipação pronta e a maioria das funcionalidades definidas, chegou o momento do desenvolvimento. Como iniciei esse projeto antes e logo no começo da faculdade, eu ainda não tinha clareza sobre qual linguagem utilizar, qual framework escolher, se precisaria de banco de dados, entre outras decisões técnicas.

O projeto então passou da fase de idealização para a fase técnica.

Meu primeiro objetivo foi compreender melhor os problemas e pensar em uma solução possível. Após reunir as informações necessárias, enfrentei alguns desafios importantes: eu queria um aplicativo modular, atualizável, acessível de qualquer lugar, onde documentos adicionados fossem visíveis em todos os computadores com a aplicação, e onde tarefas e rotinas fossem sincronizadas automaticamente.

Paralelamente à faculdade, e após consolidar minha base em lógica de programação com a linguagem C, decidi iniciar meus estudos em Java, linguagem pela qual sempre tive interesse. Também defini o MySQL como banco de dados da aplicação.

A ideia inicial era construir uma aplicação desktop em Java utilizando Swing. Porém, ao perceber que Swing já não fazia tanto sentido por ser uma tecnologia mais antiga, decidi migrar para JavaFX.

Para organizar meus estudos, montei um roadmap simples:

* Sintaxe Java
* Programação Orientada a Objetos
* JavaFX
* Collections Framework
* Tratamento de exceções
* Banco de dados

---

## DESAFIOS DE ARQUITETURA

Como nem tudo são flores, percebi rapidamente as dificuldades de um projeto maior: arquivos desorganizados, funcionalidades misturadas e controllers acumulando responsabilidades — controlando lógica, navegação e interface.

Logo no início do desenvolvimento, precisei fazer uma pausa para estudar melhor a construção de projetos maiores. Foi nesse momento que conheci o conceito de arquitetura de software.

Primeiro, reorganizei o projeto em camadas para entender melhor onde cada função deveria ficar, tornando o aplicativo mais modular e melhorando sua manutenibilidade. Antes disso, modificar um simples botão em uma aba específica podia exigir mudanças em várias partes do sistema.

Em seguida, passei a utilizar o padrão MVC, que se encaixou perfeitamente no projeto. A estrutura ficou da seguinte forma:

```
(estrutura mantida exatamente como você escreveu)
```

Resumidamente, assim ficou o projeto.

---

## MUDANÇA DE DIREÇÃO

O projeto continuaria nesse caminho se a palavra “grande” não fosse aplicada corretamente aos desafios envolvidos. O JavaFX começou a se tornar cada vez mais complexo para o objetivo que eu tinha.

Durante o desenvolvimento, comecei a sentir que o processo poderia ser melhor — mais simples e mais direto. Foi então que, após muitos estudos, decidi transformar a aplicação desktop em uma aplicação web empacotada como desktop.

Essa mudança resolveria problemas importantes de sincronização, atualização, manutenibilidade e extensibilidade, além de alinhar o projeto com o mercado atual.

Esse é o próximo passo.

Não deixarei o projeto anterior em JavaFX totalmente de lado — ele será extremamente útil para a próxima etapa.

---

## PRÓXIMA ETAPA

Agora planejarei meus estudos da seguinte forma:

Arquitetura definida como:

Backend: Java (Spring Boot)
Frontend: HTML + CSS + JavaScript (ou framework)
Banco de dados: MySQL

Assim, irei elevar meu nível como desenvolvedor, não apenas no back-end, mas também no front-end, tornando-me um desenvolvedor full stack.

Hoje, 07/02/2026, fica registrado o próximo passo da minha aplicação.
Agora é iniciar os estudos com profundidade e, enfim, desenvolver essa aplicação que cresce junto comigo como profissional.

---
