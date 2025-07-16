package com.cnwy.app.demo.controller;

import com.cnwy.app.demo.annotation.CnwyFieldAop;
import com.cnwy.app.demo.entity.vo.JobDTO;
import com.cnwy.app.demo.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobMapper jobMapper;

    @CnwyFieldAop
    @RequestMapping("/selectById")
    public List<JobDTO>selectById(Integer[] id) {
        List<JobDTO> jobDTOList = jobMapper.selectListByIdList(Arrays.asList(id));
        return jobDTOList;
    }
}
