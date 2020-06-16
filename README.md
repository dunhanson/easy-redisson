# Easy Redis

简化redis操作

## 简单开始

```java
public class RedissonTest {
    @Test
    public void redisson() {
        RedissonClient client = RedissonUtils.getRedisClient();
        RLock lock = client.getLock("test");
        lock.lock(1, TimeUnit.SECONDS);
        //do something
        lock.unlock();
    }
}
```

## 配置文件

redisson.yaml

单节点配置

```yaml
singleServerConfig:
  idleConnectionTimeout: 10000
  connectTimeout: 10000
  timeout: 3000
  retryAttempts: 3
  retryInterval: 1500
  password: null
  subscriptionsPerConnection: 5
  clientName: null
  address: "redis://127.0.0.1:6379"
  subscriptionConnectionMinimumIdleSize: 1
  subscriptionConnectionPoolSize: 50
  connectionMinimumIdleSize: 24
  connectionPoolSize: 64
  database: 0
  dnsMonitoringInterval: 5000
threads: 16
nettyThreads: 32
codec: !<org.redisson.codec.FstCodec> {}
transportMode: "NIO"
```

集群配置（哨兵集群配置，其它详见redisson github wiki）

```yaml
sentinelServersConfig:
  idleConnectionTimeout: 10000
  connectTimeout: 10000
  timeout: 3000
  retryAttempts: 3
  retryInterval: 1500
  failedSlaveReconnectionInterval: 3000
  failedSlaveCheckInterval: 60000
  password: bxkc2016
  subscriptionsPerConnection: 5
  clientName: null
  loadBalancer: !<org.redisson.connection.balancer.RoundRobinLoadBalancer> {}
  subscriptionConnectionMinimumIdleSize: 1
  subscriptionConnectionPoolSize: 50
  slaveConnectionMinimumIdleSize: 24
  slaveConnectionPoolSize: 64
  masterConnectionMinimumIdleSize: 24
  masterConnectionPoolSize: 64
  readMode: "SLAVE"
  subscriptionMode: "SLAVE"
  sentinelAddresses:
    - "redis://192.168.2.170:26377"
    - "redis://192.168.2.170:26378"
    - "redis://192.168.2.170:26379"
  masterName: "mymaster"
  database: 0
threads: 16
nettyThreads: 32
codec: !<org.redisson.codec.FstCodec> {}
transportMode: "NIO"
```



## Maven

依赖配置

``仅限公司内部项目配置生效``

```xml
<dependency>
    <groupId>site.dunhanson.redisson</groupId>
    <artifactId>easy-redisson</artifactId>
    <version>2020.0616.2204</version>
</dependency>
```

依赖关联

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.30</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.30</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>1.7.30</version>
    <scope>compile</scope>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.12</version>
    <scope>provided</scope>
</dependency>
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.9</version>
</dependency>
<dependency>
    <groupId>org.yaml</groupId>
    <artifactId>snakeyaml</artifactId>
    <version>1.26</version>
</dependency>
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>
<dependency>
    <groupId>org.redisson</groupId>
    <artifactId>redisson</artifactId>
    <version>3.12.5</version>
</dependency>
```

## 参考资料

https://github.com/redisson/redisson

https://github.com/redisson/redisson/wiki