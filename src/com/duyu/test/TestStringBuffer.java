package com.duyu.test;

public class TestStringBuffer {
	
	public void operate(StringBuffer x,StringBuffer y){
		x.append(y);
		y=x;
		System.out.println(y);
	}
	public static void main(String args[]){
		StringBuffer st1=new StringBuffer("A");
		StringBuffer st2=new StringBuffer("B");
		TestStringBuffer test=new TestStringBuffer();
		test.operate(st1, st2);
		System.out.println("st1"+st1);
		System.out.println("st2"+st2);
	}

}
