package com.itcast.shop.user.service;


import org.springframework.transaction.annotation.Transactional;

import com.itcast.shop.user.dao.UserDao;
import com.itcast.shop.user.vo.User;
import com.itcast.shop.utils.UUIDUtils;

@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User findByUsername(String username)
	{
		return userDao.findByUserName(username);
	}
	
	//用户注册，业务层
	public void save(User user) {
		// TODO Auto-generated method stub
		user.setState(1);	//0代码未激活 1代表已激活
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
	}
	//用户登录，业务层
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}
}
