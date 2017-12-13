package com.openmind.netdevice.device.model;

import com.openmind.netdevice.framework.sqlutil.Column;
import com.openmind.netdevice.framework.sqlutil.Table;

import java.util.ArrayList;

/**
 * @author LiuBin
 * @version Created on 2017/8/30
 */
@Table(value = "NETDEVICE",keyAutoIncrese = true)
public class NetDevice extends Device {
    //    @Column("ports")
//    private String ports;
    @Column("deviceid")
    private  String deviceid;
    @Column("deviceType")
    private String deviceType;
    @Column("name")
    private String name;
    @Column("address")
    private String address;
    @Column("deptId")
    private String deptId;
    @Column("brand")
    private String brand;
    @Column("portCount")
    private Integer portCount;
    @Column("joinDate")
    private String joinDate;
    @Column("optDate")
    private String optDate;
    @Column("optUser")
    private String optUser;


    private ArrayList<Port> ports;

    public NetDevice() {
    }

    public NetDevice(String deviceid, String deviceType, String name, String address, String deptId, String brand, Integer portCount, String joinDate, String optDate, String optUser, ArrayList<Port> ports) {
        this.deviceid = deviceid;
        this.deviceType = deviceType;
        this.name = name;
        this.address = address;
        this.deptId = deptId;
        this.brand = brand;
        this.portCount = portCount;
        this.joinDate = joinDate;
        this.optDate = optDate;
        this.optUser = optUser;
        this.ports = ports;
    }

    public NetDevice(Long pk, String deviceid, String deviceType, String name, String address, String deptId, String brand, Integer portCount, String joinDate, String optDate, String optUser, ArrayList<Port> ports) {
        super(pk);
        this.deviceid = deviceid;
        this.deviceType = deviceType;
        this.name = name;
        this.address = address;
        this.deptId = deptId;
        this.brand = brand;
        this.portCount = portCount;
        this.joinDate = joinDate;
        this.optDate = optDate;
        this.optUser = optUser;
        this.ports = ports;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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

    public Integer getPortCount() {
        return portCount;
    }

    public void setPortCount(Integer portCount) {
        this.portCount = portCount;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public ArrayList<Port> getPorts() {
        return ports;
    }

    public void setPorts(ArrayList<Port> ports) {
        this.ports = ports;
    }

    public String getOptDate() {
        return optDate;
    }

    public void setOptDate(String optDate) {
        this.optDate = optDate;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }
}