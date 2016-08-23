package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.Date;

public class WordAnswer implements Serializable {

	private static final long serialVersionUID = 1L;

	private int word_answer_id;
	private String content;
	private Word word;
	private int correct;
	private Date created_at;
	private Date updated_at;

	public int getWord_answer_id() {
		return word_answer_id;
	}

	public void setWord_answer_id(int word_answer_id) {
		this.word_answer_id = word_answer_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
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
