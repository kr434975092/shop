package com.itcast.shop.product.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.itcast.shop.product.dao.ProductDao;
import com.itcast.shop.product.vo.Product;
import com.itcast.shop.utils.PageBean;
/**
 * ��Ʒ��ҵ���
 * @author: ��
 */
@Transactional
public class ProductService {

	//ע��ProductDAO
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	//��ҳ������Ʒ��ѯ
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return productDao.findHot();
	}
	//��ҳ������Ʒ��ѯ
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return productDao.findNew();
	}
	//����id��ѯ��Ʒ
	public Product findByPid(Integer pid) {
		
		return productDao.findByPid(pid);
	}
	//����һ�������cid���з�ҳ�Ĳ�ѯ��Ʒ	 
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean=new PageBean<Product>();
		//���õ�ǰ��ҳ��
		pageBean.setPage(page);
		//����ÿһҳ��ʾ�ļ�¼��
		int limit=8;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		int totalCount=0;
		totalCount=productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage=0;
		//Math.ceil(totalCount/limit)����ȡ��
		if(totalCount%limit==0)
		{
			totalPage=totalCount/limit;
		}
		else
		{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ���
		//���Ŀ�ʼ��
		int begin=(page-1)*limit;
		
		List<Product> list=productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//���õ�ǰ��ҳ��
		pageBean.setPage(page);
		//����ÿһҳ��ʾ�ļ�¼��
		int limit=8;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		int totalCount=0;
		totalCount=productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage=0;
		//Math.ceil(totalCount/limit)����ȡ��
		if(totalCount%limit==0)
		{
			totalPage=totalCount/limit;
		}
		else
		{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ���
		//���Ŀ�ʼ��
		int begin=(page-1)*limit;
		
		List<Product> list=productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
}
