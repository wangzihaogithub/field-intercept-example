package com.cnwy.app.demo.service;

import com.cnwy.app.demo.entity.SysDictData;
import com.cnwy.app.demo.mapper.SysDictDataMapper;
import com.github.fieldintercept.EnumDBFieldIntercept;
import com.github.fieldintercept.annotation.EnumDBFieldConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SysDictDataServiceImpl extends AbstractCrudService<SysDictDataMapper, SysDictData, Long> {

    @Component(EnumDBFieldConsumer.NAME)
    public static class BaseEnumKeyNameFieldConsumer extends EnumDBFieldIntercept<Object> {
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
}
