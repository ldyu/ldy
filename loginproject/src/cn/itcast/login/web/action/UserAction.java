package cn.itcast.login.web.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import cn.itcast.login.domain.User;
import cn.itcast.login.service.IUserService;
import cn.itcast.login.utils.MD5Utils;
import cn.itcast.login.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	@Resource
	protected IUserService userService;
	private String checkcode;//输入的验证码
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String login(){
		//从session中获取生成的验证码
		String validateCode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//确定验证码输入是否正确
		if(StringUtils.isBlank(checkcode)||!checkcode.equals(validateCode)){
			//设置错误提示信息
			this.addActionError(this.getText("checkCodeError"));
			return "login";
		}else{
			User user=userService.login(model);
			if (user!=null) {
				//登陆成功
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				return "home";
			} else {
				//登陆失败，跳转到登陆页面
				this.addActionError(this.getText("loginFail"));
				return "login";
			}
			
		}	
		
	}
}
