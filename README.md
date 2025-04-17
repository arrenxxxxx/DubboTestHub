# DubboTestHub | Dubbo Testing Hub

A simple Dubbo demonstration project specifically designed for testing and debugging various Dubbo-related features. Built with Spring Cloud and Dubbo framework, using Zookeeper as the registry center, with various types of service interfaces and parameter passing examples already added.

[English](#project-purpose) | [中文](./README_zh.md)

## Project Purpose

This project can be used to debug the following Dubbo-related features:
- Connection and service discovery with different registry centers (such as Zookeeper, Nacos, Eureka, etc.)
- Behavior and performance testing of MCP Dubbo plugins
- Integration testing of Dify plugins
- Monitoring and governance of Dubbo services
- Tracing and analysis of service calls
- Serialization and transmission of various parameter types
- Validation of load balancing strategies
- Service degradation and circuit breaking testing

## Project Structure

- `dubbo-api`: Contains service interface definitions and data model classes
- `dubbo-provider`: Service provider, implementing various types of service methods
- `dubbo-consumer`: Service consumer, exposing service calls through REST API

## Docker Environment

The project includes a complete Docker Compose configuration that can start the following services:
- Zookeeper: Dubbo service registration and discovery
- MySQL: Data storage (expandable use)
- Redis: Cache service (expandable use)
- MinIO: Object storage service (expandable use)
- Eureka: Service registry center (can be used as an alternative registry center)

## How to Run

### 1. Start Required Services

Start Zookeeper only:
```bash
docker-compose up -d zookeeper
```

Or start all services:
```bash
docker-compose up -d
```

### 2. Compile the Project

```bash
mvn clean package
```

### 3. Start the Service Provider

```bash
java -jar dubbo-provider/target/dubbo-provider-1.0-SNAPSHOT.jar
```

### 4. Start the Service Consumer

```bash
java -jar dubbo-consumer/target/dubbo-consumer-1.0-SNAPSHOT.jar
```

### 5. Test the Service

The service consumer provides API interfaces with various parameter types for testing different parameter scenarios in Dubbo:

#### String Parameter
- Access: http://localhost:8082/api/hello/world

#### No-parameter Method
- Access: http://localhost:8082/api/hello

#### Object Parameter
- Use POST request: http://localhost:8082/api/user
- Request body example:
```json
{
  "id": 1,
  "name": "John",
  "age": 25
}
```

#### Array Parameter
- Access: http://localhost:8082/api/users?names=John,Mike,Sarah

#### Map Parameter
- Access: http://localhost:8082/api/user/map?id=1&name=John

#### Combination Parameters
- Access: http://localhost:8082/api/users/search?keyword=employee&page=1&size=5

#### List<User> Object List Parameter
- Use POST request: http://localhost:8082/api/users/batch
- Request body example:
```json
[
  {"id": 1, "name": "John", "age": 25},
  {"id": 2, "name": "Mike", "age": 30},
  {"id": 3, "name": "Sarah", "age": 35}
]
```

## Extended Testing

### Switching Registry Centers
You can switch different registry centers by modifying the `application.yml` configuration file:

```yaml
dubbo:
  registry:
    address: zookeeper://localhost:2181
    # Or other registry centers
    # address: nacos://localhost:8848
    # address: eureka://localhost:8761
```

### Testing MCP Dubbo Plugin
You can integrate the MCP Dubbo plugin to test its functionality and performance:

1. Add MCP Dubbo dependency
2. Configure MCP connection parameters
3. Verify MCP functionality through API interfaces

### Testing Dify Plugin
You can test the API call process by integrating the Dify plugin:

1. Add Dify plugin dependency
2. Add Dify related configuration in the service
3. Verify the integration effect of the Dify plugin

## Technology Stack

- Spring Boot 2.6.11
- Spring Cloud 2021.0.4
- Apache Dubbo 3.1.6
- Zookeeper 3.7
- Other optional components: MySQL 8.0, Redis, MinIO 