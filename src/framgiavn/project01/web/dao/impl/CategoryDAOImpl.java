package framgiavn.project01.web.dao.impl;

import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.ulti.Logit2;

public class CategoryDAOImpl extends GenericDAOImpl<Category, Integer> implements CategoryDAO {

	private static final Logit2 log = Logit2.getInstance(CategoryDAOImpl.class);
	public static final String NAME = "customerName";

	public CategoryDAOImpl() {
		super(Category.class);
	}

	protected void initDAO() {
		// Do nothing
	}
}
