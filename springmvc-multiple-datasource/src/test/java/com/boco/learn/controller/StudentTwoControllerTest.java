package com.boco.learn.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StudentTwoControllerTest extends ControllerBaseTest {

    /**
     * 测试controller add接口
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        MvcResult result = mockMvc.perform(get("/studentTwo/add")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id","796")
                .param("name","1ptla3")
                .param("age","129")
                .param("address","xixoio")
        ).andExpect(status().isOk()).andDo(print()).andReturn();
        System.out.println("result:"+result.getResponse().getContentAsString());
    }
}
