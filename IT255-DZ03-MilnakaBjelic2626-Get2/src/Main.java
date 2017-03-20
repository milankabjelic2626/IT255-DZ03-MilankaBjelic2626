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

            URL url = new URL("http://services.groupkt.com/country/get/all");
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
                System.out.println("name: " + urlone.getName());
                System.out.println("alpha_code2: " + urlone.getAlpha2_code());
                System.out.println("alpha_code3: " + urlone.getAlpha3_code());
                System.out.println("\n");
            }
            
        } catch (MalformedURLException ex) {

        } catch (IOException e) {

        }
    }

}
