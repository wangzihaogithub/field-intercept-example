package com.cnwy.app.demo.entity.vo;

import com.cnwy.app.demo.annotation.CnwyEnumFieldConsumer;
import com.cnwy.app.demo.annotation.CnwyFieldConsumer;
import com.cnwy.app.demo.entity.Job;
import com.cnwy.app.demo.enums.StringConstants;
import com.cnwy.app.demo.enums.SysDictTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobDTO extends Job {
    @CnwyEnumFieldConsumer(enumGroup = SysDictTypeEnum.JOB_NATURE, keyField = "natureSplit")
    private String natureName;
    @CnwyEnumFieldConsumer(enumGroup = SysDictTypeEnum.JOB_SOURCE, keyField = "source")
    private String sourceName;
    @CnwyFieldConsumer(value = StringConstants.SYS_USER, keyField = "createUser")
    private String createUserName;
    @CnwyFieldConsumer(value = StringConstants.SYS_USER, keyField = "updateUser")
    private String updateUserName;
    @CnwyFieldConsumer(value = StringConstants.CORP, keyField = "corpId")
    private String corpName;
    @CnwyFieldConsumer(value = StringConstants.CORP, keyField = "corpId")
    private CorpDTO corp;

    public String[] getNatureSplit() {
        String nature = getNature();
        return nature == null || nature.isEmpty() ? null : nature.split("、");
    }

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
