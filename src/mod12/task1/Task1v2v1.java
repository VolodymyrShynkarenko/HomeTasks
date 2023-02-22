package mod12.task1;

import static java.lang.Thread.sleep;

public class Task1v2v1 extends Thread {
    @Override
    public void run() {

        int count = 0;
        for (int i = 0; i < 100; i++) {
            count++;
            if (count % 5 == 0) {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                }

                System.out.println("пройшло 5c");
            }
        }
    }
}
