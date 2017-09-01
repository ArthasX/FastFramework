package com.openmind.netdevice.framework.model;

import com.openmind.netdevice.framework.sqlutil.Column;

/**
 * Created by LiuBin on 2017/6/23.
 */
public class Identity implements IBaseMode {
    @Column("pk")
    private long pk;

    public Identity() {

    }

    public Identity(long pk) {
        this.pk = pk;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }
}
