package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Word implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int word_id;
	private String content;
	private Date created_at;
	private Date updated_at;
	private Category category;
	private Set<WordAnswer> word_wordAnswer = new HashSet<WordAnswer>(0);
	
	public int getWord_id() {
		return word_id;
	}
	public void setWord_id(int word_id) {
		this.word_id = word_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<WordAnswer> getWord_wordAnswer() {
		return word_wordAnswer;
	}
	public void setWord_wordAnswer(Set<WordAnswer> word_wordAnswer) {
		this.word_wordAnswer = word_wordAnswer;
	}
}
