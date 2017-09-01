package com.openmind.netdevice.authorization.dao;

import com.openmind.netdevice.authorization.model.User;
import com.openmind.netdevice.framework.dao.IBaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
@Repository
public interface ILoginMapper extends IBaseMapper<User> {
}
