<div align="center">

![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange)
</div>

<div align="center">

# POC - CRUD KTOR EXPOSED - KOTLIN
O projeto tem como objetivo demonstrar a ultilização do Kotlin com Ktor e Exposed

![](https://img.shields.io/badge/Autor-Wesley%20Oliveira%20Santos-brightgreen)
![](https://img.shields.io/badge/Language-Kotlin-brightgreen)
![](https://img.shields.io/badge/Framework-Ktor-brightgreen)
![](https://img.shields.io/badge/ORM-Exposed-brightgreen)

</div> 

## Fundamentos teóricos

<<<<<<< HEAD
> Ktor: Ktor é uma estrutura assíncrona para a criação de microsserviços, aplicativos da web e muito mais. É divertido, gratuito e de código aberto.

> Exposed: Exposed é uma biblioteca de código aberto (licença Apache) desenvolvida pela JetBrains, que fornece uma API Kotlin idiomática para algumas implementações de banco de dados relacional enquanto elimina as diferenças entre os fornecedores de banco de dados.

=======
> Springboot: O Spring Boot é um projeto da Spring que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação.

>>>>>>> e85662bb3b0ea8350e5665797f0b085b508a9365
> Kotlin: Kotlin: Kotlin é uma Linguagem de programação multiplataforma, orientada a objetos e funcional, concisa e estaticamente tipada, desenvolvida pela JetBrains em 2011, que compila para a Máquina virtual Java e que também pode ser traduzida para a linguagem JavaScript e compilada para código nativo.

## Tecnologias
- Kotlin 1.3.70
- Ktor 1.3.2
   - ktor-server-netty
   - ktor-server-core
   - ktor-gson
- Logback 1.2.1
   - kotlin-logging (microutils) 1.6.25
- Exposed 0.17.7
- HikariCP 3.4.5
- Flywaydb 6.4.1
- H2
- Netty (Embedded no Ktor)
- Git

## Execução

A execução das aplicações são feitas através do de um comando Gradle que envoca a inicialização do Ktor.

- Scripts
  ### Executar a aplicação
   - 1° comando: ``` ./gradlew build```
   - 2° comando: ```./gradlew run```

## Utilização
- Cliente http nativo Intellij IDEIA Ultimate
  ``` /client/client.http```
    
