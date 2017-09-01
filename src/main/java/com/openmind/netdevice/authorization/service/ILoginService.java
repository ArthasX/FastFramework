package com.openmind.netdevice.authorization.service;

import com.openmind.netdevice.authorization.model.User;
import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.service.IBaseService;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
public interface ILoginService extends IBaseService<User,Identity>{
    boolean login(String account,String password) ;
}
