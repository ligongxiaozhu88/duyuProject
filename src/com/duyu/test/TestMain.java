package com.duyu.test;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String args[]){
		//list 如果没有指定类型  是即可放猫 也可放狗  遍历时要注意类型的使用 
		//泛型的作用那就是可以指定list的对象类型，只能放猫或者放狗
		List list =new ArrayList();
		Integer iO =new Integer(1);
		String testString ="wo shi test";
		list.add(testString);
		list.add(iO);
		for(Object object :list){
			System.out.println(object.toString());
		}
	}
}
