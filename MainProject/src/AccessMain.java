import com.google.gson.Gson;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// NOTE: Most of you won't read the license, so at the very least read that:
// GRANTS: Commercial Use, Modification, Distribution, Patent and Private use
// LIMITATIONS: As specified per license, I do not take any liability on any possible damage for your computer, nor I take responsibility over any warranty request.
/*
CONDITIONS:
- You MUST include in your project my License and Copyright notice.
- You MUST state your changes applied to the licensed project towards the public.
- You MUST credit the GitHub page where you found this code.
- You MUST apply the same license (GNU General Public License GPL v3.0) to your work.
 */

public class AccessMain
{
    static Scanner scanner = new Scanner(System.in);
    static String InsertedLocation;
    static String API_KEY = GitIgnoreClass.API_KEY;
    public static void main(String[] args) throws InterruptedException
    {
        String ChooseOption;
        while (true)
        {
            System.out.println("Insert your desired weather location; ");
            InsertedLocation = scanner.nextLine();
            System.out.println("Are you sure it's the right city? (YES/NO case sensitive)");
            ChooseOption = scanner.nextLine();
            switch (ChooseOption)
            {
                // Asks for confirmation, if yes, the while loops gets completly broken, if NO, it will ask again to re input the string.
                case "YES":
                {
                    System.out.println("Confirmed.");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("Working on API: "+API_KEY);
                    return;
                }
                case "NO":
                {
                    break;
                }
                default:
                {
                    System.out.println("Unknown Option, retry.");
                }
            }
        }
    }
}
