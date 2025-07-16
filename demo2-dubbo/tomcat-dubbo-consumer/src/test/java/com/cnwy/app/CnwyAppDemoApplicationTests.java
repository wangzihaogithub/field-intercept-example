package com.cnwy.app;

import com.cnwy.app.demo.CnwyAppDemoConsumerApplication;
import com.cnwy.app.demo.entity.vo.JobDTO;
import com.cnwy.app.demo.service.JobServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootTest(classes = CnwyAppDemoConsumerApplication.class)
class CnwyAppDemoApplicationTests {
    @Autowired
    private JobServiceImpl jobService;
    private static final List<Integer> jobIdList = Arrays.asList(2396313, 2396312, 2396311);

    @Test
    void test1() {
        List<JobDTO> jobDTOList = jobService.selectByIds1(jobIdList);

        jobDTOList.forEach(e -> Assertions.assertNotNull(e.getNatureName()));
        jobDTOList.forEach(e -> Assertions.assertNotNull(e.getCorpName()));

        jobDTOList.forEach(e -> System.out.println(e.getNatureName()));
        jobDTOList.forEach(e -> System.out.println(e.getCorpName()));

        System.out.println("jobDTOList = " + jobDTOList);
    }

    @Test
    void test2() {
        List<JobDTO> jobDTOList = jobService.selectByIds5(jobIdList);

        jobDTOList.forEach(e -> Assertions.assertNotNull(e.getNatureName()));
        jobDTOList.forEach(e -> Assertions.assertNotNull(e.getCorpName()));

        jobDTOList.forEach(e -> System.out.println(e.getNatureName()));
        jobDTOList.forEach(e -> System.out.println(e.getCorpName()));

        System.out.println("jobDTOList = " + jobDTOList);
    }

    @Test
    void test3() {
        Thread mainThread = Thread.currentThread();

        CompletableFuture<List<JobDTO>> future1 = jobService.selectByIds7(jobIdList);
        future1.whenComplete((jobDTOList, throwable) -> {
            jobDTOList.forEach(e -> Assertions.assertNotNull(e.getNatureName()));
            jobDTOList.forEach(e -> Assertions.assertNotNull(e.getCorpName()));

            jobDTOList.forEach(e -> System.out.println(e.getNatureName()));
            jobDTOList.forEach(e -> System.out.println(e.getCorpName()));

            System.out.println("jobDTOList = " + jobDTOList);

            // 在主线程上执行
            Assertions.assertEquals(mainThread, Thread.currentThread());
        });

        CompletableFuture<List<JobDTO>> future2 = jobService.selectByIds8(jobIdList);
        future2.whenComplete((jobDTOList, throwable) -> {
            jobDTOList.forEach(e -> Assertions.assertNotNull(e.getNatureName()));
            jobDTOList.forEach(e -> Assertions.assertNotNull(e.getCorpName()));

            jobDTOList.forEach(e -> System.out.println(e.getNatureName()));
            jobDTOList.forEach(e -> System.out.println(e.getCorpName()));

            System.out.println("jobDTOList = " + jobDTOList);

            // 在回调线程上执行
            Assertions.assertNotEquals(mainThread, Thread.currentThread());
        });

        future1.join();
        future2.join();
    }
}
