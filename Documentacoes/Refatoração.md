# Documentação de Refatoração: UtilityTools v1

## 1. Visão Geral
Esta documentação detalha a transição da arquitetura monolítica (baseada em Controllers) da versão `v0` para a arquitetura desacoplada e persistente da versão `v1`. O objetivo principal foi resolver a interrupção de processos (como o Cronômetro) durante a navegação entre telas.

## 2. O Problema da Versão Anterior (v0)
Na implementação original, toda a lógica de contagem de tempo e gerenciamento de estado residia dentro do `StopwatchController`.
* **Acoplamento:** A lógica de negócio estava misturada com a lógica de interface (JavaFX).
* **Perda de Estado:** Devido ao funcionamento do `Navigator`, ao trocar de tela, o JavaFX descarta o Controller antigo. Como o cronômetro (Timeline) estava dentro do Controller, ele era interrompido e zerado ao navegar.



## 3. Nova Arquitetura (v1)

A solução foi dividir a funcionalidade em três camadas distintas, utilizando o padrão **Singleton** para garantir a persistência na memória da JVM, independentemente da interface gráfica.

### A. Camada de Modelo (`Stopwatch.java`)
Contém apenas os dados puros. É uma classe POJO (Plain Old Java Object) que armazena:
* `startTime`: Momento em que o cronômetro iniciou.
* `elapsedTime`: Tempo total decorrido em nanossegundos.
* `running`: Booleano indicando o estado atual.

### B. Camada de Serviço (`StopwatchService.java`)
É o "cérebro" da aplicação. Funciona como um **Singleton**.
* **Independência:** Ouve o `ClockService` (motor global) para atualizar o tempo.
* **Persistência:** Como a instância é única e global, o cronômetro continua calculando o tempo mesmo que o usuário saia da tela de Cronômetro.
* **Formatação:** Responsável por transformar os dados brutos em Strings formatadas para a UI.

### C. Camada de Controle (`StopwatchController.java`)
Atua apenas como um "observador" e mediador.
* **Bindings Reativos:** Em vez de "mandar" a interface atualizar, o Controller vincula os elementos da UI (como a lista de Laps) diretamente às propriedades do Service.
* **Resiliência:** No método `initialize()`, ele checa o estado atual do Service. Se o cronômetro já estiver rodando, a interface se adapta instantaneamente para mostrar o tempo correto e os botões certos.

---

## 4. O Motor Global (`ClockService.java`)
Para evitar que cada funcionalidade (Alarme, Timer, Cronômetro) crie seu próprio loop de repetição, centralizamos o "pulso" do sistema:
* Utiliza um `Timeline` de alta precisão (10ms).
* Dispara um `tickProperty` que qualquer serviço da aplicação pode ouvir.
* **Benefício:** Redução de consumo de CPU e sincronia perfeita entre todas as ferramentas de tempo da aplicação.

## 5. Comparativo Técnico

| Recurso | Implementação v0 | Implementação v1 |
| :--- | :--- | :--- |
| **Local da Lógica** | Controller (FXML) | Service (Singleton) |
| **Troca de Tela** | Reseta tudo | Mantém estado no background |
| **Manutenção** | Complexa (tudo misturado) | Simples (responsabilidades claras) |
| **Motor de Tempo** | Vários Timelines locais | Único motor global (`ClockService`) |

---

## 6. Conclusão
Embora o volume de arquivos e linhas de código tenha aumentado, a **complexidade sistêmica diminuiu**. A aplicação agora é robusta o suficiente para suportar multitarefas, permitindo que o usuário inicie um cronômetro, navegue para a lista de contatos e retorne sem qualquer perda de informação.
