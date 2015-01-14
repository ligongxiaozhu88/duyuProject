package com.duyu.action;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.duyu.core.BaseAction;
import com.duyu.domain.User;
import com.duyu.service.LoginService;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction {

	
	/**
	 * 登录action
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private LoginService loginService;

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 跳转到登录页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String index() {
//		try {
//			setRequestAttribute("uerlist", loginService.loadUserList());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		User user=(User)getSession().getAttribute("user");
		if(user ==null){
			return "noLogin";
		}else if("admin".equals(user.getUsername())){
			return "admin";
		}else{
			return "login";
		}
	}
	/**
	 * 查询用户信息是否匹配
	 */
	public String login() {
		try {
			User user=loginService.loadinfo(username, password);
			if(user !=null){
				getSession().setAttribute("user",user);
				setSuccess(true);
			}else{
				setMessage("用户名或密码不正确");
				setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 退出
	 * @return
	 */
	public String logout(){
		getSession().invalidate();
		return "nologin";
		
	}
	/**
	 * 导出excel
	 * 
	 * @return
	 */
	public String exportAsExcel() {
		try {
			loginService.exportAsExcel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public static void main(String args[]){
		System.out.println("111");
	}

}
