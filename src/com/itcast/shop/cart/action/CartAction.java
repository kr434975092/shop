package com.itcast.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.itcast.shop.cart.vo.Cart;
import com.itcast.shop.cart.vo.CartItem;
import com.itcast.shop.product.service.ProductService;
import com.itcast.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ﳵaction
 * @author: ��
 */
public class CartAction extends ActionSupport{
	//����PID
	private Integer pid;
	//��������
	private Integer count;
	//ע��service
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
	//����������ӵ����ﳵ
	 public String addCart()
	 {
		 //��װһ��CartItem����
		 CartItem cartItem =new CartItem();
		 cartItem.setCount(count);
		 //��ѯ��������Ʒ
		Product product= productService.findByPid(pid);
		 cartItem.setProduct(product);
		 //��session��ȡ���ﳵ
		 Cart cart=getCart();
		 cart.addCart(cartItem);
		 return "addCart";
	 }
	//��չ��ﳵ
	 public String clearCart()
		{
			Cart cart=getCart();
			cart.clearCart();
			return "clearCart";
		}

		//�Ƴ����ﳵ
	 public String removeCart()
		{
			Cart cart=getCart();
			cart.removeCart(pid);
			return "removeCart";
		}
		
		//�Ƴ����ﳵ
	 public String myCart()
		{
			return "myCart";
		}
	 //��ù��ﳵ�ķ���
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
