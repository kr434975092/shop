package com.itcast.shop.product.action;

import java.util.List;

import com.itcast.shop.category.service.CategoryService;
import com.itcast.shop.category.vo.Category;
import com.itcast.shop.product.service.ProductService;
import com.itcast.shop.product.vo.Product;
import com.itcast.shop.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author: ��
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//���ڽ������ݵ�ģ������
	private Product product=new Product();
	//ע��service
	private ProductService productService;
	//���շ����cid
	private Integer cid;
	//���ն��������csid
	private Integer csid;
	public Integer getCid() {
		return cid;
	}

	//ע��һ�������service
	private CategoryService categoryService;
	//���յ�ǰ��ҳ��
	private int page;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Product getModel() {
		return product;
	}
	
	//������Ʒ��id��ѯ��Ʒ��ִ�з���
	public String findByPid()
	{
		//����Service��ɲ�ѯ
		product=productService.findByPid(product.getPid());
		return "findByPid";
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//���ݷ����id��ѯ��Ӧ����Ʒ
	public String findByCid()
	{
		//List<Category> cList=categoryService.findAll();
		PageBean<Product> pageBean=productService.findByPageCid(cid,page);//����һ�������ҳ��ѯ��Ʒ
		//��PageBean����ֵջ
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		
		return "findByCid";
	}
	
	//���ݶ��������id��ѯ��Ӧ����Ʒ
	public String findByCsid()
	{
		PageBean<Product> pageBean=productService.findByPageCsid(csid,page);//����һ�������ҳ��ѯ��Ʒ
		//��PageBean����ֵջ
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		
		return "findByCsid";
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}
}
