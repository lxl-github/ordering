package com.lxl.ordering.business.domain;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable {

    /**
     * upms_menu.c_id 
     */
    private Integer id;

    /**
     * upms_menu.c_name 资源名称
     */
    private String name;

    /**
     * upms_menu.c_type 资源类型 1:目录 2:菜单 3:按钮
     */
    private Integer type;

    /**
     * upms_menu.c_parent_id 父级id
     */
    private Integer parentId;

    /**
     * upms_menu.c_url 资源路径
     */
    private String url;

    /**
     * upms_menu.c_permission_value 资源权限码
     */
    private String permissionValue;

    /**
     * upms_menu.c_orders 排序（1,2,3,4）
     */
    private Integer orders;

    /**
     * upms_menu.c_app_id 所属应用系统id
     */
    private Integer appId;

    /**
     * 应用系统标题
     */
    private String appTitle;

    /**
     * upms_menu.c_create_time 创建时间
     */
    private Integer createTime;

    /**
     * upms_menu.c_is_deleted 是否删除 0 未删除 1已删除
     */
    private Integer isDeleted;

    /**
     * upms_menu.c_modified_time 系统修改时间
     */
    private Date modifiedTime;

    /**
     * @return upms_menu.c_id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for upms_menu.c_id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return upms_menu.c_name 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the value for upms_menu.c_name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return upms_menu.c_type 资源类型 1:目录 2:菜单 3:按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the value for upms_menu.c_type 资源类型 1:目录 2:菜单 3:按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return upms_menu.c_parent_id 父级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId the value for upms_menu.c_parent_id 父级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return upms_menu.c_url 资源路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the value for upms_menu.c_url 资源路径
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return upms_menu.c_permission_value 资源权限码
     */
    public String getPermissionValue() {
        return permissionValue;
    }

    /**
     * @param permissionValue the value for upms_menu.c_permission_value 资源权限码
     */
    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue == null ? null : permissionValue.trim();
    }

    /**
     * @return upms_menu.c_orders 排序（1,2,3,4）
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * @param orders the value for upms_menu.c_orders 排序（1,2,3,4）
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * @return upms_menu.c_app_id 所属应用系统id
     */
    public Integer getAppId() {
        return appId;
    }

    /**
     * @param appId the value for upms_menu.c_app_id 所属应用系统id
     */
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
     * @return upms_menu.c_create_time 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for upms_menu.c_create_time 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return upms_menu.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the value for upms_menu.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return upms_menu.c_modified_time 系统修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime the value for upms_menu.c_modified_time 系统修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}