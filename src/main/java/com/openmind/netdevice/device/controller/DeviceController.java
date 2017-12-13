package com.openmind.netdevice.device.controller;

import com.openmind.netdevice.device.model.JointDeviceType;
import com.openmind.netdevice.device.model.NetDevice;
import com.openmind.netdevice.device.model.Port;
import com.openmind.netdevice.device.service.IDeviceService;
import com.openmind.netdevice.device.service.IJointDeviceTypeService;
import com.openmind.netdevice.device.service.IPortService;
import com.openmind.netdevice.framework.controller.BaseController;
import com.openmind.netdevice.framework.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
@RequestMapping(value = "/devices")
@RestController
public class DeviceController extends BaseController<IDeviceService, NetDevice> {
    static Logger logger = Logger.getLogger(DeviceController.class);
    @Autowired
    IPortService portService;
    @Autowired
    IJointDeviceTypeService jointDeviceTypeService;

    @RequestMapping(value = "/{id}/ports/",method = RequestMethod.GET)
    @ResponseBody
    public Result getPortByDeviceId(@PathVariable("id") String id) {
        Result result;
        try {
            Port port = new Port();
            port.setNetDeviceId(id);
            result = new Result();
            result.setData(portService.fuzzySelect(port));
        } catch (Throwable throwable) {
            logger.error("获取设备id为:" + id + "的端口失败", throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
    }

    @RequestMapping(value = "/dept/{deptId}",method = RequestMethod.GET)
    @ResponseBody
    public Result getDevicesWithPortByDeptId(@PathVariable("deptId")String deptId){
        Result result;
        try{
            result=new Result();
            result.setData(service.getDeviceWithPortByDeptId(deptId));
        }catch (Throwable throwable){
            logger.error("获取机构id为:" + deptId + "的设备失败", throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public Result getAll(){
        Result result;
        try{
            result=new Result();
            result.setData(service.getDeviceWithPortByDeptId(""));
        }catch (Throwable throwable){
            logger.error("获取全部:" + "的设备失败", throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
    }


    @RequestMapping(value = "/jointDeviceType",method = RequestMethod.GET)
    @ResponseBody
    public Result getJointDeviceType(){
        Result result;
        try{
            result=new Result();
            result.setData(jointDeviceTypeService.fuzzySelect(new JointDeviceType()));
        }catch (Throwable throwable){
            logger.error("获取接入设备类型失败", throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
    }
}
