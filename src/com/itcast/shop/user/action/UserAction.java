package com.itcast.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itcast.shop.user.service.UserService;
import com.itcast.shop.user.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 用户模块action类
 */

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//接收验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	//注入service
	private UserService userSErvice;
	
	public UserService getUserSErvice() {
		return userSErvice;
	}
	public void setUserSErvice(UserService userSErvice) {
		this.userSErvice = userSErvice;
	}
	
	//模型驱动使用的对象
	
	/*
	 * 跳转到注册页面的执行方法
	 */
	public String registPage()
	{
		return "registPage";
	}
	/*
	 * Ajex异步校验用户名
	 */
	public String findByName() throws IOException
	{
		//调用service进行查询
		User existUser=userSErvice.findByUsername(user.getUsername()); 
		
		//获得response对象向页面中输出
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(existUser!=null)
		{
			//用户名已存在
			response.getWriter().print("<font color='red'>用户名已经存在</font>");
		}else{
			//没查询到用户名，可以使用
			response.getWriter().print("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	
	public String regist()
	{
		//判断验证码
		//从session中获取到生成的验证码
		String checkcode1=(String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		System.out.println(checkcode1);
		if(!checkcode.equalsIgnoreCase(checkcode1))
		{
			this.addActionError("验证码输入错误");
			return "checkcodeFail";
		}
		userSErvice.save(user);
		return "msg";
	}
	

	/*
	 * 跳转到登录页面的执行方法
	 */
	public String loginPage()
	{
		return "loginPage";
	}
	
	public String login()
	{
		User existUser=userSErvice.login(user);
		if(existUser == null)
		{
			this.addActionError("登录失败，用户名或密码错误");
			return LOGIN;
		}
		else{
			//session存用户信息，完成跳转
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess";
		}
		
	}
	
	//用户退出的方法
	public String quit()
	{
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
