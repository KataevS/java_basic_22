import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Quiz2 {
    public static final int QUESTION_COUNT = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Добро пожаловать в нашу викторину!
                Как всегда, вам нужно ответить на несколько вопросов.
                Для начала представьтесь, пожалуйста.
                """);
        Person user = new Person(scanner.nextLine());
        System.out.println(DaytimeGreeting.getTextGreeting() + ", " + user.getUserName() + "!");
        System.out.println("""
                              Я буду задавать вопросы, а вы давать ответы.
                              Потом я скажу, сколько правильных ответов вы дали и выставлю оценку.
                              Итак, поехали!""");
        animateChar('*', 100);
        Question.getTextOfQuestion(1);

    }
    static void animateChar(char symbolToAnimate, int delayMillisecond) {
        final int SYMBOL_COUNT = 10;
        //this.symbolToAnimate = symbolToAnimate;
        //this.delayMilliSecond = delayMillisecond;
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
}

class Person {
    private String userName;
    private int userRating;

    public Person(String userName) {
        this.userName = userName;
        this.userRating = 0;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public int getUserRating() {
        return userRating;
    }
}

class DaytimeGreeting {
    public static String getTextGreeting() {
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
    static int questionCount = Quiz2.QUESTION_COUNT;
    private static int[] usedQuestions = new int[questionCount];;

    private static String[] textsOfQuestion = new String[questionCount];

    private String[] textsOfAnswers = new String[questionCount];
    private int[] correctAnswers = new int[questionCount];
    //public void main (){
        textsOfQuestion[].String[1] = "Первый вопрос";
    //return;
//}
    public static String getTextOfQuestion(int numberOfQuestion) {
        usedQuestions[numberOfQuestion] = 1;
        return textsOfQuestion[numberOfQuestion];
    }


}

class Answer {
    private int numberOfAnswer;
    private char letterOfAnswer;

}
