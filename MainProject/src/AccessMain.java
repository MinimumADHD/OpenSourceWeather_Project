import com.google.gson.Gson;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
                    System.out.println("Confirmed. Wait 5 seconds for your API Key to load (In case it's located in a 2nd binary file, like mine.)");
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
    static String CaptureWeather(String ParamCity, String ParamApiKey)
    {
        String UniformResourceLocator = "http://dataservice.accuweather.com/currentconditions/v1/"+ParamCity+"?apikey="+ParamApiKey;
        String ApiResponse = GetRequest(UniformResourceLocator);
        return null;
    }
    static String GetRequest(String ParamURL)
    {
        try {
            URL UrlLib = new URL(ParamURL);
            HttpURLConnection conn = (HttpURLConnection) UrlLib.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept-Language", "en-US");
            int ApiResponseCode = conn.getResponseCode();
            if (ApiResponseCode == 200)
            {
                BufferedReader JReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder ApiCResponse = new StringBuilder();
                String line;
                while ((line = JReader.readLine()) != null)
                {
                    ApiCResponse.append(line);
                }
                JReader.close();
                return ApiCResponse.toString();
            }
            else
            {
                return "Error: received response code " + ApiResponseCode;
            }
        }
        catch (Exception GeneralError)
        {
            return "Error: " + GeneralError.getMessage();
        }
    }
}
class WeatherDataClass
{
    String TemperatureUnit;
    String WeatherString;
}