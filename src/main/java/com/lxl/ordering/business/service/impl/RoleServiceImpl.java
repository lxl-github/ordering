package com.lxl.ordering.business.service.impl;

import com.lxl.ordering.business.dao.ApplicationMapper;
import com.lxl.ordering.business.dao.RoleMapper;
import com.lxl.ordering.business.dao.RoleMenuMapper;
import com.lxl.ordering.business.dao.UserRoleMapper;
import com.lxl.ordering.business.domain.*;
import com.lxl.ordering.business.service.RoleService;
import com.lxl.ordering.frame.base.BusinessException;
import com.lxl.ordering.frame.utils.BuildTree;
import com.lxl.ordering.frame.utils.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * <p>功能描述信息</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lixiaoliang
 * @version 1.0
 * @date 2017/9/30
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> getRoleAll(Query query) {
        return roleMapper.selectAllList(query);
    }

    @Override
    public int getRoleAllCount(Query query) {
        return roleMapper.selectAllCount(query);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveRole(Role role) {
        int count = roleMapper.insertSelective(role);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateRole(Role role) {
        int count = roleMapper.updateByPrimaryKeySelective(role);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteRole(Integer id) {
        int count = roleMapper.deleteById(id);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean batchDeleteRole(List<Integer> roleIds) {
        return null;
    }

    @Override
    public Role getRoleByRoleId(Integer roleId) {
        return roleMapper.selectRoleById(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveRoleMenu(List<RoleMenu> roleMenuList) {
        int count = 0;
        for (RoleMenu roleMenu : roleMenuList) {
             int cnt = roleMenuMapper.insertSelective(roleMenu);
             count += cnt;
        }
        if (count != roleMenuList.size()) {
            throw new BusinessException("保存失败");
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteRoleMenu(Integer roleId, Integer appId) {
        int count = roleMenuMapper.deleteRoleMenu(appId, roleId);
        if (count > 0) return true;
        return false;
    }

    @Override
    public Tree<RoleTree> getRoleTree() {
        List<Tree<RoleTree>> treeList = new LinkedList<Tree<RoleTree>>();

        List<Application> applicationList = applicationMapper.selectApplicationEnableList();

        for (Application application : applicationList) {
            Tree<RoleTree> roleTree = new Tree<RoleTree>();
            roleTree.setId(application.getId().toString());
            roleTree.setText(application.getTitle());
            roleTree.setParentId("0");
            List<Role> roleList = roleMapper.selectRoleListByAppId(application.getId());
            List<Tree<RoleTree>> childRoleTreeList = new LinkedList<Tree<RoleTree>>();
            for (Role role : roleList) {
                Tree<RoleTree> childRoleTree = new Tree<RoleTree>();
                childRoleTree.setId(role.getId().toString());
                childRoleTree.setText(role.getTitle());
                childRoleTree.setParentId(application.getId().toString());
                childRoleTree.setHasParent(true);
                childRoleTreeList.add(childRoleTree);
            }
            if (!CollectionUtils.isEmpty(childRoleTreeList)) {
                roleTree.setChildren(childRoleTreeList);
                roleTree.setChildren(true);
            }
            treeList.add(roleTree);
        }

        return BuildTree.buildRoleTree(treeList,"角色授权");

    }

    @Override
    public Map<String, List<RoleCheckBox>> getAppToRoleMap(Integer userId) {

        Map<String, List<RoleCheckBox>> resultMap = new LinkedHashMap<String, List<RoleCheckBox>>();

        List<Application> applicationList = applicationMapper.selectApplicationEnableList();

        List<Integer> userRoleList = userRoleMapper.selectRoleIdByUserId(userId);

        for (Application application : applicationList) {

            List<Role> roleList = roleMapper.selectRoleListByAppId(application.getId());

            List<RoleCheckBox> roleCheckBoxList = new ArrayList<RoleCheckBox>();

            for (Role role : roleList) {
                RoleCheckBox roleCheckBox = new RoleCheckBox();
                BeanUtils.copyProperties(role, roleCheckBox);
                if (userRoleList.contains(role.getId())) {
                    roleCheckBox.setChecked(true);
                } else {
                    roleCheckBox.setChecked(false);
                }
                roleCheckBoxList.add(roleCheckBox);
            }

            resultMap.put(application.getTitle(), roleCheckBoxList);
        }

        return resultMap;
    }

    @Override
    public List<Role> getRoloListByRoleIds(List<Integer> roleIdList) {
        return roleMapper.selectRoleListByRoleIdList(roleIdList);
    }

    @Override
    public List<Role> getRoleAllByUserNumberAndAppKey(String userNumber, String appKey) {
        return roleMapper.selectRoleAllByUserNumberAndAppKey(userNumber, appKey);
    }


}
