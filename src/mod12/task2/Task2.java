package mod12.task2;

public class Task2 {

    public static void main(String[] args) {
        int n = 15;

        Thread fizz = new Thread(new Fizz(n));
        Thread buzz = new Thread(new Buzz(n));
        Thread fizzBuzzer = new Thread(new FizzBuzzer(n));
        Thread numberPrinter = new Thread(new NumberPrinter(n));

        fizz.start();
        buzz.start();
        fizzBuzzer.start();
        numberPrinter.start();
    }
}