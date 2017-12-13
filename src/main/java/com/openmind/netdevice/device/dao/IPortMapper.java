package com.openmind.netdevice.device.dao;

import com.openmind.netdevice.device.model.Port;
import com.openmind.netdevice.framework.dao.IBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/9/7
 */
@Repository
public interface IPortMapper extends IBaseMapper<Port> {
    List<Port> getPortWithDeviceId(Long deviceId);
}
