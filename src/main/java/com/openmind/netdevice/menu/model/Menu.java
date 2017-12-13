package com.openmind.netdevice.menu.model;

import com.openmind.netdevice.department.model.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/9/7
 */
public abstract class Menu {
    private String id ;
    private String text;
    private boolean leaf;
    private List<? extends Menu> children;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<? extends Menu> getChildren() {
        return children;
    }

    public void setChildren(List<? extends Menu> children) {
        this.children = children;
    }
}
