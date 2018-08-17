package com.itcast.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itcast.shop.user.vo.User;

public class UserDao extends HibernateDaoSupport{
	//按名称查询是否有该用户 
	public User findByUserName(String username)
	{
		
		String hql="from User where username = ?0";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql, username);
		if(list!=null&&list.size()>0)
		{
			return list.get(0); 
		}
		return null; 
	}
	//注册信息存入数据库
	public void save(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}
	
	//用户登录的方法
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql="from User where username = ?0 and password = ?1";
		List<User> list = (List<User>)this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
		if(list != null && list.size() >0)
		{
			return list.get(0);
		}
		return null;
	}
}
