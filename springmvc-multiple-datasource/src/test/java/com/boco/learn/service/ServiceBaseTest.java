package com.boco.learn.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * service层业务单元测试基础类
 * @author yu on 2017/12/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring-mybatis.xml"
})
public class ServiceBaseTest {

}
