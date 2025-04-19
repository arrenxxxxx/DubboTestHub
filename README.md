# DubboTestHub

A microservice testing framework based on Spring Boot and Apache Dubbo

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![English](https://img.shields.io/badge/Language-English-blue)](README.md)
[![中文简体](https://img.shields.io/badge/Language-简体中文-red)](README_zh.md)

🚀 DubboTestHub — A powerful testing framework for Apache Dubbo microservices!

## 🏗️ Project Structure

- `dubbotesthub-api`: Contains Dubbo service interfaces and related model classes
- `dubbotesthub-provider`: Dubbo service provider implementation
- `dubbotesthub-consumer`: Dubbo service consumer and HTTP interfaces
- `dubbotesthub-starter`: 
  - `dubbotesthub-provider-starter`: Service provider starter, depends on provider module and provides auto-configuration
  - `dubbotesthub-consumer-starter`: Service consumer starter, depends on consumer module and provides auto-configuration
- `dubbotesthub-server`: Server that integrates service provider and consumer, references both starter modules

## 🛠️ Technology Stack

- JDK 17
- Spring Boot 3.2.0
- Apache Dubbo 3.2.10
- Gradle

## 🔄 Registry Center

This project supports using either Zookeeper or Nacos as registry center, which can be switched by modifying `dubbo.registry.address` in the configuration file:

```yaml
dubbo:
  registry:
    # Zookeeper configuration
    # address: zookeeper://127.0.0.1:2181
    
    # Nacos configuration
    address: nacos://127.0.0.1:8848
```

## 🌐 Service Interfaces

The `HelloFacade` interface provides examples of service calls with various parameter types:

- No parameter call
- String parameter call
- Object parameter call
- List parameter call
- Map parameter call

## 📦 Module Dependencies

The project is designed with a starter pattern:
- provider and consumer modules contain the actual business logic implementation
- provider-starter and consumer-starter modules depend on the corresponding implementation modules, providing auto-configuration and dependency management
- server module realizes integrated startup and deployment by referencing both starter modules

## 📂 Package Structure

The package structure is uniformly `io.arrenxxxxx.dubbotesthub`, with each module using corresponding sub-package names.

## 🚀 Build and Run

### Build Project

```bash
gradle clean build
```

### Start Method

Start with the integrated Server:

```bash
java -jar dubbotesthub-server/build/libs/dubbotesthub-server-0.0.1-SNAPSHOT.jar
```

## 🐳 Docker Deployment

The project provides Docker deployment capability for quick setup:

### Quick Start

```bash
cd docker
docker-compose up -d
```

This command will launch:
- Zookeeper for service registry
- Nacos for service discovery (optional)
- DubboTestHub server application

### Access Service

After startup, you can access the service at `http://localhost:8080`

See `docker/README.md` for more detailed Docker deployment information.

## 🧪 HTTP API Testing

The Consumer exposes RESTful APIs that can be tested through the following endpoints:

- GET `/hello`: No parameter call
- GET `/hello/{name}`: String parameter call
- POST `/hello/object`: Object parameter call
- POST `/hello/list`: List parameter call
- POST `/hello/map`: Map parameter call

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

## 📄 License

MIT 