package com.openmind.netdevice.framework.service;

import com.openmind.netdevice.framework.dao.IBaseMapper;
import com.openmind.netdevice.framework.sqlutil.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/28.
 */

public class BaseServiceImp<Model extends Serializable, ID extends Serializable> implements IBaseService<Model, ID> {

    @Autowired
    IBaseMapper<Model> baseMapper;

    @Override
    public Model selectById(Class<Model> clz, ID id)throws Throwable {
        return null;
    }

    @Override
    public Model deleteById(Class<Model> clz, ID id)throws Throwable {
        return null;
    }

    @Override
    public Model select(Model model)throws Throwable {
        return baseMapper.select(model);
    }


    @Override
    public int delete(Model model)throws Throwable {
        return baseMapper.delete(model);
    }

    @Override
    public int update(Model model)throws Throwable {
        return baseMapper.update(model);
    }

    @Override
    public int insert(Model model)throws Throwable {
        return baseMapper.insert(model);
    }

    @Override
    public int insertBatch(List<Model> list)throws Throwable {
        return baseMapper.insertBatch(list);
    }

    @Override
    public List<Model> fuzzySelect(Model model)throws Throwable {
        return baseMapper.fuzzySelect(model);
    }

    @Override
    public Page<Model> pageSelect(Page<Model> page) throws Throwable{
        page.setList(baseMapper.fuzzySelect(page.getT()));
        return page;
    }

    @Override
    public int selectCount(Model model)throws Throwable {
        return baseMapper.count(model);
    }

    public IBaseMapper<Model> getBaseMapper()throws Throwable {
        return baseMapper;
    }

    public void setBaseMapper(IBaseMapper<Model> baseMapper)throws Throwable {
        this.baseMapper = baseMapper;
    }
}
