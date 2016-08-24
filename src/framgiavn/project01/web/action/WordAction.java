package framgiavn.project01.web.action;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.WordBusiness;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public class WordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private WordBusiness wordBusiness = null;
	private List<Word> word = null;

	public WordBusiness getWordBusiness() {
		return wordBusiness;
	}

	public void setWordBusiness(WordBusiness wordBusiness) {
		this.wordBusiness = wordBusiness;
	}

	public List<Word> getWord() {
		return word;
	}

	public void setWord(List<Word> word) {
		this.word = word;
	}

	public String showWordList() {
		setWord(wordBusiness.showWordList());
		System.out.println(word.get(0).getWord_wordAnswer());
		Iterator<WordAnswer> itr = word.get(0).getWord_wordAnswer().iterator();
		while (itr.hasNext()) {
			Object element = itr.next().getContent();
			System.out.print(element + " ");
		}
		return SUCCESS;
	}
}
