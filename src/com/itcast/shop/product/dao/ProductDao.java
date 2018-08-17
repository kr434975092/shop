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
 * 商品持久层
 * @author: 康
 */
public class ProductDao extends HibernateDaoSupport{
	//首页热门商品查询
	public List<Product> findHot() {
		//使用离线查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查询热门商品，is_host=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> hList=(List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
		return hList;
	}
	//首页最新商品查询
	public List<Product> findNew() {
		//使用离线查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查询最新商品倒序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> nList=(List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
		return nList;		
 
	}
	//根据商品id查询
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	//根据分类id查询商品个数
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
	//根据分类id查询商品集合
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?0";
		//分页的另一种写法
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
	//根据二级分类id查询商品集合
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs  where cs.csid = ?0";
		//分页的另一种写法
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
	//根据二级分类id查询商品个数
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
