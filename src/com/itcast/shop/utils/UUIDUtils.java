package com.itcast.shop.utils;

import java.util.UUID;

/*
 * ��������ַ����Ĺ�����
 */
public class UUIDUtils {
	
	/*
	 * ��ȡ����ַ���
	 */
	public static String getUUID()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}
}
