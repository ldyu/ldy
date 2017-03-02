package cn.itcast.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.login.dao.IUserDao;
import cn.itcast.login.domain.User;
import cn.itcast.login.service.IUserService;
import cn.itcast.login.utils.MD5Utils;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	public User login(User model) {
		List<User> list = userDao.findByNameQuery("findByUsernameAndPassword", model.getUsername(),model.getUsername());
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
