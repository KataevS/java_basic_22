import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;

public class TaskSort {
	public static void main(String[] args) {
		List<Integer> unsortedList = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		
		// заполнение массива
		for (int i=0; i < 10000; i++){
			unsortedList.add( (int)(Math.random() * 10000));
		}
		//printList(unsortedList, "Исходный массив");
		var date1 = new Date(); //время перед сортировками
						
		sortedList = sortInsert(unsortedList);
		//printList(sortedList, "Сортировка выбором");
		var date2 = new Date();
		System.out.println(date2.getTime()- date1.getTime());
		
		sortedList = sortBubble(unsortedList);
		//printList(sortedList, "Сортировка пузырьком");
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
		
		for (int i=0; i < list.size()-1; i++){
			int nmin = i;
			int min = list.get(i);
			for (int j=i+1; j<list.size(); j++){
				if ( min > list.get(j) ){
					min = list.get(j);
					nmin=j;
					}
			}
			list.set(nmin,list.get(i));
			list.set(i,min);
		}
		return list;
	}
	
	//сортировка пузырьком
	private static List<Integer> sortBubble(List<Integer> list) {
		
		for (int k = list.size()-1; k > 0; k--){
			for (int i = 0; i < k; i++) {
				if ( list.get(i) > list.get(i+1)){
					int temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
				}
			}
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