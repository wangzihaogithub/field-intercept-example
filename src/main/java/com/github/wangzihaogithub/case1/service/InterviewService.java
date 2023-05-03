package com.github.wangzihaogithub.case1.service;

import com.github.wangzihaogithub.case1.dao.InterviewMapper;
import com.github.wangzihaogithub.case1.enumer.Providers;
import com.github.wangzihaogithub.case1.po.InterviewPO;
import org.springframework.stereotype.Service;

@Service(Providers.INTERVIEW)
public class InterviewService extends AbstractService<InterviewMapper, InterviewPO, Long> {

}
