package com.openmind.netdevice.authorization.service;

import com.openmind.netdevice.authorization.model.User;
import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.service.BaseServiceImp;
import org.springframework.stereotype.Service;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
@Service
public class LoginServiceImpl extends BaseServiceImp<User, Identity> implements ILoginService {

    @Override
    public boolean login(String account, String password) {
        User user = new User(account, password);
        try {
            if (select(user) != null)
                return true;
            else
                return false;
        } catch (Throwable throwable) {
            return false;
        }

    }
}
