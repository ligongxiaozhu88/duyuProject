package com.duyu.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class CommonUtils {
	public static String getRandStr(int len) {
		String chars = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (len > 0) {
			Random random = new Random();
			char[] charArr = new char[len];
			for (int i = 0; i < len; i++) {
				charArr[i] = chars.charAt(random.nextInt(62)); //0-61  不包括62
			}
			return String.valueOf(charArr);// 取的是charArr的内容
			// charArr.toString() charArr 的内容是对象的引用也就是对象的在堆中的地址 所以此句代码 打出形式 如
			// [C@61de33
		} else {
			return "";
		}
	}

	// 转码
	public static String convertEncode(String string)
			throws UnsupportedEncodingException {
		String str = new String(string.getBytes("ISO-8859-1"), "utf-8");
		return str;
	}
	public void geConn() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.dirver.OracleDriver");
		String url = "jdbc.oracle.thin@localhost:1251:icss";

	}

	// 冒泡排序
	public static void getBubble(int[] arr) {
		int temp = 0;
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// 由小到大排序
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					// 发生交换 flag 置为true
					flag = true;
				}
			}
			if (!flag) {
				// 排序完毕
				return;
			}
		}
	}

	// 直接选择排序
	/**
	 * 选择排序是常用内部排序的一种，常见的实现算法有直接选择排序算法和堆排序算法，
	 * 选择排序的基本思想是每次从待排数据中选择第n小的数据放到排序列表的第n个位置
	 * ，假如共有N个数据待排，那么经过N-1次排序后，待排数据就已经按照从小到大的顺序排列了。
	 * 
	 * 　　直接选择排序算法的思想比较简单：（假设数据放在一个数组a中，且数组的长度是N）
	 * 
	 * 　　1：从a[0]-a[N-1]中选出最小的数据，然后与a[0]交换位置
	 * 
	 * 　　2：从a[1]-a[N-1]中选出最小的数据，然后与a[1]交换位置（第1步结束后a[0]就是N个数的最小值）
	 * 
	 * 　　3：从a[2]-a[N-1]中选出最小的数据，然后与a[2]交换位置（第2步结束后a[1]就是N-1个数的最小值）
	 * 
	 * 　　以此类推，N-1次排序后，待排数据就已经按照从小到大的顺序排列了。
	 */
	public static void getSelection(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int k = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[k] > arr[j]) {
					k = j;
				}
			}
			if (k != i) {// 交换元素
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}

	}
}
