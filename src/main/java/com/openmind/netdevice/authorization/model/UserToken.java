package com.openmind.netdevice.authorization.model;

import com.openmind.netdevice.authorization.model.User;
import com.openmind.netdevice.framework.model.Menu;

/**
 * @author LiuBin
 * @version Created on 2017/9/1
 */
public class UserToken {
    private User user;
    private Menu menu;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
