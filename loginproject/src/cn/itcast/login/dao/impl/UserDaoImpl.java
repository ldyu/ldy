package cn.itcast.login.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.login.dao.IUserDao;
import cn.itcast.login.dao.base.BaseDaoImpl;
import cn.itcast.login.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{
	
}
