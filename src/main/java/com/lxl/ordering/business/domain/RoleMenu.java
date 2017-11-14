package com.lxl.ordering.business.domain;

import java.io.Serializable;
import java.util.Date;

public class RoleMenu implements Serializable {
    /**
     * upms_role_menu.c_id 
     */
    private Integer id;

    /**
     * upms_role_menu.c_role_id 角色id
     */
    private Integer roleId;

    /**
     * upms_role_menu.c_menu_id 资源id
     */
    private Integer menuId;

    /**
     * upms_role_menu.c_app_id 所属应用系统id
     */
    private Integer appId;

    /**
     * upms_role_menu.c_create_time 创建时间
     */
    private Integer createTime;

    /**
     * upms_role_menu.c_is_deleted 是否删除 0 未删除 1已删除
     */
    private Integer isDeleted;

    /**
     * upms_role_menu.c_modified_time 系统修改时间
     */
    private Date modifiedTime;

    /**
     * @return upms_role_menu.c_id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for upms_role_menu.c_id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return upms_role_menu.c_role_id 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the value for upms_role_menu.c_role_id 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return upms_role_menu.c_menu_id 资源id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * @param menuId the value for upms_role_menu.c_menu_id 资源id
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    /**
     * @return upms_role_menu.c_create_time 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for upms_role_menu.c_create_time 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return upms_role_menu.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the value for upms_role_menu.c_is_deleted 是否删除 0 未删除 1已删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return upms_role_menu.c_modified_time 系统修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime the value for upms_role_menu.c_modified_time 系统修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}