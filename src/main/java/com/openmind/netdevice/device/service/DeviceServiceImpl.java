package com.openmind.netdevice.device.service;

import com.openmind.netdevice.device.dao.IDeviceMapper;
import com.openmind.netdevice.device.model.Device;
import com.openmind.netdevice.device.model.NetDevice;
import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.service.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
@Service
public class DeviceServiceImpl extends BaseServiceImp<NetDevice, Identity> implements IDeviceService {

    @Autowired
    IDeviceMapper deviceMapper;
    @Override
    public List<NetDevice> getDeviceWithPortByDeptId(String deptId) throws Throwable {
        return deviceMapper.getDeviceWithPortByDeptId(deptId);
    }
}
