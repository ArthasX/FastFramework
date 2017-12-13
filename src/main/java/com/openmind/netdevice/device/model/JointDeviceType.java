package com.openmind.netdevice.device.model;

import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.sqlutil.Column;
import com.openmind.netdevice.framework.sqlutil.Table;

/**
 * @author LiuBin
 * @version Created on 2017/9/4
 */
@Table("JOINTDEVICETYPE")
public class JointDeviceType extends Identity {
    @Column("typename")
    private String typename;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
