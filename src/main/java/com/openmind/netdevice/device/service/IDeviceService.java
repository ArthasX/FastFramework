package com.openmind.netdevice.device.service;

import com.openmind.netdevice.device.model.NetDevice;
import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.service.IBaseService;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
public interface IDeviceService extends IBaseService<NetDevice,Identity>{
    List<NetDevice> getDeviceWithPortByDeptId(String deptId) throws Throwable;
}
