import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;

public class TaskSort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i=0; i < 10; i++){
			list.add( (int)(Math.random() * 10));
		}
		/*for ( Object item : list ) { 
            System.out.println( item );
        }
		*/
		
		var date1 = new Date();
				
		//System.out.println(date1.getTime());
		
		Collections.sort(list);
		
		var date2 = new Date();
				
		System.out.println(date2.getTime()-date1.getTime());
		
	}
}