package com.itcast.shop.category.service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.itcast.shop.category.dao.CategoryDao;
import com.itcast.shop.category.vo.Category;
/**
 * 一级分类业务层对象
 * @author: 康
 */
@Transactional
public class CategoryService {
	
	//注入categoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	//业务层查询所有一级分类的方法
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.fandAll();
	}
	
}
