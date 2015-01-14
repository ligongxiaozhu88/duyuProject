package com.duyu.core;

import java.util.ArrayList;
import java.util.List;

public class JsonPage {
	// 总记录数
	private long totalProperty;

	// 分页结果
	private List<Object> root = new ArrayList<Object>();

	// 开始记录条数
	private int start;

	// 每页多少
	private int limit;

	//
	private String sort;
	//
	private String dir;
	// 是否成功
	private boolean success;

	// 查询条件 json格式 使用时用jsonUtil进行处理
	private String conditions;

	private Object objCondition;
	public long getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(long totalProperty) {
		this.totalProperty = totalProperty;
	}
	@SuppressWarnings("unchecked")
	public List<Object> getRoot() {
		return root;
	}
	@SuppressWarnings("unchecked")
	public void setRoot(List<Object> root) {
		this.root = root;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public Object getObjCondition() {
		return objCondition;
	}
	public void setObjCondition(Object objCondition) {
		this.objCondition = objCondition;
	}
	public JsonPage() {
		// TODO Auto-generated constructor stub
	}

}
