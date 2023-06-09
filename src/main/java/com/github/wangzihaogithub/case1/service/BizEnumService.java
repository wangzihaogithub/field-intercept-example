package com.github.wangzihaogithub.case1.service;

import com.github.fieldintercept.EnumDBFieldIntercept;
import com.github.wangzihaogithub.case1.dao.BizEnumMapper;
import com.github.wangzihaogithub.case1.enumer.BizEnumGroupEnum;
import com.github.wangzihaogithub.case1.po.BizEnumPO;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BizEnumService extends AbstractService<BizEnumMapper, BizEnumPO, Long> {

    @Component
    public static class BizEnumDBFieldIntercept extends EnumDBFieldIntercept {
        @Resource
        private BizEnumMapper mapper;

        @Override
        public String[] getGroups(Annotation annotation) {
            String[] groups = super.getGroups(annotation);
            if (groups == null) {
                BizEnumGroupEnum[] value = (BizEnumGroupEnum[]) AnnotationUtils.getValue(annotation);
                groups = Stream.of(value).map(BizEnumGroupEnum::getGroup)
                        .toArray(String[]::new);
            }
            return groups;
        }

        @Override
        public Map<String, Map<String, Object>> selectEnumGroupKeyValueMap(Set<String> groups, Collection<Object> keys) {
            return mapper.selectEnumGroupKeyValueList(groups, keys).stream()
                    .collect(Collectors.groupingBy(BizEnumPO::getGroup,
                            Collectors.toMap(BizEnumPO::getKey, e -> e)));
        }

    }
}
