package com.openmind.netdevice.authorization.model;

import com.openmind.netdevice.menu.model.Menu;

/**
 * @author LiuBin
 * @version Created on 2017/9/1
 */
public class UserToken {
    private User user;
    private Menu menu;
    private String forward;

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

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }
}
