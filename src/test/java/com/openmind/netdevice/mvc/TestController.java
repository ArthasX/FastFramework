package com.openmind.netdevice.mvc;

//import com.openmind.netdevice.socket.xml.model.devices.SPort;

import com.alibaba.fastjson.JSONObject;
import com.openmind.netdevice.device.model.NetDevice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by LiuBin on 2017/6/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mybatis.xml"})
public class TestController {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void before() {
        this.mockMvc = webAppContextSetup(wac).build();
    }


    @Test
    public void testUpdateDevice() throws Exception {
        String url = "/devices/601216126596153344";
        NetDevice netDevice = new NetDevice();
        netDevice.setId(601216126596153344L);
        netDevice.setAddress("9.9.9.9");
        String jjj = JSONObject.toJSONString(netDevice);
        mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jjj)
//                .content(groupId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testMenu() throws Exception {
        String url = "/menus/";
        mockMvc.perform(get(url)
        )
                .andExpect(status().isOk())
                .andDo(print());

    }


}
