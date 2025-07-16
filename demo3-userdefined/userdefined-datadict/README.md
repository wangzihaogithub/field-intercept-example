#### 介绍
如果你写业务代码时，将列表查询出来后，经常需要用id再查询一遍换数据

#### 使用步骤

1.  添加maven依赖, 在pom.xml中加入 [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.wangzihaogithub/field-intercept/badge.svg)](https://search.maven.org/search?q=g:com.github.wangzihaogithub%20AND%20a:field-intercept)


            <!-- https://mvnrepository.com/artifact/com.github.wangzihaogithub/field-intercept -->
            <dependency>
                <groupId>com.github.wangzihaogithub</groupId>
                <artifactId>field-intercept</artifactId>
                <version>1.0.17</version>
            </dependency>

2. 添加配置，写上业务包名（这是为了减少对象遍历）

        application.yaml里

```yaml

   spring:
      fieldintercept:
         beanBasePackages: 'com.xxx'

```

3. 写一个字典查询实现


      @Component(EnumDBFieldConsumer.NAME)
      public class BaseEnumKeyNameFieldConsumer extends EnumDBFieldIntercept<Object> {
         @Autowired
         private SysDictDataMapper mapper;
      
              @Override
              public Map<String, Map<String, Object>> selectEnumGroupKeyValueMap(Set<String> groups, Collection<Object> keys) {
                  List<SysDictData> list = mapper.selectListByType(groups, keys);
                  Map<String, Map<String, Object>> result = new LinkedHashMap<>(groups.size());
                  for (SysDictData item : list) {
                      result.computeIfAbsent(item.getDictType(), e -> new LinkedHashMap<>())
                              .put(item.getDictValue(), item.getDictLabel());
                  }
                  return result;
              }
          }

4. 定义DTO


      @Data
      public class JobDTO  {
          private Integer source;
          private String nature;
          @EnumDBFieldConsumer(enumGroup = "job_nature", keyField = "natureSplit")
          private String natureName;
          @EnumDBFieldConsumer(enumGroup = "job_source", keyField = "source")
          private String sourceName;
      
          public String[] getNatureSplit() {
              return nature.split("、");
          }
      }


5. 触发查询

         触发查询的入口有两种， 任选其一即可：

          方式1. 方法上标记 @ReturnFieldAop注解。

            @ReturnFieldAop
            public List<JobDTO> selectByIds(Collection<Integer> ids) {
                return jobMapper.selectListByIdList(ids);
            }


         方式2. 主动触发查询
            @Autowired 
            private ReturnFieldDispatchAop returnFieldDispatchAop;

            public List<JobDTO> selectByIds(Collection<Integer> ids) {
                List<JobDTO> list = jobMapper.selectListByIdList(ids);
                returnFieldDispatchAspect.autowiredFieldValue(list);
                return list;
            }

6. 好了，看下JobDTO里的数据已经填充进去了