import java.util.Arrays;

class Question {
	//todo Плохая идея ссылаться на константу лучше использовать ее напрямую - ясно, перемудрил
	private static String[] textsOfQuestions = new String[Quiz2.QUESTION_ALL]; //тексты самих вопросов
	private static int[] correctAnswers = new int[]{3, 3, 2, 2, 4, 1, 1, 4, 3, 4}; //номера правильных ответов
	private static int counter = 0; //счетчик вопросов для неповторяемости
	static int[] indexOfUsedQuestions = new int[Quiz2.QUESTION_ALL]; //для хранения последовательности задавания вопросов
	private static boolean[] flagUsedQuestions = new boolean[Quiz2.QUESTION_ALL]; //флаги задавания вопросов

	static {
		textsOfQuestions[0] = "Как звали собаку Павлова? 1. Тузик 2. Шарик 3. Рыжик 4. Бобик.";
		textsOfQuestions[1] = "Какая кислота образует ацетаты? 1.Лимонная 2. Аспириновая 3. Уксусная 4. Содовая";
		textsOfQuestions[2] = "Какого цвета питахайя? 1. Бирюзовая. 2. Розовая. 3. Голубая. 4. Фиолетовая.";
		textsOfQuestions[3] = "Какое растение существует на самом деле? 1. Лох чилийский 2. Лох индийский 3. Лох греческий 4. Лох русский";
		textsOfQuestions[4] = "Как называется ближайшая к Земле звезда? 1. Проксиома Центавра 2. Сириус 3. Полярная 4. Солнце";
		textsOfQuestions[5] = "Что помогает запомнить мнемоническое правило «Это я знаю и помню прекрасно»? 1. Число Пи 2.Ряд активности металлов 3.Цвета радуги 4.Порядок падежей";
		textsOfQuestions[6] = "Какую площадь имеет клетка стандартной школьной тетради? 1. 0,25 кв.см 2. 1 кв.см 3. 0,5 кв.см 4. 1,25 кв. см";
		textsOfQuestions[7] = "На каком озере дует ветер баргузин? 1. Каспий 2. Ладога 3. Арал 4. Байкал";
		textsOfQuestions[8] = "В каком жанре не сочинял Винни-Пух? 1. Пыхтелки 2. Шумелки 3. Ревелки 4. Сопелки";
		textsOfQuestions[9] = "Какого вида акул не существует? 1. Лимонная 2. Кошачья 3. Тигровая 4. Чёрная";
	}
	
	//возврат случайного вопроса без повторения
	public static String getRandomQuestion() {
		while (true) {
			var numberOfQuestion = (int) (Math.random() * Quiz2.QUESTION_ALL);
			if (!flagUsedQuestions[numberOfQuestion]) { //тут я спецом написал, чтобы было явно видно условие, опять же как ньюфаг
				indexOfUsedQuestions[counter] = numberOfQuestion;
				flagUsedQuestions[numberOfQuestion] = true;
				counter++;
				return textsOfQuestions[numberOfQuestion];
			}
		}
	}
	public static int getCorrectAnswer(int numberOfQuestion) {
		return correctAnswers[numberOfQuestion];
	}
	
	public static void resetQuestions() {
		counter = 0;
		//todo можно вот так. Это новые свистелки современной джавы - збс!
		Arrays.fill(flagUsedQuestions, false);
	}
}