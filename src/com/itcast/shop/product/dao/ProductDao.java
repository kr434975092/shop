package com.itcast.shop.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itcast.shop.product.vo.Product;
import com.itcast.shop.utils.PageHibernateCallback;

/**
 * ��Ʒ�־ò�
 * @author: ��
 */
public class ProductDao extends HibernateDaoSupport{
	//��ҳ������Ʒ��ѯ
	public List<Product> findHot() {
		//ʹ�����߲�ѯ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//��ѯ������Ʒ��is_host=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//�������
		criteria.addOrder(Order.desc("pdate"));
		//ִ�в�ѯ
		List<Product> hList=(List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
		return hList;
	}
	//��ҳ������Ʒ��ѯ
	public List<Product> findNew() {
		//ʹ�����߲�ѯ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//��ѯ������Ʒ�������
		criteria.addOrder(Order.desc("pdate"));
		//ִ�в�ѯ
		List<Product> nList=(List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
		return nList;		
 
	}
	//������Ʒid��ѯ
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	//���ݷ���id��ѯ��Ʒ����
	public int findCountCid(Integer cid) {
		String hql="select count(*) from Product p where p.categorySecond.category.cid =?0";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql,cid);
		if(list !=null&&list.size()>0)
		{
			System.out.println(list.get(0).intValue());
			return list.get(0).intValue();
		}
		return 0;
	}
	//���ݷ���id��ѯ��Ʒ����
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?0";
		//��ҳ����һ��д��
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if(list!=null&&list.size()>0)
		{
			return list;
		}
		else
		{
			return null;
		}
	}
	//���ݶ�������id��ѯ��Ʒ����
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs  where cs.csid = ?0";
		//��ҳ����һ��д��
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
		if(list!=null&&list.size()>0)
		{
			return list;
		}
		else
		{
			return null;
		}
	}
	//���ݶ�������id��ѯ��Ʒ����
	public int findCountCsid(Integer csid) {
		String hql="select count(*) from Product p where p.categorySecond.csid =?0";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql,csid);
		if(list !=null&&list.size()>0)
		{
			System.out.println(list.get(0).intValue());
			return list.get(0).intValue();
		}
		return 0;
	}

}
