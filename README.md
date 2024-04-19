<a name="readme-top"></a>

<br />
<h1 align="center">
Spring Techtest
</h1>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]

## Overview

Spring project that deploys a REST service that is structured according to the principles of a hexagonal architecture and uses OpenAPI for service declaration.

## Getting Started
### Architecture

This project has been developed applying **_Hexagonal Architecture_**. This is based on separating the elements that make it up according to their function, which makes it possible to have a business logic decoupled from the other elements, facilitating the evolution and reuse of the various components of the same in an isolated and secure way.

The project is separated into layers, which refer to a different level of components:

- *Domain*: This layer contains the models and interfaces that define the business logic.
- *Application*: The implementation of the business logic use cases and the declaration of 
the services called in them make up this layer.
- *Infrastructure*: External components and the service implementations through which they connect populate this layer.

This architecture is based on the **_Adapters_** structural design pattern, which main goal is to allows the collaboration between objects with incompatible interfaces, through the implementation of intermediate elements that act as adapters.   

### Prerequisites

- [Git](https://git-scm.com/downloads)
- [JDK 17](https://jdk.java.net/21/)
- [Maven](https://maven.apache.org/download.cgi)
  
### Installing
#### Build

To carry out the execution of the project locally, it is first necessary to compile the project in Maven with the following command:

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


## Running the tests
### Unit tests

The unitary tests will be run automatically during the artifact compilation process. 

### Integration tests

The integration tests can be executed using Maven:

```shell
mvn verify
```


### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Spring](https://spring.io/guides) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [OpenAPI](https://spec.openapis.org/oas/v3.0.0) - API specification 

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Alejandro Muñoz Del Álamo**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments


