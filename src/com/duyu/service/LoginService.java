package com.duyu.service;

import java.util.List;


import com.duyu.domain.User;



public interface LoginService {
	/**
	 * 验证用户信息
	 */
	public User loadinfo(String username, String password) throws Exception;

	/**
	 * 加载用户信息
	 */
	public List<User> loadUserList() throws Exception;

	/**
	 * 导出excel
	 */
	public void exportAsExcel() throws Exception;

}
