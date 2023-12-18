import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {

    // Create the URL for the HTTP GET request
        URL url = new URL("api.nasa.gov/insight_weather/?api_key=mSVIr9rR4Ll0ULABxITnZbFnJkWeNJqkGoQgXS0H&feedtype=json&ver=1.0\n");


    private HttpURLConnection connection;
    int responseCode = connection.getResponseCode();

    public API(HttpURLConnection connection) throws IOException {

        this.connection = connection;
    }
}
