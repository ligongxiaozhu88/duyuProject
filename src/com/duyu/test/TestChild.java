package com.duyu.test;


public class TestChild  {
//	public TestChild(String str){
//		System.out.println("child");
//	}
	
	public String method(String args){
		return args;
	}
	public static void main(String args[]){
		TestChild child=new TestChild();
		String test=child.method("123");
		int arr[]={1,2,3};
		
		for(int i=0 ;i<arr.length;i++){
			System.out.println(arr[i]);
		}
//		System.out.println(child.toString());
//		System.out.println(dataArr.length);
	}
	
	
	
}
