package com.power.learn.service;


import com.github.pagehelper.PageInfo;
import com.boco.common.model.CommonResult;
import com.power.learn.model.Student;

/**
 *
 * @author yu on 2017/12/29.
 */
public interface StudentService {

	/**
	 * 保存数据
	 * @param entity
	 * @return
     */
	CommonResult save(Student entity);

	/**
	 * 修改数据
	 * @param entity
	 * @return
     */
	CommonResult update(Student entity);

	/**
	 * 删除数据
	 * @param id
	 * @return
     */
	CommonResult delete(int id);

	/**
	 * 根据id查询数据
	 * @param id
	 * @return
     */
	CommonResult queryById(int id);

	/**
     * 分页查询
     * @param offset 偏移量
     * @param limit 每页大小
     * @return
     */
    PageInfo queryPage(int offset, int limit);
}