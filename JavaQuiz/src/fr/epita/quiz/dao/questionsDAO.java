package fr.epita.quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.quiz.model.Answer;
import fr.epita.quiz.model.Results;
import fr.epita.quiz.service.Configuration;
import fr.epita.quiz.model.MCQChoice;
import fr.epita.quiz.model.Questions;


public class questionsDAO {

	public static final String sq = "SELECT * FROM QUESTION";
	public static final String aq = "SELECT ACTUAL_ANS, USER_ANS FROM ANSWER";
	public static final String aqs = "UPDATE ANSWER SET USER_ANS = ? WHERE QUES_ID = ?";
	public static final String smq = "SELECT * FROM MCQ_CHOICE WHERE QUES_ID = ?";

	
	public List<Questions> getQuestions() {
		List<Questions> resultList = new ArrayList<Questions>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sq);) {

			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {
				int id = results.getInt("QUES_ID");
				int difficulty = results.getInt("DIFFICULTY");
				boolean isMcq = results.getBoolean("ISMCQ");
				String topics = results.getString("TOPICS");
				String quest = results.getString("QUESTIONS");

				Questions currentQuestion = new Questions(id, topics, quest, difficulty, isMcq);
				resultList.add(currentQuestion);
			}
			results.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	
	public List<Results> getAnswers() {
		List<Results> resultsList = new ArrayList<>();

		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(aq);

			ResultSet results = statement.executeQuery();
			while (results.next()) {
				String actual_ans = results.getString("ACTUAL_ANS");
				String user_ans = results.getString("USER_ANS");

				Results result = new Results(actual_ans, user_ans);
				resultsList.add(result);
			}
			results.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultsList;
	}

	
	public void Add(Answer answer) {

		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(aqs);
			statement.setString(1, answer.getAnswer());
			statement.setInt(2, answer.getQues_id());
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public List<MCQChoice> getMCQs(Questions question) {
		List<MCQChoice> mcqChoicesList = new ArrayList<>();

		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(smq);

			statement.setInt(1, question.getQues_id());
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				int id = results.getInt("MCQ_ID");
				String choice = results.getString("CHOICE");

				MCQChoice mcqChoice = new MCQChoice(id, choice);
				mcqChoicesList.add(mcqChoice);
			}
			results.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mcqChoicesList;

	}

	
	private Connection getConnection() throws SQLException {
		Configuration conf = Configuration.getInstance();
		String jdbcUrl = conf.getConfigurationValue("jdbc.url");
		String user = conf.getConfigurationValue("jdbc.user");
		String password = conf.getConfigurationValue("jdbc.password");
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}
}

