import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class Curl {

    Curl(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.getInputStream();
        connection.disconnect();
    }
}
