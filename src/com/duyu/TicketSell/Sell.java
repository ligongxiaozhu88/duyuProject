package com.duyu.TicketSell;

import java.util.concurrent.ExecutorService;


import java.util.concurrent.Executors;

public class Sell {
	// 模拟售票过程如下，启动5个售票厅。
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new BookingOffice(i));
		exec.shutdown();
	}
}
