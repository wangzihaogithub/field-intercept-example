package com.github.wangzihaogithub.case1.dto;

import com.github.fieldintercept.annotation.FieldConsumer;
import com.github.wangzihaogithub.case1.enumer.Providers;

import java.util.LinkedList;
import java.util.List;

public class FolderListResp {
    private Long id;
    @FieldConsumer(value = Providers.FOLDER, keyField = "id", valueField = "./")
    private String name;
    @FieldConsumer(value = Providers.FOLDER, keyField = "id", valueField = "./")
    private Long parentId;
    @FieldConsumer(value = Providers.FOLDER, keyField = "parentId")
    private FolderListResp parent;

    public String getNamePath() {
        List<String> list = new LinkedList<>();
        for (FolderListResp curr = this; curr != null; curr = curr.parent) {
            list.add(0, curr.name);
        }
        return String.join("/", list);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FolderListResp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", parent=" + parent +
                '}';
    }
}
