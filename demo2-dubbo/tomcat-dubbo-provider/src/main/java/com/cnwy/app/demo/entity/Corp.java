package com.cnwy.app.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

//@ApiModel(value = "Corp对象", description = "企业表")
@Data
@TableName("corp")
public class Corp implements java.io.Serializable{

    // @ApiModelProperty(value = "ID")
    @TableId(type = IdType.NONE)
    private String id;

    // @ApiModelProperty(value = "公司名称")
    @TableField("name")
    private String name;

    // @ApiModelProperty(value = "官网url")
    @TableField("home_url")
    private String homeUrl;

    // @ApiModelProperty(value = "来源\n" +
//            "tyc=天眼查")
    @TableField("source_enum")
    private String sourceEnum;

    // @ApiModelProperty(value = "统一社会信用代码\n")
    @TableField("credit_code")
    private String creditCode;

    // @ApiModelProperty(value = "记录创建时间")
    @TableField("create_time")
    private Date createTime;

    //    @ApiModelProperty(value = "记录修改时间")
    @TableField("update_time")
    private Date updateTime;

    // @ApiModelProperty(value = "登记状态\n" +
//            "存续（在营、开业、在册）仍注册、其他、吊销、在业、存续、已告解散、已歇业、已解散、废止、撤销、核准许可登记、核准设立、正常、注销、被撤销、证书废止、迁出、非独立实体")
    @TableField("status")
    private Integer status;

    // @ApiModelProperty(value = "爬虫给的唯一ID")
    @TableField("unique_key")
    private String uniqueKey;

    //    @ApiModelProperty(value = "登记状态\n" +
//            "存续（在营、开业、在册）仍注册、其他、吊销、在业、存续、已告解散、已歇业、已解散、废止、撤销、核准许可登记、核准设立、正常、注销、被撤销、证书废止、迁出、非独立实体")
    @TableField("register_status_name")
    private String registerStatusName;

//    @TableField("nature_enum")
//    private String natureEnum;

    // @ApiModelProperty(value = "是否视为央国企,布尔")
    @TableField("central_country_ent_flag")
    private Boolean centralCountryEntFlag;

    //    @ApiModelProperty(value = "是否人工添加企业,布尔")
    @TableField("manual_flag")
    private Boolean manualFlag;

    @TableField("create_user")
    private Integer createUser;

    @TableField("update_user")
    private Integer updateUser;

    @TableField("group_name")
    private String groupName;

    /**
     * 0 企业库 1 虚拟企业
     */
    @TableField("data_type")
    private Integer dataType;

    /**
     * 根名称，优先集团名称，否则公司名称
     */
    @TableField("root_name")
    private String rootName;

    /**
     * 老数据（4万+）封存不动 与新增企业分隔开这个事情, 确保数据完全分离
     * ALTER TABLE `corp`
     * ADD COLUMN `dir` varchar(10) NOT NULL COMMENT '老数据（4万+）封存不动 与新增企业分隔开这个事情, 确保数据完全分离'
     */
    @TableField("dir")
    private String dir;

    /**
     * 人员规模
     */
    @TableField("staff_num_range")
    private String staffNumRange;

    /**
     * 注册资本
     */
    @TableField("reg_capital")
    private String regCapital;

    /**
     * 法人
     */
    @TableField("legal_person_name")
    private String legalPersonName;

    /**
     * 成立时间
     */
    @TableField("establish_time")
    private String establishTime;

    /**
     * 企业类型
     */
    @TableField("company_org_type")
    private String companyOrgType;

    /**
     * 注册地址
     */
    @TableField("reg_location")
    private String regLocation;


}
