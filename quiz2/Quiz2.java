package quiz2;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.time.LocalDateTime;

public class Quiz2 {

    //todo:
    // 1. В современной джаве если вывод типа переменной очевиден, то можно писать слово var. Это не обызательно
    // но смотрится красиво и современно. Я пользуюсь. - подумал, что пока в учебных целях православнее будет указывать конкретный тип
    // 2. Чаще нажимай комбинацию Ctrl+Alt+L (Reformat code) - забудешь что такое выставление пробелов. Также рекомендую
    // поставить плагин Key Promoter X - помогает учить хоткеи. - в идее да, а в нотепаде увы, печально всё ((
    // 3. Не стоит писать классы в одном файле, джава это разрешает но стандартом считается 1 файл 1 класс.
    // лучше в таком случае создавать пакет и туда складывать файлы - принято, сознательно запихнул всё в один файл, опять же как ньюфаг.

    public static final int QUESTION_ALL = 10; //общее число вопросов
    public static final int QUESTION_SELECTED = 3; //число задаваемых вопросов

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.println("""
                Добро пожаловать в нашу викторину!
                Как всегда, вам нужно ответить на несколько вопросов.
                Для начала представьтесь, пожалуйста.""");
        var user = new Person(scanner.nextLine());
        System.out.println(showGreeting() + ", " + user.getUserName() + "!");
        System.out.println("""
                Я буду задавать вопросы, а вы - давать ответы.
                Потом я скажу, сколько правильных ответов вы дали и выставлю оценку.
                Итак, поехали!""");
        while (true) {
            animateChar('*', 50);
            for (int i = 0; i < QUESTION_SELECTED; i++) {
                System.out.println(Question.getRandomQuestion());
                Answer.saveUserAnswer(scanner.nextInt());
                System.out.println("Ответ принят.");
            }
            System.out.println(user.getUserName() + ", викторина завершена.");
            animateChar('$', 50);
            System.out.println("Ваш результат: " + user.calculateUserGrade() + " из " + QUESTION_SELECTED);
            System.out.println("Ещё хотите попробовать? y/n");
            char userChoose = scanner.next().charAt(0);
            if (userChoose == 'n' || userChoose == 'N') {
                break;
            } else {
                Question.resetQuestions();
                Answer.resetAnswers();
                user.resetUserGrade();
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
        //todo: Все нижеописанное можно упростить используя LocalDateTime.now().getHour() - fixed
        // var hour = LocalDateTime.now().getHour();
        var textGreeting = "";
        //var dateNow = new Date();
        //var hourCurrent = new SimpleDateFormat("kk");
        //var hourInteger = Integer.parseInt(hourCurrent.format(dateNow));
        var hourInteger = LocalDateTime.now().getHour();
        // тут идейка подсказывает, что можно упростить условие - тоже перемудрил
        if (hourInteger <= 6) {
            textGreeting = "Добрая ночь";
        } else if (hourInteger <= 10) {
            textGreeting = "Доброе утро";
        } else if (hourInteger <= 19) {
            textGreeting = "Добрый день";
        } else {
            textGreeting = "Добрый вечер";
        }
        return textGreeting;
    }
}