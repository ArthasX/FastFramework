package com.openmind.netdevice.framework.controller;

import com.alibaba.fastjson.JSONObject;
import com.openmind.netdevice.framework.model.Result;

/**
 * Created by LiuBin on 2017/6/22.
 */

public interface IBaseController {
    Result getAll();

    Result getById(Long id);

    Result update(long id, JSONObject object);

    Result insert(JSONObject object);
}
