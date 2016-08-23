package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.WordAnswerBusiness;
import framgiavn.project01.web.dao.WordAnswerDAO;

public class WordAnswerBusinessImpl implements WordAnswerBusiness {

	private WordAnswerDAO wordAnswerDAO;

	public WordAnswerDAO getWordAnswerDAO() {
		return wordAnswerDAO;
	}

	public void setWordAnswerDAO(WordAnswerDAO wordAnswerDAO) {
		this.wordAnswerDAO = wordAnswerDAO;
	}

}
