package com.lxl.ordering.business.domain;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable {
    /**
     * upms_application.c_id 
     */
    private Integer id;

    /**
     * upms_application.c_name 应用系统名称(如：somp)
     */
    private String name;

    /**
     * upms_application.c_app_key 应用系统key唯一码
     */
    private String appKey;

    /**
     * upms_application.c_icon 应用系统图标
     */
    private String icon;

    /**
     * upms_application.c_base_path 应用系统根目录
     */
    private String basePath;

    /**
     * upms_application.c_title 应用系统标题（如：门店运营管理后台系统）
     */
    private String title;

    /**
     * upms_application.c_status 应用系统状态（1启用 0停用）
     */
    private Integer status;

    /**
     * upms_application.c_orders 排序（1,2,3,4）
     */
    private Integer orders;

    /**
     * upms_application.c_description 应用系统描述
     */
    private String description;

    /**
     * upms_application.c_create_time 创建时间
     */
    private Integer createTime;

    /**
     * upms_application.c_is_deleted 是否删除 0 未删除 1已删除
     */
    private Integer isDeleted;

    /**
     * upms_application.c_modified_time 系统修改时间
     */
    private Date modifiedTime;

    /**
     * @return upms_application.c_id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for upms_application.c_id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return upms_application.c_name 应用系统名称(如：somp)
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the value for upms_application.c_name 应用系统名称(如：somp)
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return upms_application.c_app_key 应用系统key唯一码
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * @param appKey the value for upms_application.c_app_key 应用系统key唯一码
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    /**
     * @return upms_application.c_icon 应用系统图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the value for upms_application.c_icon 应用系统图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * @return upms_application.c_base_path 应用系统根目录
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * @param basePath the value for upms_application.c_base_path 应用系统根目录
     */
    public void setBasePath(String basePath) {
        this.basePath = basePath == null ? null : basePath.trim();
    }

    /**
     * @return upms_application.c_title 应用系统标题（如：门店运营管理后台系统）
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the value for upms_application.c_title 应用系统标题（如：门店运营管理后台系统）
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return upms_application.c_status 应用系统状态（1启用 0停用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the value for upms_application.c_status 应用系统状态（1启用 0停用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return upms_application.c_orders 排序（1,2,3,4）
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * @param orders the value for upms_application.c_orders 排序（1,2,3,4）
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * @return upms_application.c_description 应用系统描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the value for upms_application.c_description 应用系统描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return upms_application.c_create_time 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for upms_application.c_create_time 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return upms_application.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the value for upms_application.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return upms_application.c_modified_time 系统修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime the value for upms_application.c_modified_time 系统修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}