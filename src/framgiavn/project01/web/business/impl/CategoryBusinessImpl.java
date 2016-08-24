package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.dao.CategoryDAO;

public class CategoryBusinessImpl implements CategoryBusiness {

	private CategoryDAO categoryDAO;

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

}
