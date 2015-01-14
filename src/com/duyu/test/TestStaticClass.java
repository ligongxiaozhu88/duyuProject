package com.duyu.test;

public class TestStaticClass {
	private static String name1;
	private String name2;
	public void noStaticMethod(){
		name1="123";
		System.out.println(name1);
	}
	//静态方法中不能使用非静态成员变量
	public static void staticMethod(){
		System.out.println(name1);
		String name3="456";
//		System.out.println(name2);
		System.out.println(name3);
	}
	public static void main(String args[]){
		TestStaticClass testStaticClass =new TestStaticClass();
		testStaticClass.noStaticMethod();
		TestStaticClass.staticMethod();
		
	}

}
