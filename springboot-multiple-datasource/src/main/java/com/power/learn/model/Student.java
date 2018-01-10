package com.power.learn.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;



/**
 * Table:
 * @author yu on 2017/12/28.
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -5215112557642055763L;

   	private Integer id;
	private String name;
	private Integer age;
	private String address;

	/** getters and setters */
   	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


    @Override
    public String toString() {
        return "Student{" + 
                "id =" + id +
                ",name ='" + name + '\'' +
                ",age =" + age +
                ",address ='" + address + '\'' +
                '}';
    }
}