package cn.itcast.login.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
	public List<T> findByNameQuery(String queryName,Object...args);
}
