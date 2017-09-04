package com.openmind.netdevice.device.model;

import com.openmind.netdevice.framework.sqlutil.Column;
import com.openmind.netdevice.framework.sqlutil.Table;

/**
 * @author LiuBin
 * @version Created on 2017/8/30
 */
@Table("DEVICE")
public class NetDevice extends Device {
    @Column("type")
    private String type;
    @Column("name")
    private String name;
    @Column("address")
    private String address;
    @Column("deptId")
    private String deptId;
    @Column("brand")
    private String brand;
    @Column("portNum")
    private int portNum;
    @Column("joinDate")
    private String joinDate;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPortNum() {
        return portNum;
    }

    public void setPortNum(int portNum) {
        this.portNum = portNum;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}