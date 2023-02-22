package mod12.task2;

public class Fizz implements Runnable {
    int n;

    public Fizz(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i < n)
                if (i % 3 == 0) {
                    System.out.println("fizz");
                }
        }
    }
}