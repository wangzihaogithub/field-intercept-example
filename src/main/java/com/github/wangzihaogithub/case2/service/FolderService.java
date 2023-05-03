package com.github.wangzihaogithub.case2.service;

import com.github.fieldintercept.annotation.ReturnFieldAop;
import com.github.wangzihaogithub.case2.dao.FolderMapper;
import com.github.wangzihaogithub.case2.dto.FolderListResp;
import com.github.wangzihaogithub.case2.enumer.Providers;
import com.github.wangzihaogithub.case2.po.FolderPO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service(Providers.FOLDER)
public class FolderService extends AbstractService<FolderMapper, FolderPO, Long> {

    @ReturnFieldAop
    public List<FolderListResp> selectList(Collection<Long> ids) {
        return repository.findByIds(ids).stream()
                .map(e -> {
                    FolderListResp resp = new FolderListResp();
                    resp.setName(e.getName());
                    resp.setParentId(e.getParentId());
                    resp.setId(e.getId());
                    return resp;
                })
                .collect(Collectors.toList());
    }

}
