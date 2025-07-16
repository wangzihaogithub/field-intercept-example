package com.github.wangzihaogithub.case2.controller;

import com.github.fieldintercept.annotation.ReturnFieldAop;
import com.github.fieldintercept.util.FieldCompletableFuture;
import com.github.wangzihaogithub.case2.dto.FolderListResp;
import com.github.wangzihaogithub.case2.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("/folder")
@RestController
public class FolderController {
    @Autowired
    private FolderService folderService;

    /**
     * <pre>
     * http://localhost:8080/folder/selectList?id=7
     * [nio-8080-exec-4] c.g.w.case2.dao.FolderMapper$Mock        : findByIds([7]) end 73/ms
     * [nio-8080-exec-4] c.g.w.case2.dao.FolderMapper$Mock        : findByIds([6]) end 68/ms
     * [nio-8080-exec-4] c.g.w.case2.dao.FolderMapper$Mock        : findByIds([5]) end 95/ms
     * [nio-8080-exec-4] c.g.w.case2.dao.FolderMapper$Mock        : findByIds([4]) end 98/ms
     *
     * http://localhost:8080/folder/selectList?id=1,2,3,4,5,6,7
     * [nio-8080-exec-5] c.g.w.case2.dao.FolderMapper$Mock        : findByIds([1, 2, 3, 4, 5, 6, 7]) end 65/ms
     * [nio-8080-exec-5] c.g.w.case2.dao.FolderMapper$Mock        : findByIds([1, 4, 5, 6]) end 103/ms
     * </pre>
     *
     * @param id
     * @return
     */
    @RequestMapping("/selectList")
    public List<FolderListResp> selectList(Long[] id) {
        if (id == null) {
            return Collections.emptyList();
        } else {
            return folderService.selectList(Arrays.asList(id));
        }
    }

    @ReturnFieldAop
    @RequestMapping("/selectListAsync")
    public FieldCompletableFuture<Map<String, List<FolderListResp>>> selectListAsync(Long[] id) {
        return FieldCompletableFuture.completableFuture(Arrays.asList(id))
                .thenApply(idList -> {
                    List<FolderListResp> list = new ArrayList<>();
                    for (Long id1 : idList) {
                        FolderListResp resp = new FolderListResp();
                        resp.setId(id1);
                        list.add(resp);
                    }
                    return list;
                })
                .thenApply(list -> {
                    List<FolderListResp> list12345 = Stream.of(1, 2, 3, 4, 5).map(e -> {
                        FolderListResp resp = new FolderListResp();
                        resp.setId(Long.valueOf(e));
                        return resp;
                    }).collect(Collectors.toList());

                    Map<String, List<FolderListResp>> map = new HashMap<>();
                    map.put("list", list);
                    map.put("固定12345", list12345);
                    return map;
                })
                .exceptionally(throwable -> {
                    System.out.println("throwable = " + throwable);
                    return null;
                })
                ;
    }
}
