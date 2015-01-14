package com.duyu.test.testAnnotation;

public class TestBean {
	@TestAnnotation(name="姓名" ,description="1") 
	public String name;
	@TestAnnotation(name="年龄",description="1") 
	public int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
