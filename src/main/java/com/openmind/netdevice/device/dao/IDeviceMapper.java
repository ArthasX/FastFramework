package com.openmind.netdevice.device.dao;

import com.openmind.netdevice.device.model.NetDevice;
import com.openmind.netdevice.framework.dao.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
@Repository
public interface IDeviceMapper extends IBaseMapper<NetDevice> {
    List<NetDevice> getDeviceWithPortByDeptId(@Param("deptId") String deptId);
}
