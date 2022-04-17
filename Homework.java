import java.util.Base64;
import java.util.Scanner;
public class Homework{
//комментарий	
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your full name");
        String fullName = scanner.nextLine();
        String encodedFullName = Base64.getEncoder().encodeToString(fullName.getBytes());
        System.out.println("Program result: " + encodedFullName);
    }
}
