package com.duyu.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class TestMethod {
	//10 到 100 能被3 或5整除的数之和
	public static  void method1(){
		int sum=0;
		for(int i=10;i<=100;i++){
			if(i%3 ==0 || i%5==0){
				System.out.println(i);
				sum+=i;
			}
		}
		System.out.println(sum);
	}
	//反转字符串
	public static void method2(){
		String test="abcdefg";
		String temp="";
		for(int i=(test.length()-1);i>=0;i--){
			temp+=test.charAt(i);
		}
		System.out.println(temp);
	}
	//反转栈
	public static  void method3(){
		//栈是先进后出 队列是先进先出
		Stack stack =new Stack();
		stack.push(1);//bottom
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);//top
//		while (stack.size()>0){
//			System.out.println(stack.pop());
//		}
		
		Stack stack1=new Stack();
		 while(stack.size()>0)
			 stack1.push(stack.pop());
		
		while (stack1.size()>0){
			System.out.println(stack1.pop());
		}
//		Queue rev = new LinkedList();
//	    while(stack.size()>0) rev.offer(stack.pop());
//	    while(rev.size()>0)   stack.push(rev.poll());
	        
		
	}
	public static void main(String args[]){
//		TestMethod.method1();
//		TestMethod.method2();
		TestMethod.method3();
		
	}

}
