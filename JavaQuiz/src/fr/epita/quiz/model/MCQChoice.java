package fr.epita.quiz.model;


public class MCQChoice {
	private int mcq_id;
	private String choice;

	public MCQChoice(int mcq_id, String choice) {
		this.mcq_id = mcq_id;
		this.choice = choice;
	}

	public int getMcq_id() {
		return mcq_id;
	}

	public void setMcq_id(int mcq_id) {
		this.mcq_id = mcq_id;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	@Override
	public String toString() {
		return "MCQChoice [ mcq_id=" + mcq_id + " choice=" + choice + "]";
	}

}

