package com.openmind.netdevice.menu.service;

import com.openmind.netdevice.menu.model.DeptTreeMenu;
import com.openmind.netdevice.menu.model.Menu;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/9/5
 */
public interface IMenuService {
    Menu getDeptTreeMenu(String deptId)throws Throwable;
}
