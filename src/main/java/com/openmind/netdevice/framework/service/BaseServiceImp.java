package com.openmind.netdevice.framework.service;


import com.openmind.netdevice.framework.dao.IBaseMapper;
import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.sqlutil.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/28.
 */

public class BaseServiceImp<T extends Serializable, ID extends Identity > implements IBaseService<T, ID> {

    @Autowired
    IBaseMapper<T> baseMapper;

    @Override
    public T selectById(Class<T> clz, ID id)throws Throwable {
        return null;
    }

    @Override
    public T deleteById(Class<T> clz, ID id)throws Throwable {
        return null;
    }

    @Override
    public T select(T t)throws Throwable {
        return baseMapper.select(t);
    }


    @Override
    public int delete(T t)throws Throwable {
        return baseMapper.delete(t);
    }

    @Override
    public int update(T t)throws Throwable {
        return baseMapper.update(t);
    }

    @Override
    public int insert(T t)throws Throwable {
        return baseMapper.insert(t);
    }

    @Override
    public int insertBatch(List<T> list)throws Throwable {
        return baseMapper.insertBatch(list);
    }

    @Override
    public List<T> fuzzySelect(T t)throws Throwable {
        return baseMapper.fuzzySelect(t);
    }

    @Override
    public Page<T> pageSelect(Page<T> t) throws Throwable {
        return null;
    }


    @Override
    public int selectCount(T t)throws Throwable {
        return baseMapper.count(t);
    }

    public IBaseMapper<T> getBaseMapper()throws Throwable {
        return baseMapper;
    }

    public void setBaseMapper(IBaseMapper<T> baseMapper)throws Throwable {
        this.baseMapper = baseMapper;
    }
}
