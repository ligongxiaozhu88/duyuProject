package com.duyu.core;


import java.io.UnsupportedEncodingException;



import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	protected boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public JsonPage getJsonPage() {
		return jsonPage;
	}

	public void setJsonPage(JsonPage jsonPage) {
		this.jsonPage = jsonPage;
	}
	protected JsonPage jsonPage;
	
	/**
	 * 获得request
	 */
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}

	/**
	 * 
	 * 获得resoponse
	 */
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	/**
	 * 获得session
	 * 
	 */
	public HttpSession getSession(){
		return getRequest().getSession();
	}
	
	/**
	 *获得servlet上下文 
	 */
	public ServletContext geServletContext(){
		return ServletActionContext.getServletContext();
	}
	
	/**
	 * 获得ip地址
	 */
	public String getIpAddr(){
		HttpServletRequest request =getRequest();
		String ip=request.getHeader("x-forwarded-for");
		if(StringUtils.isBlank(ip)||"unknown".equalsIgnoreCase(ip)){
			ip=request.getHeader("Proxy-Client-IP");
		}
		if(StringUtils.isBlank(ip)||"unknown".equalsIgnoreCase(ip)){
			ip=request.getHeader("WL-Proxy-Client-IP");
		}
		if(StringUtils.isBlank(ip)||"unknown".equalsIgnoreCase(ip)){
			ip=request.getRemoteAddr();
		}
		return ip;
		
	}
	
	/**
	 * 添加cookie 如果maxAge为0 时表示删除改cookie maxAge为负数时 表示浏览器关闭 cookie生命结束
	 */
	public void setCookie(String key,String value,int maxAge)throws UnsupportedEncodingException{
		if (key==null ||value==null) {
			return;
		}
		Cookie preCookie=null;
		if(getRequest().getCookies()!=null){
			for(Cookie cookie:getRequest().getCookies()){
				if(cookie.getName().equals(key.trim())){
					preCookie=cookie;
					break;
				}
			}
		}
		if(preCookie!=null){
			preCookie.setValue(StringUtils.isBlank(value)?null:URLEncoder.encode(value,"utf-8"));
		}else{
			preCookie=new Cookie(key.trim(),StringUtils.isBlank(value)?null:URLEncoder.encode(value,"utf-8"));
		}
		preCookie.setMaxAge(maxAge);
		getResponse().addCookie(preCookie);
	}
	
	public boolean exitsCookieWithValue(String key){
		return !(null==getCookie(key));
	}
	/**
	 * 得到request中该key所对应的cookie值
	 * 
	 */
	public String getCookie(String key){
		if(getRequest().getCookies()!=null){
			for(Cookie cookie:getRequest().getCookies()){
				if(cookie.getName().equals(key.trim())&&StringUtils.isNotBlank(cookie.getValue())){
					return cookie.getValue();
				}
			}
		}
		return  null;
	}
	
	//以下部分是为了使action尽量少的依赖servlet api而添加
	//方便对action进行独立的测试 以后可用以下方便替代的尽量不用上部
	public ActionContext getActionContext(){
		return ActionContext.getContext();
	}
	public Map<String, Object> getRequestParameters(){
		return getActionContext().getParameters();
	}
	public Object getRequestParameter(String key){
		return getActionContext().getParameters().get(key);
	}
	public Map<String, Object> getACSession(){
		return getActionContext().getSession();
	}
	public Object getRequestAttribute(String key){
		return getActionContext().get(key);
	}
	public void setRequestAttribute(String key,Object value){
		getActionContext().put(key, value);
	}
	public Object getSessionAttribute(String key){
		return getACSession().get(key);
	}
	public void setSessionAttribute(String key,Object value){
		getACSession().put(key, value);
	}
	public  void removeSessionAttribute(String key){
		getACSession().remove(key);
	}
	public void clearACSession(){
		getACSession().clear();
	}
}
