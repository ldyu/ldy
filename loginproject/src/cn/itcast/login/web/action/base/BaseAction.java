package cn.itcast.login.web.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	protected T model;
	public T getModel() {
		return model;
	}
	protected DetachedCriteria detachedCriteria;
	public BaseAction(){
		//获得父类（BaseAction<T>）类型
		ParameterizedType genericSuperclass = null;
		Type genericSuperclass2 = this.getClass().getGenericSuperclass();
		if (genericSuperclass2 instanceof ParameterizedType) {
			genericSuperclass=(ParameterizedType) genericSuperclass2;
		} else {
			genericSuperclass=(ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass();
		}
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> domainClass = (Class<T>) actualTypeArguments[0];
		detachedCriteria=DetachedCriteria.forClass(domainClass);
		try {
			model=domainClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
