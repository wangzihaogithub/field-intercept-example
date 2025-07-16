package com.cnwy.app;

import com.cnwy.app.demo.CnwyAppDemoApplication;
import com.cnwy.app.demo.entity.vo.JobDTO;
import com.cnwy.app.demo.service.JobServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootTest(classes = CnwyAppDemoApplication.class)
class CnwyAppDemoApplicationTests {
    @Autowired
    private JobServiceImpl jobService;
    private static final List<Integer> jobIdList = Arrays.asList(2396313, 2396312, 2396311);

    @Test
    void test1() {
        List<JobDTO> jobDTOList = jobService.selectByIds1(jobIdList);

        jobDTOList.forEach(e -> Assertions.assertNotNull(e.getNatureName()));
        jobDTOList.forEach(e -> Assertions.assertNotNull(e.getNatureName2()));
        jobDTOList.forEach(e -> Assertions.assertNotNull(e.getNatureName3()));


        System.out.println("jobDTOList = " + jobDTOList);
    }

}
