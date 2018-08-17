package com.itcast.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itcast.shop.user.service.UserService;
import com.itcast.shop.user.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * �û�ģ��action��
 */

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//������֤��
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	//ע��service
	private UserService userSErvice;
	
	public UserService getUserSErvice() {
		return userSErvice;
	}
	public void setUserSErvice(UserService userSErvice) {
		this.userSErvice = userSErvice;
	}
	
	//ģ������ʹ�õĶ���
	
	/*
	 * ��ת��ע��ҳ���ִ�з���
	 */
	public String registPage()
	{
		return "registPage";
	}
	/*
	 * Ajex�첽У���û���
	 */
	public String findByName() throws IOException
	{
		//����service���в�ѯ
		User existUser=userSErvice.findByUsername(user.getUsername()); 
		
		//���response������ҳ�������
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(existUser!=null)
		{
			//�û����Ѵ���
			response.getWriter().print("<font color='red'>�û����Ѿ�����</font>");
		}else{
			//û��ѯ���û���������ʹ��
			response.getWriter().print("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}
	
	public String regist()
	{
		//�ж���֤��
		//��session�л�ȡ�����ɵ���֤��
		String checkcode1=(String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		System.out.println(checkcode1);
		if(!checkcode.equalsIgnoreCase(checkcode1))
		{
			this.addActionError("��֤���������");
			return "checkcodeFail";
		}
		userSErvice.save(user);
		return "msg";
	}
	

	/*
	 * ��ת����¼ҳ���ִ�з���
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
			this.addActionError("��¼ʧ�ܣ��û������������");
			return LOGIN;
		}
		else{
			//session���û���Ϣ�������ת
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess";
		}
		
	}
	
	//�û��˳��ķ���
	public String quit()
	{
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
