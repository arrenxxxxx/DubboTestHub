# DubboTestHub

基于Spring Boot和Apache Dubbo的微服务测试工程

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![English](https://img.shields.io/badge/Language-English-blue)](README.md)
[![中文简体](https://img.shields.io/badge/Language-简体中文-red)](README_zh.md)

🚀 DubboTestHub — 让Apache Dubbo微服务测试变得简单高效！

## 🏗️ 项目结构

- `dubbotesthub-api`: 包含Dubbo服务接口和相关模型类
- `dubbotesthub-provider`: Dubbo服务提供者实现
- `dubbotesthub-consumer`: Dubbo服务消费者和HTTP接口
- `dubbotesthub-starter`: 
  - `dubbotesthub-provider-starter`: 服务提供者starter，依赖provider模块并提供自动配置
  - `dubbotesthub-consumer-starter`: 服务消费者starter，依赖consumer模块并提供自动配置
- `dubbotesthub-server`: 整合服务提供者和消费者的服务器，引用两个starter模块

## 🛠️ 技术栈

- JDK 17
- Spring Boot 3.2.0
- Apache Dubbo 3.2.10
- Gradle

## 🔄 注册中心

本项目支持同时使用Zookeeper或Nacos作为注册中心，通过修改配置文件中的`dubbo.registry.address`即可切换：

```yaml
dubbo:
  registry:
    # Zookeeper配置
    # address: zookeeper://127.0.0.1:2181
    
    # Nacos配置
    address: nacos://127.0.0.1:8848
```

## 🌐 服务接口

`HelloFacade`接口提供了多种参数类型的服务调用示例：

- 无参数调用
- 字符串参数调用
- 对象参数调用
- List参数调用
- Map参数调用

## 📦 模块依赖

项目采用了starter模式进行设计：
- provider和consumer模块包含实际的业务逻辑实现
- provider-starter和consumer-starter模块依赖对应的实现模块，提供自动配置和依赖管理
- server模块通过引用两个starter模块，实现一体化启动和部署

## 📂 包结构

项目的包结构统一为`io.arrenxxxxx.dubbotesthub`，各模块使用对应的子包名。

## 🚀 构建与运行

### 构建项目

```bash
gradle clean build
```

### 启动方式

使用Server一体化启动：

```bash
java -jar dubbotesthub-server/build/libs/dubbotesthub-server-0.0.1-SNAPSHOT.jar
```

## 🐳 Docker部署

本项目提供了Docker部署能力，可以快速搭建完整环境：

### 快速开始

```bash
cd docker
docker-compose up -d
```

该命令将启动以下服务：
- Zookeeper作为服务注册中心
- Nacos作为服务发现中心（可选）
- DubboTestHub服务应用

### 访问服务

启动完成后，可以通过`http://localhost:8080`访问服务

查看`docker/README.md`获取更详细的Docker部署信息。

## 🧪 HTTP接口测试

Consumer暴露了RESTful API，可以通过以下端点进行测试：

- GET `/hello`: 无参调用
- GET `/hello/{name}`: 字符串参数调用
- POST `/hello/object`: 对象参数调用
- POST `/hello/list`: List参数调用
- POST `/hello/map`: Map参数调用

## 🤝 贡献

欢迎提交贡献、问题和功能请求！

## 📄 License

MIT 