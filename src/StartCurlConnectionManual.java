import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class StartCurlConnectionManual {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) { //бесконечно крутим
                try {
                    URL urlMail = new URL("http://35.203.40.103:8080/mail/run");
                    URL urlTelegram = new URL("http://34.82.215.213:8080/telegram/run");
                    new Curl(urlTelegram);
                    new Curl(urlMail);
                    System.out.println("Lets go!");
                    Thread.sleep(24 * 60 * 60 * 1000 - 5000); // 1 сутки в милисекундах - 5 секунд на отправку
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}






