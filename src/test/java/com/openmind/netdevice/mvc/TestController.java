package com.openmind.netdevice.mvc;

//import com.openmind.netdevice.socket.xml.model.devices.SPort;
import org.junit.Before;
        import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

        import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
        import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

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




//    @Test
//    public void testSubmitNormalWorkNote() throws Exception {
//        String url = "/worknote/normal";
//        WorkNote workNote = new WorkNote();
//        workNote.setWorkNoteNumber("S201707010444");
//        workNote.setOperator("001064,001455");
//        workNote.setReason("fuck");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'D'HH:mm:ss'T'");
//        workNote.setStartTime(sdf.format(new Date()));
//        workNote.setEndTime("2018-01-01D00:00:00T");
//        List<String> groupNames = new ArrayList<>();
//        groupNames.add("核心账务系统");
//        groupNames.add("电子账户系统");
//        JSONObject jjj = new JSONObject();
//        jjj.put("groupname", groupNames);
//        jjj.put("workNote", workNote);
//        mockMvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(jjj.toJSONString())
////                .content(groupId)
//                .accept(MediaType.APPLICATION_JSON))
//                //.andExpect(status().isOk())
//                .andDo(print());
//    }


}
