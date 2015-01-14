package com.duyu.dao;

import java.util.List;

public interface CommonDao {
	/**
	 * 根据hql query查询
	 * 
	 * @param <T>
	 * @param query
	 * @param o
	 * @param maxResultNum
	 * @return
	 * @throws RuntimeException
	 */
	public <T> List<T> findObjectsByQuery(String query, Object o[],
			int maxResultNum) throws RuntimeException;

	/**
	 * 根据hql查询单一结果
	 * 
	 * @param hql
	 * @param params
	 * @return
	 * @throws RuntimeException
	 */
	public Object uniqueResultHQL(String hql, Object... params)
			throws RuntimeException;

	/**
	 * 调用存储过程
	 * 
	 * @param name
	 *            存储过程名
	 * @param params
	 *            参数列表
	 * 
	 * @return
	 * @throws RuntimeException
	 */
	public void callProcedure(final String sql, final Object[] params)
			throws RuntimeException;
}
