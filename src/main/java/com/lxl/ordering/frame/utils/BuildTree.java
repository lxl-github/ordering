package com.lxl.ordering.frame.utils;


import com.lxl.ordering.business.domain.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建树形权限
 */
public class BuildTree {

    public static <T> Tree<T> build(List<Tree<T>> nodes, String appTitle) {

        if (nodes == null) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<Tree<T>>();

        for (Tree<T> children : nodes) {

            //如果父级id=0或者null则为顶级菜单
            String pid = children.getParentId();
            if (pid == null || "0".equals(pid)) {
                topNodes.add(children);
                continue;
            }

            createChildrenNodes(nodes, children, pid);

        }

        Tree<T> root = new Tree<T>();
        root.setId("-1");
        root.setParentId("");
        root.setHasParent(false);
        root.setChildren(true);
        root.setChecked(true);
        root.setChildren(topNodes);
        root.setText(appTitle);

        return root;
    }

    private static <T> void createChildrenNodes(List<Tree<T>> nodes, Tree<T> children, String pid) {
        //循环子级菜单或按钮
        for (Tree<T> parent : nodes) {
            String id = parent.getId();
            if (id != null && id.equals(pid)) {
                parent.getChildren().add(children);
                children.setHasParent(true);
                parent.setChildren(true);
            }
        }
    }

    public static <T> List<Tree<T>> buildList(List<Tree<T>> nodes, String idParam) {
        if (nodes == null) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<Tree<T>>();

        for (Tree<T> children : nodes) {

            String pid = children.getParentId();
            if (pid == null || idParam.equals(pid)) {
                topNodes.add(children);
                continue;
            }

            createChildrenNodes(nodes, children, pid);

        }
        return topNodes;
    }

    public static <T> Tree<T> buildRoleTree(List<Tree<T>> nodes, String appTitle) {

        Tree<T> root = new Tree<T>();
        root.setId("-1");
        root.setParentId("");
        root.setHasParent(false);
        root.setChildren(true);
//        root.setChecked(true);
        root.setChildren(nodes);
        root.setText(appTitle);

        return root;
    }

}