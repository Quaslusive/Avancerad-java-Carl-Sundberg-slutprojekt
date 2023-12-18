import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class API {

    public HttpURLConnection getConn() {


        try {
            URL url = new URL("api.nasa.gov/insight_weather/?api_key=mSVIr9rR4Ll0ULABxITnZbFnJkWeNJqkGoQgXS0H&feedtype=json&ver=1.0\n");

            HttpURLConnection conn = null;

            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();


            //Check if connect is made
            int responseCode = 0;
            try {
                responseCode = conn.getResponseCode();

                // 200 OK
                if (responseCode != 200) {
                    throw new RuntimeException("HttpResponseCode: " + responseCode);
                } else {

                    StringBuilder informationString = new StringBuilder();
                    Scanner scanner = null;
                    try {
                        scanner = new Scanner(url.openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    while (scanner.hasNext()) {
                        informationString.append(scanner.nextLine());
                    }
                    //Close the scanner
                    scanner.close();

                    System.out.println(informationString);
                }
            } finally {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}

