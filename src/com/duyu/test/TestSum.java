package com.duyu.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSum {
	// 求连续子序列最大和
	public static void main(String args[]) {
		TestSum sum = new TestSum();
		int[] test = {-2, -1, 0, 1, 3, 4, 7};
		sum.date();
		TestSum.maxSubSum3(test);
		sum.date();
	}
	public static int maxSubSum2(int[] a) {
		int maxSum = 0;
		int seqStart = 0;
		int seqEnd = 0;
		for (int i = 0; i < a.length; i++) {
			int thisSum = 0;
			for (int j = i; j < a.length; j++) {
				thisSum += a[j];
				if (thisSum > maxSum) {
					maxSum = thisSum;
					seqStart = i;
					seqEnd = j;
					// System.out.println("max:" + thisSum + "start:" + seqStart
					// + "seqEnd" + seqEnd);
				}
			}
		}
		System.out.println(new Date(0));
		return maxSum;

	}
	public void date() {
		String msg = "";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		msg += "[" + sdf.format(date) + "]";
		System.out.println(msg);

	}
	public static int maxSubSum3(int[] a) {

		int i;
		int curSum; /* 当前序列和 */
		int maxSum; /* 最大序列和 */

		/* 初始化当前序列和为0 */
		curSum = 0;

		/* 初始化最大子序列和为序列第一个元素 */
		maxSum = a[0];

		/* 开始循环求子序列和 */
		for (i = 0; i < a.length; i++) {
			curSum = curSum + a[i];

			/* 与最大子序列和比较，更新最大子序列和 */
			if (curSum > maxSum) {
				maxSum = curSum;
			}

			/* 动态规划部分，舍弃当前和为负的子序列 */
			if (curSum < 0) {
				curSum = 0;
			}
		}
		return maxSum;

		// int seqStart = 0;
		// int seqEnd = 0;
		// int maxSum = 0;
		// int thisSum = 0;
		// for (int i = 0, j = 0; i < a.length; j++) {
		// // 先全部相加的到一个值
		// thisSum += a[j];
		// if (thisSum > maxSum) {
		// maxSum = thisSum;
		// seqStart = i;
		// seqEnd = j;
		// System.out.println("max:" + thisSum + "start:" + seqStart
		// + "seqEnd" + seqEnd);
		// } else if (thisSum < 0) {
		// i = j + 1;
		// thisSum = 0;
		// }
		// }
		// return maxSum;
	}
}
