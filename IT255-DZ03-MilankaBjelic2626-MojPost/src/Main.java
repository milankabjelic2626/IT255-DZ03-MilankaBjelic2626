import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main 
{
    public static void main(String[] args) 
    {
        new Main();
    }

    public Main() 
    {
        MojObjekat root = new MojObjekat();

        root.setName("Milanka Bjelic");
        root.setUsername("milankaMima");
        root.setEmail("milanka.bjelic.2626@metropolitan.ac.rs");
        root.setWebsite("www.nesto.rs");       

        try {
            URL url = new URL("http://jsonplaceholder.typicode.com/users");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);           

            PrintWriter pw = new PrintWriter(conn.getOutputStream());
            pw.print(new Gson().toJson(root));
            pw.close();
            pw.flush();
         
            StringBuffer response = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String inputLine;

            while ((inputLine = br.readLine()) != null) 
            {
                response.append(inputLine);
            }
            br.close();
            if (conn.getResponseCode() != 200 && conn.getResponseCode() != 201) 
            {
                throw new RuntimeException("HTTP Response Code: " + conn.getResponseCode());
            }
            conn.disconnect();
           System.out.println(response.toString());
        } catch (MalformedURLException exp) {

        } catch (IOException ex) {

        }
    }
}
