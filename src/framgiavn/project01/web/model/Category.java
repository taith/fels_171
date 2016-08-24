package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	private int category_id;
	private String name;
	private Date created_at;
	private Date updated_at;
	private Set<Word> category_word = new HashSet<Word>(0);

	public Set<Word> getCategory_word() {
		return category_word;
	}

	public void setCategory_word(Set<Word> category_word) {
		this.category_word = category_word;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}
