package fr.epita.quiz.model;

public class Student {
	private int id;
	private String name;

	private Answer ans;
	private MCQAnswer MCQans;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
