package com.itcast.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.itcast.shop.cart.vo.Cart;
import com.itcast.shop.cart.vo.CartItem;
import com.itcast.shop.product.service.ProductService;
import com.itcast.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 购物车action
 * @author: 康
 */
public class CartAction extends ActionSupport{
	//接收PID
	private Integer pid;
	//接收数量
	private Integer count;
	//注入service
	private ProductService productService;
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//将购物项添加到购物车
	 public String addCart()
	 {
		 //封装一个CartItem对象
		 CartItem cartItem =new CartItem();
		 cartItem.setCount(count);
		 //查询并设置商品
		Product product= productService.findByPid(pid);
		 cartItem.setProduct(product);
		 //从session获取购物车
		 Cart cart=getCart();
		 cart.addCart(cartItem);
		 return "addCart";
	 }
	//清空购物车
	 public String clearCart()
		{
			Cart cart=getCart();
			cart.clearCart();
			return "clearCart";
		}

		//移除购物车
	 public String removeCart()
		{
			Cart cart=getCart();
			cart.removeCart(pid);
			return "removeCart";
		}
		
		//移除购物车
	 public String myCart()
		{
			return "myCart";
		}
	 //获得购物车的方法
	private Cart getCart() {
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null)
		{
			cart=new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	
}
