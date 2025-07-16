package com.cnwy.app.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cnwy.app.demo.entity.SysDictData;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface SysDictDataMapper extends BaseMapper<SysDictData> {
    List<SysDictData> selectListByType(@Param("dictType") Collection<String> dictType, @Param("dictValue") Collection<Object> dictValue);
}
