import java.util.Random;

public class ThreadA extends Thread {
    public void RandomA(){
        Random rdA = new Random();
        int tmpa = rdA.nextInt(101);
        System.out.println("So a la " + tmpa);
    }
}
