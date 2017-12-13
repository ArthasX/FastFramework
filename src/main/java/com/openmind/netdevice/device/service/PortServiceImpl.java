package com.openmind.netdevice.device.service;

import com.openmind.netdevice.device.dao.IPortMapper;
import com.openmind.netdevice.device.model.Port;
import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.service.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/9/4
 */
@Service
public class PortServiceImpl extends BaseServiceImp<Port,Identity> implements IPortService{

    @Autowired
    IPortMapper portMapper;
    @Override
    public List<Port> getPortWithDeviceId(Long deviceId) throws Throwable {
       return   portMapper.getPortWithDeviceId(deviceId);
    }
}
