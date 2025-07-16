#### 介绍
如果你需要做查询编排优化, 或更多自定义配置


application.yaml里

```yaml

    spring:
      fieldintercept:
        beanBasePackages: 'com.github'
        batch-aggregation:
          enabled: auto
          poll-min-size: 5
          poll-milliseconds: 100
          

```


application.yaml里可选参数， IntelliJ IDEA里有提示。

```json 

        
        [
            {
            "name": "spring.fieldintercept.aop-class",
            "type": "java.lang.Class<? extends com.github.fieldintercept.ReturnFieldDispatchAop>",
            "description": "切面对象",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties"
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.chain-call-use-aggregation",
            "type": "java.lang.Boolean",
            "description": "FieldCompletableFuture的链式调用是否默认也用聚合",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation",
            "defaultValue": false
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.enabled",
            "type": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregationEnum",
            "description": "聚合策略 开启将N毫秒内的多个并发请求攒到一起处理",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation"
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.max-signal-concurrent-count",
            "type": "java.lang.Integer",
            "description": "控制批量聚合信号（发车）最大并发量，如果超过这个并发量，并且超过了队列长度(pendingQueueCapacity)，则会阻塞调用方(业务代码)继续生产自动注入任务。 {pollMilliseconds}毫秒内，有{pollMinSize}个就发车，一趟车最多{pollMaxSize}人，最多同时发{maxSignalConcurrentCount}辆车，等下次发车的排队人数为{pendingQueueCapacity}",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation",
            "defaultValue": 200
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.pending-non-block",
            "type": "java.lang.Boolean",
            "description": "打上ReturnFieldAop注解的方法，是否使用非阻塞返回（dubbo-server接口转异步，spring-web-server接口转异步）",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation",
            "defaultValue": true
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.pending-queue-capacity",
            "type": "java.lang.Integer",
            "description": "聚合阻塞队列容量 {pollMilliseconds}毫秒内，有{pollMinSize}个就发车，一趟车最多{pollMaxSize}人，最多同时发{maxSignalConcurrentCount}辆车，等下次发车的排队人数为{pendingQueueCapacity}",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation",
            "defaultValue": 200
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.poll-max-size",
            "type": "java.lang.Integer",
            "description": "最大聚合个数 {pollMilliseconds}毫秒内，有{pollMinSize}个就发车，一趟车最多{pollMaxSize}人，最多同时发{maxSignalConcurrentCount}辆车，等下次发车的排队人数为{pendingQueueCapacity}",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation",
            "defaultValue": 500
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.poll-milliseconds",
            "type": "java.lang.Long",
            "description": "攒多个并发请求的等待时间（毫秒） 将N毫秒内的所有线程聚合到一起查询 {pollMilliseconds}毫秒内，有{pollMinSize}个就发车，一趟车最多{pollMaxSize}人，最多同时发{maxSignalConcurrentCount}辆车，等下次发车的排队人数为{pendingQueueCapacity}",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation",
            "defaultValue": 50
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.poll-min-size",
            "type": "java.lang.Integer",
            "description": "最少聚合个数 {pollMilliseconds}毫秒内，有{pollMinSize}个就发车，一趟车最多{pollMaxSize}人，最多同时发{maxSignalConcurrentCount}辆车，等下次发车的排队人数为{pendingQueueCapacity}",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation",
            "defaultValue": 1
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.signal-thread-count",
            "type": "java.lang.Integer",
            "description": "几个通知发车的信号线程",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation",
            "defaultValue": 1
            },
            {
            "name": "spring.fieldintercept.batch-aggregation.threshold-min-concurrent-count",
            "type": "java.lang.Integer",
            "description": "并发量小于这个数，直接走同步代码逻辑。 超过这个并发请求的数量后，才开始聚合攒批。 否则立即执行 攒批的并发量最低要求",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$BatchAggregation",
            "defaultValue": 1
            },
            {
            "name": "spring.fieldintercept.bean-base-packages",
            "type": "java.lang.String[]",
            "description": "业务实体类的包路径 用于快速判断是否是业务实体类 ,如果是业务实体类,则会深度遍历访问内部字段 包路径. 例如 {\"com.ig\", \"com.xx\"}",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties",
            "defaultValue": []
            },
            {
            "name": "spring.fieldintercept.block-getter-timeout-milliseconds",
            "type": "java.lang.Integer",
            "description": "自动注入同步调用时的超时时间",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties",
            "defaultValue": 30000
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.argument-fields",
            "type": "java.lang.Boolean",
            "description": "是否将字段穿过去",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo",
            "defaultValue": false
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.async",
            "type": "java.lang.Boolean",
            "description": "Whether to async note that: it is an unreliable asynchronism that ignores return values and does not block threads.",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo",
            "defaultValue": true
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.check",
            "type": "java.lang.Boolean",
            "description": "Check if service provider exists, if not exists, it will be fast fail",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo",
            "defaultValue": false
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.connections",
            "type": "java.lang.Integer",
            "description": "Maximum connections service provider can accept, default value is 0 - connection is shared",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo"
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.filter",
            "type": "java.lang.String[]",
            "description": "dubbo filter",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo"
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.group",
            "type": "java.lang.String",
            "description": "Service group, default value is empty string",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo"
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.parameters",
            "type": "java.util.Map<java.lang.String,java.lang.String>",
            "description": "Customized parameter key-value pair, for example: {key1, value1, key2, value2}",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo"
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.registry",
            "type": "java.lang.String[]",
            "description": "Registry spring bean name",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo"
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.retries",
            "type": "java.lang.Integer",
            "description": "Service invocation retry times (iterget的配置, 关闭重试.默认3次) <p> \/\/     * @see Constants#DEFAULT_RETRIES",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo"
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.timeout",
            "type": "java.lang.Integer",
            "description": "Timeout value for service invocation, default value is 0",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo"
            },
            {
            "name": "spring.fieldintercept.cluster.dubbo.version",
            "type": "java.lang.String",
            "description": "Service version, default value is empty string",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Dubbo"
            },
            {
            "name": "spring.fieldintercept.cluster.enabled",
            "type": "java.lang.Boolean",
            "description": "是否开启集群模式",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Cluster",
            "defaultValue": false
            },
            {
            "name": "spring.fieldintercept.cluster.role",
            "type": "com.github.fieldintercept.springboot.FieldinterceptProperties$ClusterRoleEnum",
            "description": "服务角色 provider=服务端（配置后不会调用远程接口，会提供远程接口） consumer=客户端（配置后不会提供远程服务，会调用远程接口） all=服务端加客户端（会提供远程接口 + 会调用远程接口）",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Cluster"
            },
            {
            "name": "spring.fieldintercept.cluster.rpc",
            "type": "com.github.fieldintercept.springboot.FieldinterceptProperties$ClusterRpcEnum",
            "description": "dubbo=使用dubbo远程注册与调用",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$Cluster"
            },
            {
            "name": "spring.fieldintercept.enabled",
            "type": "java.lang.Boolean",
            "description": "是否开启字段拦截",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties",
            "defaultValue": true
            },
            {
            "name": "spring.fieldintercept.field-completable-before-complete-listeners",
            "type": "java.lang.Class<? extends java.util.function.BiConsumer<java.lang.Object,java.lang.Throwable>>[]",
            "description": "异步完毕监听",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties"
            },
            {
            "name": "spring.fieldintercept.max-runnable-concurrent-count",
            "type": "java.lang.Integer",
            "description": "如果超过这个数量，就会阻塞调用方(业务代码)继续生产自动注入任务。阻塞创建AutowiredRunnable，创建不出来就提交不到线程池里",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties"
            },
            {
            "name": "spring.fieldintercept.my-annotations",
            "type": "java.lang.Class<? extends java.lang.annotation.Annotation>[]",
            "description": "注册自定义注解 1. 自定义注解可以像使用 FieldConsumer注解一样，拦截字段处理逻辑 2. 自定义注解可以覆盖框架注解 前提 1. spring容器里必须有和注解短类名相同的bean。例： com.ig.MyAnnotation的名字是MyAnnotation。 {@link ReturnFieldDispatchAop#getMyAnnotationConsumerName(Class)} 2. bean需要实现接口处理自定义逻辑 {@link ReturnFieldDispatchAop.FieldIntercept}",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties",
            "defaultValue": []
            },
            {
            "name": "spring.fieldintercept.thread-pool.core-pool-size",
            "type": "java.lang.Integer",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$ThreadPool",
            "defaultValue": 0
            },
            {
            "name": "spring.fieldintercept.thread-pool.enabled",
            "type": "java.lang.Boolean",
            "description": "是否并行查询 true=用线程池并行,false=在调用者线程上串行",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$ThreadPool",
            "defaultValue": true
            },
            {
            "name": "spring.fieldintercept.thread-pool.keep-alive-time-seconds",
            "type": "java.lang.Long",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$ThreadPool",
            "defaultValue": 60
            },
            {
            "name": "spring.fieldintercept.thread-pool.max-threads",
            "type": "java.lang.Integer",
            "description": "线程数量 如果并发超过线程数量，超出的部分会在调用者线程上执行",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$ThreadPool",
            "defaultValue": 100
            },
            {
            "name": "spring.fieldintercept.thread-pool.prefix",
            "type": "java.lang.String",
            "description": "线程名称前缀",
            "sourceType": "com.github.fieldintercept.springboot.FieldinterceptProperties$ThreadPool",
            "defaultValue": "FieldIntercept-"
            }
        ]
```
