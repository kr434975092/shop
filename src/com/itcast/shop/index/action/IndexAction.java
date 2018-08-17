package com.itcast.shop.index.action;

import java.util.List;

import com.itcast.shop.category.service.CategoryService;
import com.itcast.shop.category.vo.Category;
import com.itcast.shop.product.service.ProductService;
import com.itcast.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * ��ҳ����action
 */
public class IndexAction extends ActionSupport{
	//ע��һ�������service
	private CategoryService categoryService;
	//ע����Ʒ��service
	private ProductService	productService;
	/*
	 * ִ�з�����ҳ�ķ���
	 */
	public String execute()
	{
		//��ѯ����һ������ļ���
		List<Category> cList=categoryService.findAll();
		//��һ���������session
		ActionContext.getContext().getSession().put("cList", cList);
		
		//��ѯ������Ʒ
		List<Product> hList=productService.findHot();
		//���浽ֵջ�У�
		ActionContext.getContext().getValueStack().set("hList",hList);
		
		//��ѯ������Ʒ
		List<Product> nList=productService.findNew();
		//���浽ֵջ�У�
		ActionContext.getContext().getValueStack().set("nList",nList);
		return "index";
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
