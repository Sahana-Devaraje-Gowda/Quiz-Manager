package fr.epita.quiz.model;

public class Quiz {

	private String title;
	
	private Answer ans;
	private MCQAnswer MCQans;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Answer getAns() {
		return ans;
	}

	public void setAns(Answer ans) {
		this.ans = ans;
	}

	public MCQAnswer getMCQans() {
		return MCQans;
	}

	public void setMCQans(MCQAnswer mCQans) {
		MCQans = mCQans;
	}

}
