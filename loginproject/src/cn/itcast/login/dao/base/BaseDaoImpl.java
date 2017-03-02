package cn.itcast.login.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T>{
	private Class<T> domainClass;
	@Resource
	public void setSF(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	public BaseDaoImpl(){
		ParameterizedType genericSuperclass = (ParameterizedType)this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		domainClass = (Class<T>) actualTypeArguments[0];
	}
	public List<T> findByNameQuery(String queryName, Object... args) {
		return this.getHibernateTemplate().findByNamedQuery(queryName, args);
	}

}
