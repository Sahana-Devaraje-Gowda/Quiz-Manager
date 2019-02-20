package fr.epita.quiz.model;

public class Results {
	private String actual_answer;
	private String user_answer;

	public Results(String actual_answer, String user_answer) {
		this.actual_answer = actual_answer;
		this.user_answer = user_answer;
	}

	public String getActual_answer() {
		return actual_answer;
	}

	public void setActual_answer(String actual_answer) {
		this.actual_answer = actual_answer;
	}

	public String getUser_answer() {
		return user_answer;
	}

	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}
}
