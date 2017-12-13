package com.openmind.netdevice.framework.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.openmind.netdevice.framework.sqlutil.Column;
import com.openmind.netdevice.framework.util.CustomIdSerializer;

/**
 * Created by LiuBin on 2017/6/23.
 */
public class Identity  implements IBaseMode {
    @Column("id")
    private Long id;

    public Identity() {
    }

    public Identity(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomIdSerializer.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
