package com.cnwy.app.demo.service;

import com.cnwy.app.demo.annotation.CnwyFieldAop;
import com.cnwy.app.demo.config.AspectjReturnFieldDispatchAspect;
import com.cnwy.app.demo.entity.vo.JobDTO;
import com.cnwy.app.demo.mapper.JobMapper;
import com.github.fieldintercept.util.FieldCompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class JobServiceImpl {
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private AspectjReturnFieldDispatchAspect returnFieldDispatchAspect;

    // 触发方式1: 由注解触发
    @CnwyFieldAop
    public List<JobDTO> selectByIds1(Collection<Integer> ids) {
        return jobMapper.selectListByIdList(ids);
    }

}
