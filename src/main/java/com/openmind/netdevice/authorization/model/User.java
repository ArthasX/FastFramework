package com.openmind.netdevice.authorization.model;

import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.sqlutil.Column;
import com.openmind.netdevice.framework.sqlutil.Table;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
@Table("USER")
public class User extends Identity {
    @Column("account")
    private String account;
    @Column("password")
    private String password;
    @Column("deptId")
    private String deptId;
    @Column("userName")
    private String userName;


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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
