import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfQuestions = 3;
        //int numberOfAnswers = 4;
        String[] questions = new String[numberOfQuestions];
        questions[0] = ("Сколько у Марса спутников?");
        questions[1] = ("Сколько планет в Солнечной системе?");
        questions[2] = ("Сколько океанов на Земле?");

        String[][] answersText = {
        {"Ни одного", "Один", "Два","Пять"},
        {"Четыре","Восемь","Девять"},
        {"Три","Пять","Шесть","Их нет"}
        };
        int answersAll = 0;
        int[] answersCorrect = {3,2,2};
        System.out.println("Система тестирования.");
        System.out.println("Ответьте на три вопроса. Выберите один вариант ответа.");
        for (int i=0; i<numberOfQuestions; i++ ){
            System.out.println(questions[i]);
            for (int j=0; j<answersText[i].length; j++) {
                System.out.println(j+1 + ". " + answersText[i][j]);
            }
            int answer = scanner.nextInt();
            if (answer == answersCorrect[i]) {
                answersAll++;
            }
        }
        System.out.println("У вас " + answersAll + " правильных ответа/ов.");
        switch (answersAll) {
            case 3:
                System.out.println("Отлично!");
                break;
            case 2:
                System.out.println("Оценка 4!");
                break;
            default:
                System.out.println("Двоечник!");
        }
        scanner.close();
    }
}