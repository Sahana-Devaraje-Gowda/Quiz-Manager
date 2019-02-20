package fr.epita.quiz.model;

public class Answer {

	private int ques_id;
	private String answer;

	public Answer(int ques_id, String text) {
		this.ques_id = ques_id;
		this.answer = text;
	}

	public int getQues_id() {
		return ques_id;
	}

	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [ques_id=" + ques_id + " ;answer=" + answer + "]";
	}

}