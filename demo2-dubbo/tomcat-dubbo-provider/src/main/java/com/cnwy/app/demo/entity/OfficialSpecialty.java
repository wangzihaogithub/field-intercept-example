package com.cnwy.app.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 专业表
 * </p>
 */
@Data
@TableName("official_specialty")
public class OfficialSpecialty implements Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private Integer code;

    /**
     * 专业名称，如 导航工程
     */
    @TableField("name")
    private String name;

    /**
     * 英文别名
     */
    @TableField("name_english")
    private String nameEnglish;

    /**
     * 拼音别名
     */
    @TableField("name_pinyin")
    private String namePinyin;

    /**
     * 简短拼音
     */
    @TableField("name_short_pinyin")
    private String nameShortPinyin;

    /**
     * 等级（如 3 级）
     */
    private Integer level;

    /**
     * 专业来源 本科、硕士、博士
     */
    @TableField("source")
    private String source;

    /**
     * 排序字段
     */
    @TableField("`order`")
    private Integer order;

    /**
     * 父项整数键（如 3）
     */
    @TableField("parent_code")
    private Integer parentCode;

    /**
     * 专业代码
     */
    @TableField("specialty_code")
    private String specialtyCode;

    /**
     * 学位
     */
    @TableField("degree")
    private String degree;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    private String ruleText;


    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


}