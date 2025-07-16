package com.cnwy.app.demo.service;

import com.cnwy.app.demo.entity.Corp;
import com.cnwy.app.demo.enums.StringConstants;
import com.cnwy.app.demo.mapper.CorpMapper;
import com.github.fieldintercept.DefaultCompositeFieldIntercept;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserDefinedServices {

    @Service(StringConstants.CORP)
    public static class CorpServiceImpl extends DefaultCompositeFieldIntercept<String, Corp, JoinPoint> {
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

}
