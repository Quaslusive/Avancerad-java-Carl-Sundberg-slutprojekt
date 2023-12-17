import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class API {

    // Create the URL for the HTTP GET request
        URL url = new URL("api.nasa.gov/insight_weather/?api_key=mSVIr9rR4Ll0ULABxITnZbFnJkWeNJqkGoQgXS0H&feedtype=json&ver=1.0\n");


    private HttpURLConnection connection;
    // Get the response code t.ex 400, 404, 200 är ok
    int responseCode = connection.getResponseCode();

    public API() throws IOException {
    }
}
