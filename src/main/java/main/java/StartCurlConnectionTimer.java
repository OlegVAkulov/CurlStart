package main.java;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class StartCurlConnectionTimer extends TimerTask {


    @Override
    public void run() {
        URL urlMail = null;
        URL urlTelegram = null;
        try {
            urlMail = new URL("http://35.203.40.103:8080/mail/run");
            urlTelegram = new URL("http://34.82.215.213:8080/telegram/run?command=create_pdf");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            new main.java.Curl(urlMail);
            new main.java.Curl(urlTelegram);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void runTimer() {
        Calendar startDataTime = Calendar.getInstance();
        startDataTime.set(2022, 1, 21, 17, 29);
        Calendar currentTime = Calendar.getInstance();
        Date date = new Date();
        TimerTask timerTask = new StartCurlConnectionTimer();
        Timer timer = new Timer();
        if (currentTime.getTime().compareTo(startDataTime.getTime()) < 0) {
            startDataTime.set(2022, date.getMonth(), date.getDay(), 17, 29);
        }
        timer.scheduleAtFixedRate(timerTask, startDataTime.getTimeInMillis() - currentTime.getTimeInMillis(), 24 * 60 * 60 * 1000);
    }
}



