package com.itcast.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itcast.shop.category.vo.Category;

/**
 * һ������־ò����
 * @author: ��
 */
public class CategoryDao extends HibernateDaoSupport{

	//�־ò��ѯ����һ������ķ���
	public List<Category> fandAll() {
		// TODO Auto-generated method stub
		String hql="from Category";
		List<Category> list=(List<Category>) this.getHibernateTemplate().find(hql);
		return list;
	}
	
}
