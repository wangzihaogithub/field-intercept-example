#### 介绍
如果你是dubbo微服务项目

#### 使用步骤

1. dubbo-provider端


```yaml

   spring:
      fieldintercept:
         bean-base-packages: 'com.xxx'
         cluster:
            enabled: true
            rpc: dubbo
            role: provider
            dubbo:
               registry: 'myRegistryConfig' # 非必填，参考dubbo注册中心配置
          
```

2. dubbo-consumer端


```yaml


   spring:
      fieldintercept:
         bean-base-packages: 'com.xxx'
         cluster:
            enabled: true
            rpc: dubbo
            role: consumer
            dubbo:
               registry: 'myRegistryConfig' # 非必填，参考dubbo注册中心配置

```

3. 好了，启动项目正常使用即可。
