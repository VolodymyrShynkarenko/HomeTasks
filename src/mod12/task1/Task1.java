package mod12.task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task1 {

    public static void main(String[] args) {

  ScheduledExecutorService OutEveryOneS = Executors.newScheduledThreadPool(1);
        Runnable task1 = new Runnable() {
            int count = 0;
            public void run() {
                System.out.println("Минуло " + ++count + " секунд");
            }
        };
        OutEveryOneS.scheduleAtFixedRate(task1, 0, 1, TimeUnit.SECONDS);


        ScheduledExecutorService OutEveryFiveS = Executors.newScheduledThreadPool(1);
        Runnable task2 = new Runnable() {
            int count = 0;
            public void run() {

                System.out.println("Минуло 5 секунд");
            }
        };
        OutEveryFiveS.scheduleAtFixedRate(task2, 4, 5, TimeUnit.SECONDS);
    }
}