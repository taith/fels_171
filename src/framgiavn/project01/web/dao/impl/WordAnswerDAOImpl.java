package framgiavn.project01.web.dao.impl;

import framgiavn.project01.web.dao.WordAnswerDAO;
import framgiavn.project01.web.model.WordAnswer;
import framgiavn.project01.web.ulti.Logit2;

public class WordAnswerDAOImpl extends GenericDAOImpl<WordAnswer, Integer> implements WordAnswerDAO {

	private static final Logit2 log = Logit2.getInstance(WordAnswerDAOImpl.class);
	public static final String NAME = "customerName";

	public WordAnswerDAOImpl() {
		super(WordAnswer.class);
	}

	protected void initDAO() {
		// Do nothing
	}
}
