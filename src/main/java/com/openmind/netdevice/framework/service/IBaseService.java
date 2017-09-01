package com.openmind.netdevice.framework.service;

import com.openmind.netdevice.framework.sqlutil.Page;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/27.
 */
@Service("baseService")
public interface IBaseService<Model extends Serializable, ID extends Serializable> {
    //TODO use map to add more parameter
    Model selectById(Class<Model> clz, ID id)throws Throwable;

    Model deleteById(Class<Model> clz, ID id)throws Throwable;

    Model select(Model model)throws Throwable;

    int delete(Model model)throws Throwable;

    int update(Model model)throws Throwable;

    int insert(Model model)throws Throwable;

    int insertBatch(List<Model> list)throws Throwable;

    List<Model> fuzzySelect(Model model)throws Throwable;

    Page<Model> pageSelect(Page<Model> t)throws Throwable;

    int selectCount(Model model)throws Throwable;
}
