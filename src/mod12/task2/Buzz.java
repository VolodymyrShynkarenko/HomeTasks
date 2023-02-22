package mod12.task2;

public class Buzz implements Runnable {
    int n;

    public Buzz(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                System.out.println("buzz");
            }
        }
    }
}
