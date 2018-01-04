package com.boco.learn.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boco.common.model.CommonResult;
import com.power.learn.model.Student;
import com.power.learn.service.StudentService;

/**
 * @author yu on 2017/12/29.
 */
public class StudentServiceTest extends ServiceBaseTest {

	@Resource
	private StudentService studentService;

	@Test
	public void testSave() {
		Student entity = new Student();
		CommonResult result = studentService.save(entity);
	}

	@Test
	public void testUpdate() {
		Student entity = new Student();
		CommonResult result = studentService.update(entity);
	}

	@Test
	public void testDelete() {
		CommonResult result = studentService.delete(1);
	}

	@Test
	public void testQueryById() {

	}

    /**
     * 分页查询
     *
     */
	@Test
	public void testQueryPage() {

	}

}