import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class API {

    private static HttpURLConnection connection;
    BufferedReader reader;
    String line;
    StringBuffer responseContent = new StringBuffer();

    {
        URL url = null;
        try {
            url = new URL("https://api.nasa.gov/insight_weather/?api_key=mSVIr9rR4Ll0ULABxITnZbFnJkWeNJqkGoQgXS0H&feedtype=json&ver=1.0\n");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }

        int status = 0;
        try {
            status = connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (status > 299) {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            while (true) {
                try {
                    if ((line = reader.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                responseContent.append(line);
            }
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                try {
                    if ((line = reader.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                responseContent.append(line);
            }

            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(responseContent.toString());
        connection.disconnect();

        /*
        public static String parse (String responsBody){
        JSONArray dataCollection = new JSONArray(responsBody);
        for (int i = 0; i < dataCollection.length(); i++) {
            JSONObject data = dataCollection.getJSONObject(i);
            int sol_keys = data.getInt("sol");
            int AT = data.getInt("atmosphericTemperature");
            int HWS = data.getInt("horizontal wind speed");
            int PRE = data.getInt("atmospheric Pressure");
            int WD =  data.getInt("wind direction");
            int sols_checked = data.getInt("current sol");


            String Season = data.getString("Sol season on Mars");
        }
        return null;

         */
    }
}