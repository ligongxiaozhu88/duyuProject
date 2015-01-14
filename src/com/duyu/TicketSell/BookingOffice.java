package com.duyu.TicketSell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BookingOffice implements Runnable {
	// 表示目前可销售的车票种类
	private static Map<Destanation, Ticket> tickets = new HashMap<Destanation, Ticket>();
	private Map<Destanation, Integer> records;// 是当前售票厅的火车票销售情况
	private static List<BookingOffice> offices = new ArrayList<BookingOffice>();// 表示当前可工作的所有售票厅，每个售票厅是一个线程
	private int ticketsSold = 0;// 表示当前售票厅售出的火车票总数
	private final int id;// 表示当前售票厅编号
	// 每个线程都会模拟客户买票、工作人员查询数据库和售票交易过程。
	// 模拟的数据为，当前发往北京、上海和天津的火车票各5张；每个售票厅交易5次（无论交易成功或失败）后关闭。

	// now today's tickets for sell:
	static {
		tickets.put(Destanation.BEIJING, new Ticket(5, Destanation.BEIJING));
		tickets.put(Destanation.SHANGHAI, new Ticket(5, Destanation.SHANGHAI));
		tickets.put(Destanation.TIANJIN, new Ticket(5, Destanation.TIANJIN));
	}

	public BookingOffice(int id) {
		this.id = id;
		offices.add(this);
		resetRecords();
	}

	private void resetRecords() {
		records = new HashMap<Destanation, Integer>();
	}

	private void addRecords(Destanation d) {
		Integer freq = records.get(d);
		records.put(d, freq == null ? 1 : freq + 1);
	}

	public void run() {
		int transaction = 5;
		while (transaction-- > 0) {
			// simulate a customer's coming:
			Destanation d = Destanation.values()[new Random()
					.nextInt(Destanation.values().length)];
			print(this + "i want a ticket for " + d);
			// simulate the officer's checking:
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// simulate the transaction:
			Ticket wanted = tickets.get(d);
			synchronized (wanted) {
				if (!wanted.soldout()) {
					print(this + "sold a ticket for " + d);
					wanted.degress();
					addRecords(d);
					++ticketsSold;
					print(this + "" + d + " tickets still have "
							+ wanted.getCurrent());
				} else
					print(this + "tickets for " + d + " have been sold out.");
			}
		}
		print(this + "closed");
		print(this + "totally sold tickets:" + ticketsSold + ",sell records:"
				+ records);
	}

	public synchronized int getValue() {
		return ticketsSold;
	}

	public String toString() {
		return "<Officce-" + id + ">";
	}

	static void print(String s) {
		System.out.println(s);
	}
}
