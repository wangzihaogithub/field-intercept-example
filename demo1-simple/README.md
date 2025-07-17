#### 介绍
如果你写业务代码时，将列表查询出来后，经常需要用id再查询一遍换数据

#### 使用步骤

1.  添加maven依赖, 在pom.xml中加入 [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.wangzihaogithub/field-intercept/badge.svg)](https://search.maven.org/search?q=g:com.github.wangzihaogithub%20AND%20a:field-intercept)

```xml

            <!-- https://mvnrepository.com/artifact/com.github.wangzihaogithub/field-intercept -->
            <dependency>
                <groupId>com.github.wangzihaogithub</groupId>
                <artifactId>field-intercept</artifactId>
                <version>1.0.18</version>
            </dependency>

```

2. 添加配置，写上业务包名（这是为了减少对象遍历）

        application.yaml里

```yaml

   spring:
      fieldintercept:
         beanBasePackages: 'com.xxx'

```

3. 写一个查询实现

```java

    // 方式1（自定义逻辑的根据id查询）
    @Service("corpServiceImpl")
    public class CorpServiceImpl extends DefaultCompositeFieldIntercept<String, Corp, JoinPoint> {
        public CorpServiceImpl(CorpMapper mapper) {
            super(ids -> {
                        // 名称查询
                        Map<String, String> nameMap = new HashMap<>();
                        List<Corp> list = mapper.selectByIds(ids);
                        for (Corp row : list) {
                            nameMap.put(row.getId(), row.getName());
                        }
                        return nameMap;
                    },
                    ids -> {
                        // 对象查询
                        Map<String, Corp> poMap = new HashMap<>();
                        List<Corp> list = mapper.selectByIds(ids);
                        for (Corp row : list) {
                            poMap.put(row.getId(), row);
                        }
                        return poMap;
                    });
        }
    }
    
```

```java

     // 方式2 （如果你有自己的抽象增删改查服务可以这样做）
     @Service("corpServiceImpl")
     public class CorpServiceImpl extends AbstractCrudService<String, Corp, CorpMapper>{
    
     }

```

4. 定义DTO

```java

        @Data
        public class JobDTO  {
            private String corpId;
            @CnwyFieldConsumer(value = StringConstants.CORP, keyField = "corpId")
            private String corpName;
            @CnwyFieldConsumer(value = StringConstants.CORP, keyField = "corpId")
            private CorpDTO corp;
        }
        
```

5. 触发查询

         触发查询的入口有两种， 任选其一即可：
```java

           // 方式1. 方法上标记 @ReturnFieldAop注解。

            @ReturnFieldAop
            public List<JobDTO> selectByIds(Collection<Integer> ids) {
                return jobMapper.selectListByIdList(ids);
            }
            
```

```java

           // 方式2. 主动触发查询
            @Autowired 
            private ReturnFieldDispatchAop returnFieldDispatchAop;

            public List<JobDTO> selectByIds(Collection<Integer> ids) {
                List<JobDTO> list = jobMapper.selectListByIdList(ids);
                returnFieldDispatchAspect.autowiredFieldValue(list);
                return list;
            }
            
```

6. 好了，看下JobDTO里的数据已经填充进去了