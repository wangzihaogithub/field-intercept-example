package com.cnwy.app.demo.enums;

/**
 * 基础枚举分组 sys_dict_type
 * SELECT concat(UPPER(dict_type), '(','"',dict_type,'",','"',ifnull(remark,''),'"),') from sys_dict_type
 */
public enum SysDictType3Enum {
    /**/
    SYS_USER_SEX("sys_user_sex", "系统"),
    SYS_SHOW_HIDE("sys_show_hide", "系统"),
    SYS_NORMAL_DISABLE("sys_normal_disable", "系统"),
    SYS_JOB_STATUS("sys_job_status", "系统"),
    SYS_JOB_GROUP("sys_job_group", "系统"),
    SYS_YES_NO("sys_yes_no", "系统"),
    SYS_NOTICE_TYPE("sys_notice_type", "系统"),
    SYS_NOTICE_STATUS("sys_notice_status", "系统"),
    SYS_OPER_TYPE("sys_oper_type", "系统"),
    SYS_COMMON_STATUS("sys_common_status", "系统"),
    STUDENT_EDUCATION("student_education", "学生、岗位表单字段，学历"),
    STUDENT_PROJECT_TYPE("student_project_type", "产品类型"),
    STUDENT_PARTY("student_party", "学生的政治面貌"),
    STUDENT_ENGLISH_LEVEL("student_english_level", "学生英语等级"),
    STUDENT_COMPUTER_LEVEL("student_computer_level", "计算机等级"),
    STUDENT_SERVER_TAG("student_server_tag", "学生报名服务标签； 标签主题样式参考前端代码， src/assets/styles/btn.scss"),
    STUDENT_PROJECT_LEVEL("student_project_level", "产品类别，由学生的状态来决定"),
    STUDENT_CLASS_YEAR("student_class_year", "学生届别"),
    STUDENT_SOURCE("student_source", "国内/国外"),
    STUDENT_INTERVIEW("student_interview", "学生的求职进度字典"),
    JOB_ERROR_CODE("job_error_code", "岗位"),
    STUDENT_TAGS("student_tags", "学员标签，仅项目组维护，单个学员可打多个标签"),
    SYS_NATION("sys_nation", "民族字典"),
    AGREEMENT_ONLINE_BEING("agreement_online_being", "商学院，网申表，处理状态"),
    AGREEMENT_STEP_STATUS("agreement_step_status", "商学院，网申，进度状态"),
    AGREEMENT_ONLINE_TYPE("agreement_online_type", "商学院，网申表，网申类别"),
    AGREEMENT_ONLINE_STATUS("agreement_online_status", "商学院，网申管理，整体状态"),
    AGREEMENT_STUDY_TYPE("agreement_study_type", "商学院, 学习列表，学习类型"),
    AGREEMENT_PIGEONHOLE_STATUS("agreement_pigeonhole_status", "商学院，申请添加，归档状态"),
    JOB_STATUS("job_status", "岗位"),
    JOB_SORT("job_sort", "岗位"),
    AGREEMENT_GROUP_TYPE("agreement_group_type", "agreement_group_type"),
    AGREEMENT_SERVER_STATUS("agreement_server_status", "学员服务状态"),
    STUDENT_CLASSES("student_classes", ""),
    STUDENT_DOMESTIC_FOREIGN("student_domestic_foreign", ""),
    AGREEMENT_STUDENT_TAG("agreement_student_tag", "商学院学员服务属性"),
    UNION_KEY_FIELD("union_key_field", "企业唯一建生成规则"),
    JOB_SYNC_STATUS("job_sync_status", "岗位-同步表专用"),
    JOB_SYNC_ISSUE_DATE("job_sync_issue_date", "采集专用"),
    JOB_SYNC_EXPERIENCE("job_sync_experience", "采集专用"),
    JOB_SYNC_NATURE("job_sync_nature", "采集专用"),
    JOB_SYNC_COMPANY_NATURE("job_sync_company_nature", "采集专用"),
    JOB_SYNC_EDUCATION("job_sync_education", "采集专用"),
    JOB_SYNC_SOURCE("job_sync_source", "采集专用"),
    JOB_NATURE("job_nature", "岗位"),
    JOB_COMPANY_NATURE("job_company_nature", "岗位"),
    JOB_SOURCE("job_source", "岗位"),
    JOB_EDUCATION("job_education", "岗位"),
    JOB_CLASS_YEAR("job_class_year", "岗位"),
    JOB_PARTY("job_party", "岗位"),
    JOB_ENGLISH_LEVEL("job_english_level", "岗位"),
    JOB_SYNC_DATA_SOURCE("job_sync_data_source", "岗位-同步表专用"),
    WHOLE_STUDENT_EDUCATION("whole_student_education", ""),
    JOB_SOURCE_SEARCH("job_source_search", ""),
    STUDENT_SCHEDULER_CORN("student_scheduler_corn", ""),
    WHOLE_STUDENT_STATUS("whole_student_status", ""),
    WHOLE_STUDENT_TAG("whole_student_tag", ""),
    WHOLE_STUDENT_PRODUCT("whole_student_product", ""),
    SYS_TASKS_FROM("sys_tasks_from", ""),
    SYS_TASKS_STATUS("sys_tasks_status", ""),
    WHOLE_PUSH_JOB_FROM("whole_push_job_from", ""),
    WHOLE_STUDENT_EDUCATION_TYPE("whole_student_education_type", ""),
    WHOULE_PUSH_JOB_STEP("whoule_push_job_step", "推送岗位进度"),
    QUALITY_PUNISH_STATE("quality_punish_state", "质检处罚状态"),
    WHOLD_STUDENT_SORT_BY("whold_student_sort_by", "匹配，学员列表、我的学员排序方式"),
    STUDENT_SERVICE_CYCLE("student_service_cycle", ""),
    STUDENT_WEEKLY("student_weekly", ""),
    MATCHER_JOB_SHIELD("matcher_job_shield", ""),
    SHARE_COLLECTION_FOLDER("share_collection_folder", ""),
    JOB_PROGRESS_SORT("job_progress_sort", ""),
    JOB_SESSION("job_session", ""),
    COLL_UNION_KEY_FIELD("coll_union_key_field", "同步记录批量编辑"),
    ONE_CLICK_MATCH_COMP_BLOCK_KEYS("one_click_match_comp_block_keys", ""),
    BOSS_PRODUCT_TYPE("boss_product_type", ""),
    BOSS_ORDER_STATE("boss_order_state", ""),
    BOSS_REFUND_STATE("boss_refund_state", ""),
    BOSS_SERVICE_STATE("boss_service_state", ""),
    ;

    private final String group;
    private final String remark;

    SysDictType3Enum(String group, String remark) {
        this.group = group;
        this.remark = remark;
    }

    public String getGroup() {
        return group;
    }

    public String getRemark() {
        return remark;
    }
}
