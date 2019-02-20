package fr.epita.quiz.launcher;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.epita.quiz.model.Answer;
import fr.epita.quiz.model.MCQChoice;
import fr.epita.quiz.model.Questions;
import fr.epita.quiz.model.Results;
import fr.epita.quiz.dao.questionsDAO;


public class Launcher {
	private questionsDAO dao;
	private static Scanner in;

	public Launcher() {
		dao = new questionsDAO();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Java Quiz\n");
		       System.out.println("Enter your Name "); 
		       in = new Scanner(System.in); 
		       String s = in.nextLine(); 
		       System.out.println("\nHello "+s+", Please Follow The Instructions\n");
		       System.out.println("1.Each question in the quiz is of multiple-choice or True or False or Open Question format.\n"
		       		+ "2.Read each question carefully, and Type the Answer to your response.\n"
		       		+ "3.After responding to a question, click enter to go to the next question.\n"
		       		+ "4.The total score for the quiz is based on your responses to all questions.\n\n\n"
		       		+ "Good Luck !!\n\n");
		
		
		Launcher launcher = new Launcher();
		launcher.displayQuestions();
	}

	
	@SuppressWarnings("resource")
	private void displayQuestions() {
		List<Questions> questions = dao.getQuestions();
		Collections.shuffle(questions, new Random());

		for (Questions quest : questions) {

			System.out.println(quest.getQuestion());
			checkAndFetchMCQs(quest);

			Scanner scanner = new Scanner(System.in);
			String ans = scanner.nextLine();
			Answer answer = new Answer(quest.getQues_id(), ans);
			dao.Add(answer);
		}

		verifyAnswers();
	}

	
	private void verifyAnswers() {
		List<Results> results = dao.getAnswers();
		int score = 0;

		for (Results result : results) {

			if (result.getUser_answer() != null
					&& result.getActual_answer().trim().equalsIgnoreCase(result.getUser_answer().trim())) {
				score += 1;
			}
		}
		System.out.println("\n\nEnd of Quiz\n\n");
		System.out.println("Score is: " + score+"/10");
		System.out.println("\n------------------------------------------------------------------");

	}

	
	private void checkAndFetchMCQs(Questions quest) {
		List<MCQChoice> mcqChoices = new ArrayList<>();

		if (quest.isIsmcq()) {
			mcqChoices = dao.getMCQs(quest);

			for (MCQChoice mcqChoice : mcqChoices) {
				System.out.println(mcqChoice.getChoice());
			}
		}
	}

}
