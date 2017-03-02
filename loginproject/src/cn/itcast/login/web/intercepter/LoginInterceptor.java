package cn.itcast.login.web.intercepter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.login.domain.User;
import cn.itcast.login.utils.BOSContext;



public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("自定义拦截器执行了....");
		User user=BOSContext.getLoginUser();
		if(user==null){
			return "login";
		}else{
			return invocation.invoke();
		}
	}

}
