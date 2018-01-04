package com.power.learn.service;

import com.boco.common.util.RandomUtil;
import com.power.learn.model.Student;
import org.junit.Test;

import javax.annotation.Resource;

public class StudentOneServiceTest extends ServiceBaseTest {

    @Resource
    private StudentService studentOneService;

    @Test
    public void testAdd(){
        Student entity = new Student();
        entity.setName(RandomUtil.randomString(6));
        entity.setAddress(RandomUtil.randomString(8));
        entity.setAge(RandomUtil.randomInt(100));

        studentOneService.save(entity);

    }
}
