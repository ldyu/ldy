package cn.itcast.login.utils;

import org.apache.struts2.ServletActionContext;

import cn.itcast.login.domain.User;



public class BOSContext {
	public static User getLoginUser(){
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		return user;
	}
}
