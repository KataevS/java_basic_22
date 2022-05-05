package quiz2;

class Person {
    private String userName;
    private int userGrade;

    Person(String userName) {
        this.userName = userName;
        this.userGrade = 0;
    }

    public String getUserName() {
        return userName;
    }

    public int calculateUserGrade() {
		int userGrade = 0;
		
		for (int i=0; i < Quiz2.QUESTION_SELECTED; i++) {
			int numberOfUserQuestion = Question.indexOfUsedQuestions[i];
			if ( Answer.getUserAnswer(i) == Question.getCorrectAnswer(numberOfUserQuestion) ) {
			userGrade++;
			}
		}
		return userGrade;
	}
	
    public int getUserRating(){
        return userGrade;
    }
	
	public void resetUserGrade() {
		userGrade = 0;
	}
}