package com.lxl.ordering.business.domain;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    /**
     * upms_role.c_id 
     */
    private Integer id;

    /**
     * upms_role.c_name 角色名称
     */
    private String name;

    /**
     * upms_role.c_title 角色标题
     */
    private String title;

    /**
     * upms_role.c_status 角色状态（1启用 0停用）
     */
    private Integer status;

    /**
     * upms_role.c_app_id 所属应用系统id
     */
    private Integer appId;

    /**
     * 应用系统标题
     */
    private String appTitle;

    /**
     * upms_role.c_description 角色描述
     */
    private String description;

    /**
     * upms_role.c_create_time 创建时间
     */
    private Integer createTime;

    /**
     * upms_role.c_is_deleted 是否删除 0 未删除 1已删除
     */
    private Integer isDeleted;

    /**
     * upms_role.c_modified_time 系统修改时间
     */
    private Date modifiedTime;

    /**
     * @return upms_role.c_id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for upms_role.c_id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return upms_role.c_name 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the value for upms_role.c_name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return upms_role.c_title 角色标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the value for upms_role.c_title 角色标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return upms_role.c_status 角色状态（1启用 0停用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the value for upms_role.c_status 角色状态（1启用 0停用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return upms_role.c_description 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the value for upms_role.c_description 角色描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    /**
     * @return upms_role.c_create_time 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for upms_role.c_create_time 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return upms_role.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the value for upms_role.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return upms_role.c_modified_time 系统修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime the value for upms_role.c_modified_time 系统修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}