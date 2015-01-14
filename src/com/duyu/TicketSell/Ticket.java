package com.duyu.TicketSell;

public class Ticket {
	private final int original;// 车票基数
	private int current;// 当前票数
	private final Destanation destation;// 目的地

	public Ticket(int nums, Destanation where) {
		current = original = nums;
		destation = where;
	}

	public int degress() {
		return --current;
	}

	public int original() {
		return original;
	}

	public boolean soldout() {
		return current <= 0;
	}

	public Destanation getDestation() {
		return destation;
	}

	public int getCurrent() {
		return current;
	}
}
