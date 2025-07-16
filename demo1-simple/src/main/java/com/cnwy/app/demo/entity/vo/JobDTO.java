package com.cnwy.app.demo.entity.vo;

import com.cnwy.app.demo.annotation.CnwyFieldConsumer;
import com.cnwy.app.demo.enums.StringConstants;
import com.cnwy.app.demo.entity.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobDTO extends Job {
    @CnwyFieldConsumer(value = StringConstants.CORP, keyField = "corpId")
    private String corpName;
    @CnwyFieldConsumer(value = StringConstants.CORP, keyField = "corpId")
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
