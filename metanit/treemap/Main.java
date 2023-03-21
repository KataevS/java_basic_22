
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Comparator<Person> pcomp = new PersonNameComparator().thenComparing(new PersonAgeComparator());
        TreeSet<Person> people = new TreeSet<>(pcomp);
        people.add(new Person("Tom", 18));
        people.add(new Person("Nick", 20));
        people.add(new Person("Tom", 14));
        people.add(new Person("Bill", 22));
        for(Person  p : people){

            System.out.printf("Name: %s  Age: %d  \n",p.getName(), p.getAge());
        }
    }
}
