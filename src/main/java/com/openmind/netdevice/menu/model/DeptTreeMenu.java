package com.openmind.netdevice.menu.model;

import com.openmind.netdevice.department.model.Department;

/**
 * @author LiuBin
 * @version Created on 2017/9/5
 */
public class DeptTreeMenu extends Menu {

    public DeptTreeMenu() {
    }

    public DeptTreeMenu(Department department,boolean leaf) {
        super.setId(department.getDeptId());
        super.setText(department.getName());
//        if (department.getfDeptId() == null || department.getfDeptId() == "")
//            super.setLeaf(false);
//        else
//            super.setLeaf(true);
        super.setLeaf(leaf);
    }

}
