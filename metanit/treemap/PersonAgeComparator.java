package metanit;
import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {
    public int compare(Person a, Person b){

        return (a.getAge()-b.getAge());

    }
}
