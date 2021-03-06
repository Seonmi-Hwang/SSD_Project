package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Question;

public interface QuestionDao {

	Question getQuestion(int questionId) throws DataAccessException;

	List<Question> getQuestionList(int groupBuyId) throws DataAccessException;
	
	void createQuestion(Question question) throws DataAccessException;

	void updateQuestion(Question question) throws DataAccessException;
	
	void deleteQuestion(int questionId) throws DataAccessException;
}
