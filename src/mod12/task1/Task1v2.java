package mod12.task1;



public class Task1v2 extends Thread{
    static Task1v2v1 mAnotherOpinion;

    public static void main(String[] args) {
        mAnotherOpinion = new Task1v2v1();
        System.out.println("Старт відліку");
        mAnotherOpinion.start();
        int count = 0;
        for (int i = 0; i < 100; i++) {
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println("Час " + count);
        }
    }
}