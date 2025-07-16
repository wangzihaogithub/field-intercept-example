package com.cnwy.app.demo.entity.vo;

import com.cnwy.app.demo.annotation.CnwyEnumFieldConsumer;
import com.cnwy.app.demo.entity.Job;
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

}
