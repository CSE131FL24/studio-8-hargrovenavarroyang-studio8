package studio8;

import java.util.Scanner;

public class Quiz {

	private Question[] questions;
	
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	private String getUserAnswer() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	public int getTotalPoints() {
		int sum = 0;
		for(Question q : questions) {
			sum += q.getPoints();
		}
		return sum;
	}
	
	public void takeQuiz() {
		int pointsEarned = 0;
		for (int i=0; i<questions.length; i++) {
			questions[i].displayPrompt();
			String ans = getUserAnswer();
			System.out.println(questions[i].checkAnswer(ans));
			pointsEarned = pointsEarned + questions[i].checkAnswer(ans);
		}
		System.out.println("Total Points Earned: " + pointsEarned);
		System.out.println("Total points available: " + this.getTotalPoints());
		
	}
	
	public static void main(String[] args) {
		
		Question a = new Question("Who is the greatest singer of all time", "Kamijo", 50000);
		Question b = new MultipleChoiceQuestion("Kamijo?", "2", 600000, new String[] {"no", "yes"});

		

		
		Question selectAll = new SelectAllQuestion("Select all of the following:", "12345678", new String[] {"Kamijo", "Kamijo", "Kamijo", "Kamijo", "Kamijo", "Kamijo", "Kamijo", "Kamijo"});

		Question[] questions = {a, b, selectAll}; //create and add more questions!
		
		Quiz studio8quiz = new Quiz(questions);
		studio8quiz.takeQuiz();
	}
}
