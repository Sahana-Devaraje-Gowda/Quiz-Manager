package fr.epita.quiz.model;

public class Questions {

	private int ques_id;
	private String topics;
	private String question;
	private int difficulty;
	private boolean ismcq;

	public Questions(int ques_id, String topics, String question, int difficulty, boolean ismcq) {
		this.ques_id = ques_id;
		this.topics = topics;
		this.question = question;
		this.difficulty = difficulty;
		this.ismcq = ismcq;
	}

	@Override
	public String toString() {
		return "Question [id=" + ques_id + ", question=" + question + ", topics=" + topics + ", difficulty="
				+ difficulty + "]";
	}

	public int getQues_id() {
		return ques_id;
	}

	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public boolean isIsmcq() {
		return ismcq;
	}

	public void setIsmcq(boolean ismcq) {
		this.ismcq = ismcq;
	}
}
