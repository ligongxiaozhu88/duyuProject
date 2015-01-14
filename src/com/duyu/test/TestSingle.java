package com.duyu.test;

public class TestSingle {
	private  static TestSingle testSingle=null;
	
	private TestSingle(){
		
	}
	public static TestSingle getSingle(){
		if(testSingle==null){
			testSingle=new TestSingle();
		}
		return testSingle;
	}

}
