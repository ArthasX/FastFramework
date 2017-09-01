package com.openmind.netdevice.framework.model;

import com.openmind.netdevice.framework.sqlutil.Column;
import com.openmind.netdevice.framework.sqlutil.Table;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
@Table("DEPARTMENT")
public class Department extends Identity {
    @Column("deptId")
    private String deptId;
    @Column("name")
    private String name;


    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
