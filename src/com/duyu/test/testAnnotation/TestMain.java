package com.duyu.test.testAnnotation;

import java.lang.reflect.Field;

public class TestMain {
	public static void main(String args[]){
		TestBean testBean =new TestBean();
		Field[]  fieldArr =testBean.getClass().getDeclaredFields();
		for(Field field:fieldArr){
			if(field.getAnnotation(TestAnnotation.class)!=null){
				String test =field.getAnnotation(TestAnnotation.class).name();
				String test1 =field.getAnnotation(TestAnnotation.class).description();
				System.out.println(test);
				System.out.println(test1);
			}
		}
	}

}
