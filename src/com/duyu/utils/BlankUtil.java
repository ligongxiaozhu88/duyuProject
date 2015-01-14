package com.duyu.utils;

import java.util.Collection;
import java.util.Map;

public class BlankUtil {
	private BlankUtil(){
		
	}
	public static boolean isBlank(String str){
		return (str==null)||(str.trim().length()==0);
	}
	public static boolean isBlank(Object[] data){
		return (data==null)||(data.length==0);
	}
	public static boolean isBlank(Number data){
		return (data==null);
	}
	public static boolean isBlank(double[] data){
		return (data==null)||(data.length==0);
	}
	public static boolean isBlank(float[] data){
		return (data==null)||(data.length==0);
	}
	public static boolean isBlank(boolean[] data){
		return (data==null)||(data.length==0);
	}
	public static boolean isBlank(int[] data){
		return (data==null)||(data.length==0);
	}
	public static boolean isBlank(byte[] data){
		return (data==null)||(data.length==0);
	}
	public static boolean isBlank(short[] data){
		return (data==null)||(data.length==0);
	}
	public static boolean isBlank(long[] data){
		return (data==null)||(data.length==0);
	}
	public static boolean isBlank(char[] data){
		return (data==null)||(data.length==0);
	}
	public static boolean isBlank(Collection<?> collection){
		return (collection==null)||(collection.size()==0);
	}
	public static boolean isBlank(Map<?,?> map){
		return (map==null)||(map.size()==0);
	}


}
