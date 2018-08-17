package com.itcast.shop.product.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.itcast.shop.product.dao.ProductDao;
import com.itcast.shop.product.vo.Product;
import com.itcast.shop.utils.PageBean;
/**
 * 商品的业务层
 * @author: 康
 */
@Transactional
public class ProductService {

	//注入ProductDAO
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	//首页热门商品查询
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return productDao.findHot();
	}
	//首页最新商品查询
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return productDao.findNew();
	}
	//根据id查询商品
	public Product findByPid(Integer pid) {
		
		return productDao.findByPid(pid);
	}
	//根据一级分类的cid带有分页的查询商品	 
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前的页数
		pageBean.setPage(page);
		//设置每一页显示的记录数
		int limit=8;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount=0;
		totalCount=productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
		//Math.ceil(totalCount/limit)向上取整
		if(totalCount%limit==0)
		{
			totalPage=totalCount/limit;
		}
		else
		{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
		//从哪开始：
		int begin=(page-1)*limit;
		
		List<Product> list=productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前的页数
		pageBean.setPage(page);
		//设置每一页显示的记录数
		int limit=8;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount=0;
		totalCount=productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
		//Math.ceil(totalCount/limit)向上取整
		if(totalCount%limit==0)
		{
			totalPage=totalCount/limit;
		}
		else
		{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
		//从哪开始：
		int begin=(page-1)*limit;
		
		List<Product> list=productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
}
