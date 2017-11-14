package com.lxl.ordering.business.domain;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    /**
     * upms_user_info.c_id 
     */
    private Integer id;

    /**
     * upms_user_info.c_user_number 用户工号
     */
    private String userNumber;

    /**
     * upms_user_info.c_user_name 用户名称
     */
    private String userName;

    /**
     * upms_user_info.c_status 用户状态（1启用 0停用）
     */
    private Integer status;

    /**
     * upms_user_info.c_create_time 创建时间
     */
    private Integer createTime;

    /**
     * upms_user_info.c_is_deleted 是否删除 0 未删除 1已删除
     */
    private Integer isDeleted;

    /**
     * upms_user_info.c_modified_time 系统修改时间
     */
    private Date modifiedTime;

    /**
     * @return upms_user_info.c_id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for upms_user_info.c_id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return upms_user_info.c_user_number 用户工号
     */
    public String getUserNumber() {
        return userNumber;
    }

    /**
     * @param userNumber the value for upms_user_info.c_user_number 用户工号
     */
    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    /**
     * @return upms_user_info.c_user_name 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the value for upms_user_info.c_user_name 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return upms_user_info.c_status 用户状态（1启用 0停用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the value for upms_user_info.c_status 用户状态（1启用 0停用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return upms_user_info.c_create_time 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for upms_user_info.c_create_time 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return upms_user_info.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the value for upms_user_info.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return upms_user_info.c_modified_time 系统修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime the value for upms_user_info.c_modified_time 系统修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}