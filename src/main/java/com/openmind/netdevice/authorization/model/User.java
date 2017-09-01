package com.openmind.netdevice.authorization.model;

import com.openmind.netdevice.framework.model.Identity;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
public class User extends Identity {
    private String account;
    private String password;

    public User(){

    }
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User(long pk, String account, String password) {
        super(pk);
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
