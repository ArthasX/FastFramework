package com.openmind.netdevice.device.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.sqlutil.Column;
import com.openmind.netdevice.framework.sqlutil.Table;
import com.openmind.netdevice.framework.util.CustomIdSerializer;

/**
 * @author LiuBin
 * @version Created on 2017/9/4
 */
@Table("PORT")
public class Port extends Identity {

    @Column("netDeviceId")
//    @JsonSerialize(using = CustomIdSerializer.class)
    private String netDeviceId;
    @Column("portNum")
    private Integer portNum;//端口序号1-24 48...
    @Column("address")
    private String address;
    @Column("jointDeviceType")
    private Long jointDeviceType;
    @Column("optDate")
    private String optDate;
    @Column("optUser")
    private String optUser;
    @Column("portstatus")
    private String portstatus;
    @Column("mac")
    private String mac;

    public Port() {
    }


    public Port(String netDeviceId, Integer portNum, String address, Long jointDeviceType, String optDate, String optUser, String portstatus, String mac) {
        this.netDeviceId = netDeviceId;
        this.portNum = portNum;
        this.address = address;
        this.jointDeviceType = jointDeviceType;
        this.optDate = optDate;
        this.optUser = optUser;
        this.portstatus = portstatus;
        this.mac = mac;
    }

    public Port(Long id, String netDeviceId, Integer portNum, String address, Long jointDeviceType, String optDate, String optUser, String portstatus, String mac) {
        super(id);
        this.netDeviceId = netDeviceId;
        this.portNum = portNum;
        this.address = address;
        this.jointDeviceType = jointDeviceType;
        this.optDate = optDate;
        this.optUser = optUser;
        this.portstatus = portstatus;
        this.mac = mac;
    }

    public String getNetDeviceId() {
        return netDeviceId;
    }

    public void setNetDeviceId(String netDeviceId) {
        this.netDeviceId = netDeviceId;
    }

    public Integer getPortNum() {
        return portNum;
    }

    public void setPortNum(Integer portNum) {
        this.portNum = portNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getJointDeviceType() {
        return jointDeviceType;
    }

    public void setJointDeviceType(Long jointDeviceType) {
        this.jointDeviceType = jointDeviceType;
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

    public String getPortstatus() {
        return portstatus;
    }

    public void setPortstatus(String portstatus) {
        this.portstatus = portstatus;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
