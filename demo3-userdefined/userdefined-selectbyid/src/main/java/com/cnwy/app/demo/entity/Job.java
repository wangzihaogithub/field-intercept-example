package com.cnwy.app.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("job")
// @ApiModel(description = "岗位信息实体类")
public class Job implements java.io.Serializable{

    @TableId(type = IdType.AUTO)
    // @ApiModelProperty(value = "岗位ID")
    private Integer id;

    // @ApiModelProperty(value = "岗位类别，可以是 全职、实习 或 兼职")
    private String type;

    // @ApiModelProperty(value = "岗位类型，可以是 校招 或 社招")
    private String nature;

    // @ApiModelProperty(value = "岗位来源")
    private Integer source;

    // @ApiModelProperty(value = "问题岗位标记，1有问题")
    private Integer status;


    // @ApiModelProperty(value = "公司名称")
    private String companyName;


    // @ApiModelProperty(value = "公司连接")
    private String companyLink;


    // @ApiModelProperty(value = "岗位名")
    private String name;

    // @ApiModelProperty(value = "岗位工作地")
    private String region;

    // @ApiModelProperty(value = "岗位链接")
    private String link;

    // @ApiModelProperty(value = "招聘公告url")
    private String noticeUrl;

    // @ApiModelProperty(value = "专业")
    private String specialty;

    // @ApiModelProperty(value = "学历")
    private String education;

    // @ApiModelProperty(value = "英语要求")
    private String foreignLang;

    // @ApiModelProperty(value = "政治面貌")
    private String political;

    // @ApiModelProperty(value = "届别要求 22届 23届 应届生")
    private String session;

    // @ApiModelProperty(value = "经验要求 在校生、应届生、经验不限、1年以内、1-3年、3-5年、5-10年")
    private String year;

    // @ApiModelProperty(value = "最低工作年限 0")
    private Integer yearLow;

    // @ApiModelProperty(value = "最高工作年限 100")
    private Integer yearHigh;

    // @ApiModelProperty(value = "经验要求  无人机航测 软件编程经验")
    private String experience;

    // @ApiModelProperty(value = "福利待遇")
    private String welfare;

    // @ApiModelProperty(value = "招聘内容")
    private String content;

    // @ApiModelProperty(value = "性别要求 1 男 、2 女")
    private Integer gender;

    // @ApiModelProperty(value = "招聘人数 1人 若干")
    private Integer account;

    // @ApiModelProperty(value = "年龄要求")
    private String age;

    // @ApiModelProperty(value = "最低年龄 0")
    private Integer ageLow;

    // @ApiModelProperty(value = "最高年龄 100")
    private Integer ageHigh;

    // @ApiModelProperty(value = "开始报名时间")
    private Date jobStartTime;

    // @ApiModelProperty(value = "截止报名时间")
    private Date jobEndTime;

    // @ApiModelProperty(value = "源数据id", required = true)
    private String targetId;

    // @ApiModelProperty(value = "创建人")
    private Integer createUser;

    // @ApiModelProperty(value = "创建时间")
    private Date createTime;

    // @ApiModelProperty(value = "修改人")
    private Integer updateUser;

    // @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    // @ApiModelProperty(value = "删除人")
    private String deleteUser;

    // @ApiModelProperty(value = "删除时间")
    private Date deleteTime;

    // @ApiModelProperty(value = "删除原因")
    private String deleteReason;

    // @ApiModelProperty(value = "撤回人")
    private String revocationUser;

    // @ApiModelProperty(value = "撤回时间")
    private Date revocationTime;


    // @ApiModelProperty(value = "撤回原因")
    private String revocationReason;

    // @ApiModelProperty(value = "过期时间")
    private Date expireTime;

    // @ApiModelProperty(value = "过期人")
    private String expireUser;


    private String corpId;


}
