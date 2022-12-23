import com.google.gson.Gson;
import java.util.Scanner;
public class AccessMain
{
    static Scanner scanner = new Scanner(System.in);
    static String InsertedLocation;
    static String API_KEY = GitIgnoreClass.API_KEY;
    public static void main(String[] args)
    {
        System.out.println("Insert your desired weather location; ");
        InsertedLocation = scanner.nextLine();
    }
}
