<a name="readme-top"></a>

<br />
<h1 style="text-align: center">
Spring Techtest
</h1>

## Table of Contents 

- [Overview](#overview)
- [Getting Started](#getting-started)
  - [Architecture](#architecture)
  - [Prerequisites](#prerequisites)
  - [Installing](#installing)
    - [Build](#build)
    - [Deployment](#deployment)
- [Running the tests](#running-the-tests)
  - [Unit tests](#unit-tests)
  - [Integration tests](#integration-tests)
  - [Test coverage](#test-coverage)
  - [Break down into end to end tests](#break-down-into-end-to-end-tests)
- [Deployment](#deployment-1)
- [Built With](#built-with)
- [Versioning](#versioning)
- [Authors](#authors)
- [License](#license)


## Overview

Spring project that deploys a REST service that is structured according to the principles of a hexagonal architecture 
and uses OpenAPI for service declaration.

## Getting Started
### Architecture

This project has been developed applying **_Hexagonal Architecture_**. This is based on separating the elements that 
make it up according to their function, which makes it possible to have a business logic decoupled from the other 
elements, facilitating the evolution and reuse of the various components of the same in an isolated and secure way.

The project is separated into layers, which refer to a different level of components:

- *Domain*: This layer contains the models and interfaces that define the business logic.
- *Application*: The implementation of the business logic use cases and the declaration of 
the services called in them make up this layer.
- *Infrastructure*: External components and the service implementations through which they connect populate this layer.

This architecture is based on the **_Adapters_** structural design pattern, which main goal is to allows the 
collaboration between objects with incompatible interfaces, through the implementation of intermediate elements 
that act as adapters.   

---

### Prerequisites

- [Git](https://git-scm.com/downloads)
- [JDK 17](https://jdk.java.net/21/)
- [Maven](https://maven.apache.org/download.cgi)
  
### Installing
#### Build

To carry out the execution of the project locally, it is first necessary to compile the project in Maven with 
the following command:

```shell
mvn clean install
```

#### Deployment

After the build has finished successfully, its possible to deploy locally:

<h5>Java command</h5>

```shell
java -jar target/app-0.0.1-SNAPSHOT.jar
```

<h5>Maven</h5>

```shell
mvn spring-boot:run
```

Once the artifact has been deployed, is possible to use 
any endpoint available from the [OpenAPI generated documentation](http://localhost:8080/example/techtest/api/docs)

---

## Running the tests

This project contains tests to find out if the available code causes any errors, 
and makes it possible to locate problems that arise during development.

### Unit tests

Unit tests provide the security of knowing that a small piece of code is working correctly,
so that the execution of each separate element can be assured. These are placed in all layers 
of the service, in order to test as many components as possible.

### Integration tests

Integration testing aims to ensure that the different components developed can be connected to each other in a 
cohesive way, and to ensure the correct interaction between them. These tests are placed in an integration module, 
in order to facilitate the integration of the dependencies of all the modules that make up the project.

This is the command to execute the integration tests:

```shell
mvn verify
```

---

## Utils

### Test coverage

A test coverage reporting service has been implemented using the **JaCoCo** application, 
which is generated within the techtest-report module, in the path _target/site/report_.

### Endpoint collection

The repository contains a file called [_postman_collection_]([postman_collection]) which can be imported into 
Postman to check the endpoints after deploying the service.

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Spring](https://spring.io/guides) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [OpenAPI](https://spec.openapis.org/oas/v3.0.0) - API specification 
* [OpenAPI Spring Generator](https://openapi-generator.tech/docs/generators/spring/) - OpenAPI generator for Spring framework
* [JaCoCo](https://www.eclemma.org/jacoco/) - Code coverage

## Authors

* **Alejandro Muñoz Del Álamo**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details


