package com.cnwy.app.demo.entity.vo;

import com.cnwy.app.demo.annotation.CnwyCorpSetter;
import com.cnwy.app.demo.entity.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobDTO extends Job {

    @CnwyCorpSetter
    private String corpName;
    @CnwyCorpSetter
    private CorpDTO corp;

    @Data
    public static class CorpDTO {
        // @ApiModelProperty(value = "ID")
        private String id;

        // @ApiModelProperty(value = "公司名称")
        private String name;

        /**
         * 注册地址
         */
        private String regLocation;

    }
}
