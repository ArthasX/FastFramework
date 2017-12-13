package com.openmind.netdevice.device.service;

import com.openmind.netdevice.device.model.Port;
import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.service.IBaseService;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/9/4
 */
public interface IPortService extends IBaseService<Port,Identity> {
    List<Port> getPortWithDeviceId(Long deviceId) throws Throwable;
}
