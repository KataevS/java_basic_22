import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;

public class TaskSort {
	public static void main(String[] args) {
		List<Integer> unsortedList = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		
		// заполнение массива
		for (int i=0; i < 12; i++){
			unsortedList.add( (int)(Math.random() * 100 - 50));
		}
		printList(unsortedList, "Исходный массив");
		var date1 = new Date(); //время перед сортировками
						
	//	sortedList = sortInsert(unsortedList);
		//printList(sortedList, "Сортировка выбором");
	//	var date2 = new Date();
	//	System.out.println(date2.getTime()- date1.getTime());
	//sortedList = sortShell(unsortedList);

	//	sortedList = sortBubble(unsortedList);
		//printList(sortedList, "Сортировка пузырьком");
	//	var date3 = new Date();
	//	System.out.println(date3.getTime()- date2.getTime());
		
	//	Collections.sort(unsortedList);
		//printList(unsortedList, "Быстрая сортировка");
	//	var date4 = new Date();
		//System.out.println(date3);
		
	//	System.out.println(date4.getTime()- date3.getTime());
		
	}

	//сортировка вставкой
	private static List<Integer> sortInsert(List<Integer> list) {
		int turn = 1;
		for (int i=0; i < list.size()-1; i++){ //просматриваем массив с начала до предпоследнего элемента
			int min_index = i; //считаем, что первый элемент минимален
			int min_value = list.get(i);//значение стартового элемента принимаем минимальным
			for (int j=i+1; j<list.size(); j++){ //просматриваем массив со следующего элемента до конца
				if ( list.get(j) < min_value ){ //ищем минимальный элемент массива 
					min_value = list.get(j); //запоминаем значение минимального элемента
					min_index=j; //запоминаем индекс минимального элемента
					}
			}
			list.set(min_index, list.get(i)); //помещаем минимальный элемент в начало массива
			list.set(i, min_value);
			printList(list, "шаг " + turn);
			turn++;
		}
		return list;
	}
	
	//сортировка Шелла
	private static List<Integer> sortShell(List<Integer> list) {
		//int turn = 1;
		for (int d = list.size()/2; d >0 ; d/=2){ //последовательно дробим массив на мелкие куски 
			for (int i = d; i<list.size(); i++){ //перебираем полученные части массива
				for (int j = i-d; j>=0;j-=d ){ //сортируем части массива
					if (list.get(j) > list.get(j+d)){
						int temp = list.get(j);
						list.set(j, list.get(j+d));
						list.set(j+d, temp);
					}
				}
			}		
			//printList(list, "шаг " + turn);
			//turn++;
		}
		
		return list;
	}
	//сортировка пузырьком
	private static List<Integer> sortBubble(List<Integer> list) {
		int step = 1;
		for (int i = list.size()-1; i > 0; i--){ //просматриваем массив от предпоследнего элемента к первому
			for (int j = 0; j < i; j++) { //просматриваем массив от начала до предпоследнего элемента
				if ( list.get(j+1) < list.get(j)){ //если следующий элемент меньше предыдущего, меняем их местами
					int temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}

			printList(list, "шаг " + i);
			step++;
		}
		return list;
	}

	//сортировка расчёской
	private static List<Integer> sortComb(List<Integer> list) {
		int step = 1;
		
		return list;
	}

	//вывод массива	
	private static void printList(List<Integer> list, String name) {
		System.out.println(name);
		for ( Object item : list ) { 
            System.out.print( item + " " );
        }
		System.out.println();
	}
}