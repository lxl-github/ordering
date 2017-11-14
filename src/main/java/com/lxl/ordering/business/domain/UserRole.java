package com.lxl.ordering.business.domain;

import java.io.Serializable;
import java.util.Date;

public class UserRole implements Serializable {
    /**
     * upms_user_role.c_id 
     */
    private Integer id;

    /**
     * upms_user_role.c_user_id 用户id
     */
    private Integer userId;

    /**
     * upms_user_role.c_role_id 角色id
     */
    private Integer roleId;

    /**
     * upms_user_role.c_app_id 所属应用系统
     */
    private Integer appId;

    /**
     * upms_user_role.c_create_time 创建时间
     */
    private Integer createTime;

    /**
     * upms_user_role.c_is_deleted 是否删除 0 未删除 1已删除
     */
    private Integer isDeleted;

    /**
     * upms_user_role.c_modified_time 系统修改时间
     */
    private Date modifiedTime;

    /**
     * @return upms_user_role.c_id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for upms_user_role.c_id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return upms_user_role.c_user_id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the value for upms_user_role.c_user_id 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return upms_user_role.c_role_id 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the value for upms_user_role.c_role_id 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return upms_user_role.c_app_id 所属应用系统
     */
    public Integer getAppId() {
        return appId;
    }

    /**
     * @param appId the value for upms_user_role.c_app_id 所属应用系统
     */
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    /**
     * @return upms_user_role.c_create_time 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for upms_user_role.c_create_time 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return upms_user_role.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the value for upms_user_role.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return upms_user_role.c_modified_time 系统修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime the value for upms_user_role.c_modified_time 系统修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}