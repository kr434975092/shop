package com.itcast.shop.category.service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.itcast.shop.category.dao.CategoryDao;
import com.itcast.shop.category.vo.Category;
/**
 * һ������ҵ������
 * @author: ��
 */
@Transactional
public class CategoryService {
	
	//ע��categoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	//ҵ����ѯ����һ������ķ���
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.fandAll();
	}
	
}
