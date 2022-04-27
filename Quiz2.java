import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

public class Quiz2 {
	
    public static final int QUESTION_ALL = 10; //общее число вопросов
	public static final int QUESTION_SELECTED = 3; //число задаваемых вопросов

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Добро пожаловать в нашу викторину!
                Как всегда, вам нужно ответить на несколько вопросов.
                Для начала представьтесь, пожалуйста.""");
        Person user = new Person(scanner.nextLine());
        System.out.println(showGreeting() + ", " + user.getUserName() + "!");
        System.out.println("""
            Я буду задавать вопросы, а вы - давать ответы.
            Потом я скажу, сколько правильных ответов вы дали и выставлю оценку.
            Итак, поехали!""");
        while (true) {
			animateChar('*', 50);
			for (int i=0; i<QUESTION_SELECTED; i++){
				System.out.println(Question.getRandomQuestion());
				Answer.saveUserAnswer(scanner.nextInt());
				System.out.println("Ответ принят.");
			}
			System.out.println(user.getUserName() + ", викторина завершена.");
			animateChar('$', 50);
			System.out.println("Ваш результат: " + user.calculateUserGrade() + " из " + QUESTION_SELECTED);
			System.out.println("Ещё хотите попробовать? y/n");
			char userChoose = scanner.next().charAt(0);
			if (userChoose == 'n' || userChoose == 'N' ) {
				break;
			} else {
				Question.resetQuestions();
				Answer.resetAnswers();
				user.resetUserGrade();
				continue;
			}
		}
    }
	
	//метод выводит последовательность заданных символов с задержкой
    private static void animateChar(char symbolToAnimate, int delayMillisecond) {
        final int SYMBOL_COUNT = 10;
        for (int i = 0; i <= SYMBOL_COUNT; i++) {
            System.out.print(symbolToAnimate);
            try {
                TimeUnit.MILLISECONDS.sleep(delayMillisecond);
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
	
	//метод возвращает приветствие в зависимости от текущего часа
	private static String showGreeting() {
        String textGreeting = "";
        Date dateNow = new Date();
        SimpleDateFormat hourCurrent = new SimpleDateFormat("kk");
        int hourInteger = Integer.parseInt(hourCurrent.format(dateNow));
        if (hourInteger <= 6) {
            textGreeting = "Добрая ночь";
        } else if (hourInteger > 6 && hourInteger <= 10) {
            textGreeting = "Доброе утро";
        } else if (hourInteger > 10 && hourInteger <= 19) {
            textGreeting = "Добрый день";
        } else {
            textGreeting = "Добрый вечер";
        }
        return textGreeting;
    }
}

class Question {
    private static int questionCount = Quiz2.QUESTION_ALL; //локальная константа общего количества вопросов
	private static String[] textsOfQuestions = new String[questionCount]; //тексты самих вопросов
	private static int[] correctAnswers = new int[] {11, 22, 33, 44, 55, 66, 77, 88, 99, 1010}; //номера правильных ответов
	private static int counter = 0; //счетчик вопросов для неповторяемости
    static int[] indexOfUsedQuestions = new int[questionCount]; //для хранения последовательности задавания вопросов
	private static boolean[] flagUsedQuestions = new boolean[questionCount]; //флаги задавания вопросов
    
	static {
		textsOfQuestions[0] = "Первый вопрос";
		textsOfQuestions[1] = "Второй вопрос";
		textsOfQuestions[2] = "Третий вопрос";
		textsOfQuestions[3] = "Четвёртый вопрос";
		textsOfQuestions[4] = "Пятый вопрос";
		textsOfQuestions[5] = "Шестой вопрос";
		textsOfQuestions[6] = "Седьмой вопрос";
		textsOfQuestions[7] = "Восьмой вопрос";
		textsOfQuestions[8] = "Девятый вопрос";
		textsOfQuestions[9] = "Десятый вопрос";
	}
	
	//возврат случайного вопроса без повторения
	public static String getRandomQuestion() {
		while (true) {
			int numberOfQuestion = (int) (Math.random()*questionCount);
			if (flagUsedQuestions[numberOfQuestion] == false) {
				indexOfUsedQuestions[counter] = numberOfQuestion;
				flagUsedQuestions[numberOfQuestion] = true;
				counter++;
				return textsOfQuestions[numberOfQuestion];
			} else {
				continue;
			}
		}
	}
	public static int getCorrectAnswer(int numberOfQuestion) {
		return correctAnswers[numberOfQuestion];
	}
	
	public static void resetQuestions() {
		counter = 0;
		for (int i=0; i<flagUsedQuestions.length; i++){
			flagUsedQuestions[i] = false;
		}
	}
}

class Answer {
	private static int questionUserCount = Quiz2.QUESTION_SELECTED; //локальная переменная задаваемого числа вопросов
	private static int[] userAnswers = new int[questionUserCount]; //ответы участника
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

class Person {
    private String userName;
    private int userGrade;

    public Person(String userName) {
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