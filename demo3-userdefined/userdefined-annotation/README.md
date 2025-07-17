#### 介绍
如果你想将常用的查询独立一个注解区分出来

#### 使用步骤

1. 继承原生的注解，定义新的注解

```java

      @Retention(RetentionPolicy.RUNTIME)
      @Target({ElementType.FIELD})
      @com.github.fieldintercept.annotation.FieldConsumer.Extends
      public @interface CnwyCorpSetter {
      
          /**
           * 类型 [SYS_USER,CORP]
           */
          String value() default "corpServiceImpl";
      
          /**
           * 通常用于告知aop. id字段,或者key字段
           *
           * @return 字段名称
           */
          String[] keyField() default {"corpId"};
      
          /**
           * 通常用于告知aop. id字段,或者key字段
           * 支持占位符 （与spring的yaml相同， 支持spring的所有占位符表达式）， 比如 ‘${talentId} ${talentName} ${ig.env} ${random.int[25000,65000]}’
           *
           * @return 字段名称
           */
          String[] valueField() default {};
      
          /**
           * 多个拼接间隔符
           *
           * @return
           */
          String joinDelimiter() default ",";
      
          /**
           * 分类, 用于字段的路由
           *
           * @return
           */
          String type() default ",";
      
      } 

```

2. 定义DTO


```java

      @Data
      public class JobDTO {
          private String corpId;
          @CnwyCorpSetter
          private String corpName;
      }

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

4. 触发查询

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