package com.openmind.netdevice.department.model;

import com.openmind.netdevice.framework.model.Identity;
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
    @Column("fDeptId")
    private String fDeptId;
    @Column("level")
    private Integer level;

    public Department() {
    }

    public Department(Long pk) {
        super(pk);
    }

    public Department(String deptId, String name, String fDeptId, Integer level, Long pk) {
        super(pk);
        this.deptId = deptId;
        this.name = name;
        this.fDeptId = fDeptId;
        this.level = level;
    }

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

    public String getfDeptId() {
        return fDeptId;
    }

    public void setfDeptId(String fDeptId) {
        this.fDeptId = fDeptId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
