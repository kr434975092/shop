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
 * @author: 康
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//用于接收数据的模型驱动
	private Product product=new Product();
	//注入service
	private ProductService productService;
	//接收分类的cid
	private Integer cid;
	//接收二级分类的csid
	private Integer csid;
	public Integer getCid() {
		return cid;
	}

	//注入一级分类的service
	private CategoryService categoryService;
	//接收当前的页数
	private int page;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Product getModel() {
		return product;
	}
	
	//根据商品的id查询商品：执行方法
	public String findByPid()
	{
		//调用Service完成查询
		product=productService.findByPid(product.getPid());
		return "findByPid";
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//根据分类的id查询相应的商品
	public String findByCid()
	{
		//List<Category> cList=categoryService.findAll();
		PageBean<Product> pageBean=productService.findByPageCid(cid,page);//根据一级分类分页查询商品
		//将PageBean存入值栈
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		
		return "findByCid";
	}
	
	//根据二级分类的id查询相应的商品
	public String findByCsid()
	{
		PageBean<Product> pageBean=productService.findByPageCsid(csid,page);//根据一级分类分页查询商品
		//将PageBean存入值栈
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
