package mod12.task2;

public class FizzBuzzer implements Runnable {
    int n;

    public FizzBuzzer(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzbuzz");
            }
        }
    }
}