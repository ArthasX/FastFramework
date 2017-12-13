package com.openmind.netdevice.menu.service;

import com.openmind.netdevice.department.model.Department;
import com.openmind.netdevice.department.service.IDeptService;
import com.openmind.netdevice.menu.model.DeptTreeMenu;
import com.openmind.netdevice.menu.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/9/5
 */
@Service
public class MenuServiceImpl implements IMenuService{

    @Autowired
    private IDeptService deptService;
    @Override
    public Menu getDeptTreeMenu(String deptId) throws Throwable {
        Department department= new Department();
        department.setDeptId(deptId);
        List<Department> list = deptService.fuzzySelect(department);
        List<DeptTreeMenu> menu=new ArrayList<>();
        for(Department d : list){
            d.setfDeptId("9999");
            DeptTreeMenu deptTreeMenu = new DeptTreeMenu(d,true);
            menu.add(deptTreeMenu);
        }
        Department droot = new Department();
        droot.setDeptId("9999");
        droot.setName("分支机构");droot.setfDeptId("0");
        DeptTreeMenu root = new DeptTreeMenu(droot,false);
        root.setChildren(menu);
        return root;
    }
}
