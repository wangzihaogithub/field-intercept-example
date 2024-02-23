package com.github.wangzihaogithub.case2.service;


import com.github.fieldintercept.CompositeFieldIntercept;
import com.github.fieldintercept.KeyNameFieldIntercept;
import com.github.fieldintercept.KeyValueFieldIntercept;
import com.github.wangzihaogithub.case2.dao.AbstractMapper;
import com.github.wangzihaogithub.case2.po.AbstractPO;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractService<REPOSITORY extends AbstractMapper<PO, ID>,
        PO extends AbstractPO<ID>,
        ID extends Number> implements CompositeFieldIntercept<ID, PO, JoinPoint> {
    private final Class<ID> keyClass = CompositeFieldIntercept.getKeyClass(this, AbstractService.class, "ID", Object.class);
    private final Class<PO> valueClass = CompositeFieldIntercept.getValueClass(this, AbstractService.class, "PO", Object.class);
    private final PropertyDescriptor nameGetter = BeanUtils.getPropertyDescriptor(valueClass, "name");
    @Autowired
    protected REPOSITORY repository;
    private final KeyNameFieldIntercept<ID, JoinPoint> keyNameFieldIntercept = new KeyNameFieldIntercept<>(keyClass, this::selectNameMapByKeys);
    private final KeyValueFieldIntercept<ID, PO, JoinPoint> keyValueFieldIntercept = new KeyValueFieldIntercept<>(keyClass, valueClass, this::selectValueMapByKeys);

    @Override
    public KeyNameFieldIntercept<ID, JoinPoint> keyNameFieldIntercept() {
        return keyNameFieldIntercept;
    }

    @Override
    public KeyValueFieldIntercept<ID, PO, JoinPoint> keyValueFieldIntercept() {
        return keyValueFieldIntercept;
    }

    public List<PO> findByIds(Collection<ID> ids) {
        return repository.findByIds(ids);
    }

    public Map<ID, ?> selectNameMapByKeys(Collection<ID> ids) {
        return convertNames(repository.findByIds(ids));
    }

    public Map<ID, PO> selectValueMapByKeys(Collection<ID> ids) {
        return repository.findByIds(ids).stream()
                .collect(Collectors.toMap(AbstractPO::getId, e -> e));
    }

    protected Map<ID, String> convertNames(List<PO> pos) {
        return pos.stream().collect(Collectors.toMap(AbstractPO::getId, this::convertName));
    }

    protected String convertName(PO po) {
        try {
            return (String) nameGetter.getReadMethod().invoke(po);
        } catch (Exception e) {
            throw new UnsupportedOperationException(valueClass + ".convertName", e);
        }
    }
}
