package fr.epita.quiz.model;

public class MCQQuestion extends Questions {
	
	public MCQQuestion(int ques_id, String topics, String question, int difficulty, boolean ismcq) {
		super(ques_id, topics, question, difficulty, ismcq);
		// TODO Auto-generated constructor stub
	}

	private MCQChoice MCQChoice;

	public MCQChoice getMCQChoice() {
		return MCQChoice;
	}

	public void setMCQChoice(MCQChoice mCQChoice) {
		MCQChoice = mCQChoice;
	}

}
