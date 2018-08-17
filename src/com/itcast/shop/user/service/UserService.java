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
	
	//�û�ע�ᣬҵ���
	public void save(User user) {
		// TODO Auto-generated method stub
		user.setState(1);	//0����δ���� 1�����Ѽ���
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
	}
	//�û���¼��ҵ���
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}
}
