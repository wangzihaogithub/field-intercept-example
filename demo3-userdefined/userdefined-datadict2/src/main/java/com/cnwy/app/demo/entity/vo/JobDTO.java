package com.cnwy.app.demo.entity.vo;

import com.cnwy.app.demo.annotation.CnwyEnumFieldConsumer;
import com.cnwy.app.demo.annotation.CnwyEnumFieldConsumer2;
import com.cnwy.app.demo.annotation.CnwyEnumFieldConsumer3;
import com.cnwy.app.demo.entity.Job;
import com.cnwy.app.demo.enums.SysDictType2Enum;
import com.cnwy.app.demo.enums.SysDictType3Enum;
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

    @CnwyEnumFieldConsumer2(enumGroup = SysDictType2Enum.JOB_NATURE, keyField = "natureSplit")
    private String natureName2;
    @CnwyEnumFieldConsumer2(enumGroup = SysDictType2Enum.JOB_SOURCE, keyField = "source")
    private String sourceName2;

    @CnwyEnumFieldConsumer3(enumGroup = SysDictType3Enum.JOB_NATURE, keyField = "natureSplit")
    private String natureName3;
    @CnwyEnumFieldConsumer3(enumGroup = SysDictType3Enum.JOB_SOURCE, keyField = "source")
    private String sourceName3;

    public String[] getNatureSplit() {
        String nature = getNature();
        return nature == null || nature.isEmpty() ? null : nature.split("、");
    }

}
