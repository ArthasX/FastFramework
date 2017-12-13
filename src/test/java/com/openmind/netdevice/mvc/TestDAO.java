package com.openmind.netdevice.mvc;

import com.alibaba.fastjson.JSON;
import com.openmind.netdevice.authorization.dao.ILoginMapper;
import com.openmind.netdevice.authorization.model.User;
import com.openmind.netdevice.department.dao.IDeptMapper;
import com.openmind.netdevice.department.model.Department;
import com.openmind.netdevice.department.service.IDeptService;
import com.openmind.netdevice.device.dao.IDeviceMapper;
import com.openmind.netdevice.device.model.NetDevice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@Transactional
//@Rollback
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mybatis.xml"})
public class TestDAO extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private IDeptMapper deptMapper;
    @Autowired
    private IDeptService deptService;
    @Autowired
    private ILoginMapper loginMapper;
    @Autowired
    private IDeviceMapper deviceMapper;

    @Test
    public void testDept() {
        Department d = new Department();
        d.setId(1L);
        Department dd = deptMapper.select(d);
        System.out.println(JSON.toJSONString(dd));
        Assert.assertEquals("test device id ", "001001", dd.getDeptId());
    }

    @Test
    public void testUser() throws Throwable {
        User d = new User();
        d.setId(1L);
        User dd = loginMapper.select(d);
        System.out.println(JSON.toJSONString(dd));
        Assert.assertEquals("test user account", "abc", dd.getAccount());
    }

    @Test
    public void testDevice()  {
        String deptId = "001001";
        List<NetDevice> list = deviceMapper.getDeviceWithPortByDeptId("");

        System.out.println(JSON.toJSONString(list));
        Assert.assertEquals("ports num of the first device:",2,list.get(0).getPorts().size());
        Assert.assertEquals("test device num ",24,list.size());
    }

//    @Test
//    public void testDelete(){
//        Device d = new Device("abcdefg");
//        int c = deviceMapper.delete(d);
//        Assert.assertEquals(1, c);
//    }
//
//    @Test
//    public void testUpdate(){
//        Device d = new Device("abcdefg");
//        int c = deviceMapper.update(d);
//        Assert.assertEquals(1, c);
//    }
//
//
//    @Test
//    public void testInsertBatch(){
//        List<Device>list=new ArrayList<>();
//        Device d1 = new Device("dddd1");
//        Device d2 = new Device("dddd2");
//        Device d3 = new Device("dddd3");
//        list.add(d1);
//        list.add(d2);
//        list.add(d3);
//        int i=deviceMapper.insertBatch(list);
//        System.out.println("insert count:"+i);
//        Assert.assertEquals(i,3);
//    }
//
//    @Test
//    public void testDeviceWithPortAccount(){
//        List<Device>list=deviceMapper.getDeviceWithPortAccount("核心账务系统");
//        System.out.println("  count:"+list.size());
////        Assert.assertEquals(i,3);
//    }


}
