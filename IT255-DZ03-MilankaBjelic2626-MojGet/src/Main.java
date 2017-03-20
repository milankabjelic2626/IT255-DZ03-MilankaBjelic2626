import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main 
{

    public static void main(String[] args) 
    {
        new Main();
    }

    public Main() 
    {
        try {

            URL url = new URL("http://jsonplaceholder.typicode.com/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) 
            {
                throw new RuntimeException("Pokusaj je uspeo : HTTP error   : " + conn.getResponseCode());
            }
                
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String json = "";
            String output;

            while ((output = br.readLine()) != null) 
            {
                json += output;
            }

            conn.disconnect();
            Gson gson = new Gson();
            
            
            ArrayList<MojObjekat> lista = gson.fromJson(json, new TypeToken<ArrayList<MojObjekat>>() 
            {
            }.getType());
                        
            for (MojObjekat urlone : lista) 
            {
                System.out.println("ID: " + urlone.getId());
                System.out.println("Ime: " + urlone.getName());
                System.out.println("Username: " + urlone.getUsername());
                System.out.println("Email: " + urlone.getEmail());
                System.out.println("\n");
            }
            
        } catch (MalformedURLException ex) {

        } catch (IOException e) {

        }
    }

}
