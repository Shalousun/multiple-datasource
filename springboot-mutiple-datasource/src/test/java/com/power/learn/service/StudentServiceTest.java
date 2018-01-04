package com.power.learn.service;

import javax.annotation.Resource;

import com.power.learn.model.Student;
import org.junit.Test;

import com.boco.common.model.CommonResult;

/**
 * @author yu on 2017/12/28.
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