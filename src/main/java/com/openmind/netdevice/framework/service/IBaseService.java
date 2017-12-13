package com.openmind.netdevice.framework.service;

import com.openmind.netdevice.framework.model.IBaseMode;
import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.sqlutil.Page;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/27.
 */
@Service("baseService")
public interface IBaseService<T extends Serializable, ID extends Identity > {
    //TODO use map to add more parameter
    T selectById(Class<T> clz, ID id)throws Throwable;

    T deleteById(Class<T> clz, ID id)throws Throwable;

    T select(T t)throws Throwable;

    int delete(T t)throws Throwable;

    int update(T t)throws Throwable;

    int insert(T t)throws Throwable;

    int insertBatch(List<T> list)throws Throwable;

    List<T> fuzzySelect(T t)throws Throwable;

    Page<T> pageSelect(Page<T> t)throws Throwable;

    int selectCount(T t)throws Throwable;
}
