import java.util.Random;

public class ThreadB extends Thread {
    public int RandomB(){
        Random rdB = new Random();
        int tmpb = rdB.nextInt(101);
        System.out.println("Số b là "+ tmpb);
        return tmpb;
    }
}
