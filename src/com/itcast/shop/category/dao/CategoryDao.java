package com.itcast.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itcast.shop.category.vo.Category;

/**
 * 一级分类持久层对象
 * @author: 康
 */
public class CategoryDao extends HibernateDaoSupport{

	//持久层查询所有一级分类的方法
	public List<Category> fandAll() {
		// TODO Auto-generated method stub
		String hql="from Category";
		List<Category> list=(List<Category>) this.getHibernateTemplate().find(hql);
		return list;
	}
	
}
