package com.cnwy.app.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cnwy.app.demo.entity.Job;
import com.cnwy.app.demo.entity.vo.JobDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface JobMapper extends BaseMapper<Job> {

    List<JobDTO> selectListByIdList(@Param("ids") Collection<Integer> ids);
}
