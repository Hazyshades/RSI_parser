import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws IOException {

        long timeIntervalForTaskOne = 6*1000;
        int delaySeconds = 1*1000;//6 seconds
        // creating timertask, timer
        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {

            Calendar runningTime = Calendar.getInstance();

            public void run() {
                System.out.println(runningTime.getTime() + "working on the task");


                    }

        };
        timer.scheduleAtFixedRate(tt, delaySeconds,timeIntervalForTaskOne);
    }

}