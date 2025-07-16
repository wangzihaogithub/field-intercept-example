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

    // 触发方式1: 由注解触发
    @CnwyFieldAop
    public CompletableFuture<List<JobDTO>> selectByIds3(Collection<Integer> ids) {
        return new FieldCompletableFuture<>(jobMapper.selectListByIdList(ids));
    }

    // 触发方式2: 主动调用触发
    public List<JobDTO> selectByIds5(Collection<Integer> ids) {
        List<JobDTO> list = jobMapper.selectListByIdList(ids);
        returnFieldDispatchAspect.autowiredFieldValue(list);
        return list;
    }

    // 触发方式2: 主动调用触发
    public List<JobDTO> selectByIds6(Collection<Integer> ids) {
        List<JobDTO> list = jobMapper.selectListByIdList(ids);
        returnFieldDispatchAspect.parallelAutowiredFieldValue(list);
        return list;
    }

    // 触发方式2: 主动调用触发
    public CompletableFuture<List<JobDTO>> selectByIds7(Collection<Integer> ids) {
        CompletableFuture<List<JobDTO>> future = new FieldCompletableFuture<>(jobMapper.selectListByIdList(ids));
        returnFieldDispatchAspect.autowiredFieldValue(future);
        return future;
    }

    // 触发方式2: 主动调用触发
    public CompletableFuture<List<JobDTO>> selectByIds8(Collection<Integer> ids) {
        CompletableFuture<List<JobDTO>> future = new FieldCompletableFuture<>(jobMapper.selectListByIdList(ids));
        returnFieldDispatchAspect.parallelAutowiredFieldValue(future);
        return future;
    }
}
