

# 📌 Plano Resumido — Projeto Canivete (Reorientação Técnica)

## 1. Situação Atual

O projeto **Canivete** iniciou como uma aplicação **desktop em JavaFX**, visando centralizar utilidades de trabalho.
Durante o desenvolvimento, surgiram desafios estruturais típicos de aplicações desktop:

* Distribuição e atualização entre múltiplas máquinas
* Manutenção de versões
* Modularidade dinâmica (adição/remoção de funcionalidades)
* Escalabilidade e manutenção a médio/longo prazo

Esses fatores aumentaram significativamente a complexidade do projeto.

---

## 2. Decisão Técnica

Optou-se por **migrar o core do projeto para uma aplicação Web**, mantendo o **Java como linguagem principal no backend**.

A mudança visa reduzir complexidade operacional e alinhar o projeto às práticas atuais do mercado.

---

## 3. Arquitetura Definida

### Backend

* **Java + Spring Boot**
* Responsável por:

    * Regras de negócio
    * Modularização
    * Persistência de dados
    * Autenticação e controle de acesso
    * API REST

### Frontend

* **Aplicação Web**
* Interface acessada via navegador (HTTP)
* Responsável apenas pela experiência do usuário (UI)

### Banco de Dados

* Banco relacional (ex: MySQL ou PostgreSQL)
* Centralização dos dados e configurações

---

## 4. Benefícios da Abordagem Web

* Atualizações centralizadas e instantâneas
* Modularidade simplificada
* Acesso multiplataforma
* Redução de problemas de distribuição
* Maior aderência ao mercado profissional
* Projeto mais escalável e sustentável

---

## 5. Evolução Futura (Opcional)

* Empacotamento da aplicação web como **desktop** usando Electron ou Tauri
* Manutenção de uma versão JavaFX apenas para casos offline ou estudos específicos

---

## 6. Objetivo Final

Construir um **sistema modular, centralizado e escalável**, que funcione como um “canivete suíço” de utilidades, servindo tanto como **ferramenta prática de trabalho** quanto como **projeto de portfólio alinhado ao mercado**.

---