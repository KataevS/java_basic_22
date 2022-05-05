package quiz2;

class Answer {
	private static int[] userAnswers = new int[Quiz2.QUESTION_SELECTED]; //ответы участника
	private static int counter = 0; //счётчик ответов участника
	
	public static void saveUserAnswer(int userAnswer) {
		userAnswers[counter] = userAnswer;
		counter++;
	}
	
	public static int getUserAnswer(int numberOfQuestion){
		return userAnswers[numberOfQuestion];
	}
	
	public static void resetAnswers() {
		counter = 0;
	}
}