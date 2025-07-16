package com.cnwy.app.demo.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.repository.CrudRepository;
import com.github.fieldintercept.CompositeFieldIntercept;
import com.github.fieldintercept.KeyNameFieldIntercept;
import com.github.fieldintercept.KeyValueFieldIntercept;
import com.github.fieldintercept.util.TypeUtil;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AbstractCrudService<
        M extends BaseMapper<PO>, PO, ID extends Serializable>
        extends com.baomidou.mybatisplus.extension.repository.CrudRepository<M, PO>
        implements com.github.fieldintercept.CompositeFieldIntercept<ID, PO, Object> {
    private final Class<ID> keyClass = TypeUtil.findGenericType(this, AbstractCrudService.class, "ID");
    private final Class<PO> valueClass = TypeUtil.findGenericType(this, AbstractCrudService.class, "PO");
    // 加个字段，用户支持注入名称（例：员工表=部门/员工名称）
    private final KeyNameFieldIntercept<ID, Object> keyNameFieldIntercept = new KeyNameFieldIntercept<>(keyClass, this::selectNameMapByKeys);
    // 加个字段，用于支持注入实体类Like (例：List<SysUserVO>, SysUser, SysUserDTO)
    private final KeyValueFieldIntercept<ID, PO, Object> keyValueFieldIntercept = new KeyValueFieldIntercept<>(keyClass, valueClass, this::selectValueMapByKeys);

    // 这个方法你可以实现的，因为持久化框架都默认实现了ByIds的查询
    public Map<ID, String> selectNameMapByKeys(Collection<ID> ids) {
        M baseMapper = getBaseMapper();
        List<PO> list = baseMapper.selectByIds(ids);
        return convertNames(list);
    }

    // 这个方法你可以实现的，因为持久化框架都默认实现了ByIds的查询
    public Map<ID, PO> selectValueMapByKeys(Collection<ID> ids) {
        M baseMapper = getBaseMapper();
        return baseMapper.selectByIds(ids).stream()
                .collect(Collectors.toMap(idGetterFunction(), e -> e));
    }

    private Function<PO, ID> idGetterFunction() {
        TableInfo tableInfo = TableInfoHelper.getTableInfo(this.getEntityClass());
        Assert.notNull(tableInfo, "error: can not execute. because can not find cache of TableInfo for entity!", new Object[0]);
        String keyProperty = tableInfo.getKeyProperty();
        Assert.notEmpty(keyProperty, "error: can not execute. because can not find column for id from entity!", new Object[0]);
        return po -> (ID) tableInfo.getPropertyValue(po, tableInfo.getKeyProperty());
    }

    protected Function<PO, String> nameGetterFunction() {
        TableInfo tableInfo = TableInfoHelper.getTableInfo(this.getEntityClass());
        Assert.notNull(tableInfo, "error: can not execute. because can not find cache of TableInfo for entity!", new Object[0]);
        String keyProperty = tableInfo.getKeyProperty();
        Assert.notEmpty(keyProperty, "error: can not execute. because can not find column for id from entity!", new Object[0]);
        return po -> Objects.toString(tableInfo.getPropertyValue(po, "name"), null);
    }

    // 显示名称的拼接格式
    protected Map<ID, String> convertNames(List<PO> list) {
        return list.stream().collect(Collectors.toMap(idGetterFunction(), nameGetterFunction()));
    }

    @Override
    public KeyNameFieldIntercept<ID, Object> keyNameFieldIntercept() {
        return keyNameFieldIntercept;
    }

    @Override
    public KeyValueFieldIntercept<ID, PO, Object> keyValueFieldIntercept() {
        return keyValueFieldIntercept;
    }

}
