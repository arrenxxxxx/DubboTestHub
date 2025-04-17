# DubboTestHub | Dubbo测试中心

这是一个简单的Dubbo演示项目，专门用于测试和调试与Dubbo相关的各种功能。项目使用Spring Cloud和Dubbo框架，通过Zookeeper作为注册中心，并已添加多种类型的服务接口和参数传递示例。

## 项目用途

这个项目可以用来调试以下Dubbo相关功能：
- 不同注册中心的连接和服务发现（如Zookeeper、Nacos、Eureka等）
- MCP Dubbo插件的行为和性能测试
- Dify插件的集成测试
- Dubbo服务的监控和治理
- 服务调用的追踪和分析
- 各种类型参数的序列化和传输
- 负载均衡策略的验证
- 服务降级和熔断测试

## 项目结构

- `dubbo-api`: 包含服务接口定义和数据模型类
- `dubbo-provider`: 服务提供者，实现各种类型的服务方法
- `dubbo-consumer`: 服务消费者，通过REST API暴露服务调用

## Docker环境

项目包含完整的Docker Compose配置，可以启动以下服务：
- Zookeeper: Dubbo服务注册与发现
- MySQL: 数据存储（可扩展使用）
- Redis: 缓存服务（可扩展使用）
- MinIO: 对象存储服务（可扩展使用）
- Eureka: 服务注册中心（可作为备选注册中心）

## 如何运行

### 1. 启动所需服务

仅启动Zookeeper：
```bash
docker-compose up -d zookeeper
```

或启动所有服务：
```bash
docker-compose up -d
```

### 2. 编译项目

```bash
mvn clean package
```

### 3. 启动服务提供者

```bash
java -jar dubbo-provider/target/dubbo-provider-1.0-SNAPSHOT.jar
```

### 4. 启动服务消费者

```bash
java -jar dubbo-consumer/target/dubbo-consumer-1.0-SNAPSHOT.jar
```

### 5. 测试服务

服务消费者提供了多种参数类型的API接口，可用于测试Dubbo的各种传参场景：

#### 字符串参数
- 访问: http://localhost:8082/api/hello/world

#### 无参方法
- 访问: http://localhost:8082/api/hello

#### 对象参数
- 使用POST请求: http://localhost:8082/api/user
- 请求体示例:
```json
{
  "id": 1,
  "name": "张三",
  "age": 25
}
```

#### 数组参数
- 访问: http://localhost:8082/api/users?names=张三,李四,王五

#### Map参数
- 访问: http://localhost:8082/api/user/map?id=1&name=张三

#### 组合参数
- 访问: http://localhost:8082/api/users/search?keyword=职员&page=1&size=5

#### List<User>对象列表参数
- 使用POST请求: http://localhost:8082/api/users/batch
- 请求体示例:
```json
[
  {"id": 1, "name": "张三", "age": 25},
  {"id": 2, "name": "李四", "age": 30},
  {"id": 3, "name": "王五", "age": 35}
]
```

## 扩展测试

### 切换注册中心
可以通过修改`application.yml`配置文件来切换不同的注册中心：

```yaml
dubbo:
  registry:
    address: zookeeper://localhost:2181
    # 或其他注册中心
    # address: nacos://localhost:8848
    # address: eureka://localhost:8761
```

### 测试MCP Dubbo插件
可以在项目中集成MCP Dubbo插件来测试其功能和性能：

1. 添加MCP Dubbo依赖
2. 配置MCP连接参数
3. 通过API接口验证MCP功能

### 测试Dify插件
可以通过集成Dify插件来测试API调用流程：

1. 添加Dify插件依赖
2. 在服务中添加Dify相关配置
3. 验证Dify插件的集成效果

## 技术栈

- Spring Boot 2.6.11
- Spring Cloud 2021.0.4
- Apache Dubbo 3.1.6
- Zookeeper 3.7
- 其他可选组件：MySQL 8.0, Redis, MinIO 