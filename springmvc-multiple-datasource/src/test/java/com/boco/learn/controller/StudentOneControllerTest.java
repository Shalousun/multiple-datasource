package com.boco.learn.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * controller restful接口单元测试
 * @author yu on 2017/12/29.
 *
 */
public class StudentOneControllerTest extends ControllerBaseTest {



	/**
	 * 测试controller add接口
	 * @throws Exception
     */
	@Test
	public void testAdd() throws Exception {
		MvcResult result = mockMvc.perform(get("/studentOne/add")
 			.contentType(MediaType.APPLICATION_JSON)
            .param("id","796")
            .param("name","1ptla3")
            .param("age","129")
            .param("address","xixoio")
 		).andExpect(status().isOk()).andDo(print()).andReturn();
		System.out.println("result:"+result.getResponse().getContentAsString());
	}

	/**
	 * 测试controller queryById接口
	 * @throws Exception
     */
	@Test
	public void testQueryById() throws Exception {
		MvcResult result = mockMvc.perform(get("/studentOne/query/{id}", 1)
 			.contentType(MediaType.APPLICATION_JSON)
 			.param("param1", "pm1")
 		).andExpect(status().isOk()).andDo(print()).andReturn();
		System.out.println("result:"+result.getResponse().getContentAsString());
	}

	/**
	 * 测试controller update接口
	 * @throws Exception
     */
	@Test
	public void testUpdate() throws Exception {
        MvcResult result = mockMvc.perform(post("/studentOne/update")
         	.contentType(MediaType.APPLICATION_JSON)
         	
            .param("id","796")
            .param("name","1ptla3")
            .param("age","129")
            .param("address","xixoio")
        ).andExpect(status().isOk()).andDo(print()).andReturn();
        System.out.println("result:"+result.getResponse().getContentAsString());
	}

	/**
	 * 测试controller delete接口
	 * @throws Exception
     */
	@Test
	public void testDelete() throws Exception {
		MvcResult result = mockMvc.perform(get("/studentOne/delete/{id}", 1)
 			.contentType(MediaType.APPLICATION_JSON)
 			.param("param1", "pm1")
 		).andExpect(status().isOk()).andDo(print()).andReturn();
		System.out.println("result:"+result.getResponse().getContentAsString());
	}

    /**
     * 测试controller queryPage分页接口
     * @throws Exception
     */
    @Test
    public void testPage() throws Exception {
        MvcResult result = mockMvc.perform(get("/studentOne/page/{offset}/{limit}",1,10)
            .contentType(MediaType.APPLICATION_JSON)
            .param("param1", "pm1")
        ).andExpect(status().isOk()).andDo(print()).andReturn();
        System.out.println("result:"+result.getResponse().getContentAsString());
    }
}
