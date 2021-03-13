import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService {
    public static void main(String[] args) throws InterruptedException {
        Calendar today = Calendar.getInstance();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    Main.go();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
//        timer.schedule(task, today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // period: 1 day
        timer.schedule(task, today.getTime(), TimeUnit.MILLISECONDS.convert(28800, TimeUnit.SECONDS)); // period: 5 seconds
    }
}
