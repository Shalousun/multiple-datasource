package com.power.learn.dao;

import com.power.learn.constants.DataSourceKey;

import com.power.learn.model.Student;
import com.power.datasource.annotations.TargetDataSource;

import java.util.List;
import java.util.Map;

/**
 * Created by ApplicationPower.
 * @author yu on 2017年12月23日 星期六  22:01:41.
 */
@TargetDataSource(DataSourceKey.ONE)
public interface StudentOneDao {

	/**
	 * 保存数据
	 * @param entity
	 * @return
     */
	int save(Student entity);

    /**
     * 批量添加数据
     * @param entityList
     * @return
     */
	int batchSave(List<Student> entityList);

	/**
	 * 更新数据
	 * @param entity
	 * @return
     */
	int update(Student entity);

	/**
	 * 删除数据
	 * @param id
	 * @return
     */
	int delete(int id);

	/**
	 * 根据id查询数据
	 * @param id
	 * @return
     */
	Student queryById(int id);

	/**
	 * 分页查询数据
	 * @return
     */
	List<Student> queryPage();

    /**
     * query result to list of map
     * @param params Map查询参数
     * @return
     */
    List<Map<String,Object>> queryToListMap(Map<String, Object> params);
}