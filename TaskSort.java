import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;

public class TaskSort {
	public static void main(String[] args) {
		List<Integer> unsortedList = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		
		// заполнение массива
		for (int i=0; i < 20000; i++){
			unsortedList.add( (int)(Math.random() * 100000));
		}
		//printList(unsortedList, "Исходный массив");
		var date1 = new Date(); //время перед сортировками
						
		//	sortedList = sortInsert(unsortedList);
		//printList(sortedList, "Сортировка выбором");

		//	var date2 = new Date();
		//	System.out.println(date2.getTime()- date1.getTime());

		sortedList = sortShell(unsortedList);
		//printList(sortedList, "Сортировка Шелла");
		var date2 = new Date();
		System.out.println(date2.getTime()- date1.getTime());

		//	sortedList = sortBubble(unsortedList);
		//printList(sortedList, "Сортировка пузырьком");
	
		sortedList = sortComb(unsortedList);
		//printList(sortedList, "Сортировка расчёской");

		var date3 = new Date();
		System.out.println(date3.getTime()- date2.getTime());
		
		Collections.sort(unsortedList);
		//printList(unsortedList, "Быстрая сортировка");
		var date4 = new Date();
		//System.out.println(date3);
		
		System.out.println(date4.getTime()- date3.getTime());
		
	}

	//сортировка вставкой
	private static List<Integer> sortInsert(List<Integer> list) {
		int turn = 1;
		for (int i=0; i < list.size()-1; i++){ //просматриваем массив с начала до предпоследнего элемента
			int min_index = i; //считаем, что первый элемент минимален
			int min_value = list.get(i);//значение стартового элемента принимаем минимальным
			for (int j=i+1; j < list.size(); j++){ //просматриваем массив со следующего элемента до конца
				if ( list.get(j) < min_value ){ //ищем минимальный элемент массива 
					min_value = list.get(j); //запоминаем значение минимального элемента
					min_index = j; //запоминаем индекс минимального элемента
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
		for (int step = list.size()/2; step >0 ; step/=2){ //последовательно дробим массив пополам 
			for (int i = step; i < list.size(); i++){ //перебираем полученные части массива
				for (int j = i-step; j>=0; j-=step ){ //сортируем части массива
					if (list.get(j) > list.get(j+step)){ 
						int temp = list.get(j);
						list.set(j, list.get(j+step));
						list.set(j+step, temp);
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
		//int turn = 1;
		for (int i = 0; i < list.size()-1; i++){ //количество проходов по массиву - n-1
			for (int j = 0; j < i; j++) { //просматриваем неотсортированный кусок массива 
				if ( list.get(j+1) < list.get(j)){ //если следующий элемент меньше предыдущего, меняем их местами
					int temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
			//printList(list, "шаг " + turn);
			//turn++;
		}
		return list;
	}

	//сортировка расчёской
	private static List<Integer> sortComb(List<Integer> list) {
		//int turn = 1;
		float factor = 1.247F; //фактор уменьшения
		int step = list.size()-1; //начальный шаг сортировки
		for ( ; step > 0 ; ){ //цикл уменьшения шага сортировки
			for (int j=0; j+step < list.size(); j++) { //цикл прохода массива с заданным шагом
				if ( list.get(j) > list.get(j+step)) { //если следующий элемент меньше предыдущего, меняем их местами
					int temp = list.get(j);
					list.set(j, list.get(j + step));
					list.set(j + step, temp);
				}
			}
			step = (int)(step / factor); //уменьшение шага сортировки
			//printList(list, "шаг " + turn);
			//turn++;
		}	
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