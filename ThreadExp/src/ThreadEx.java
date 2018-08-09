import java.util.Random;

public class ThreadEx implements Runnable{
    private String threadName;
    private Thread t;
    private int tmp;
    ThreadEx(String threadName) {
        Random rd = new Random(101);
        this.tmp = rd.nextInt();
    }

    @Override
    public void run() {
        System.out.println("Giá trị thread " + threadName+" là: "+this.tmp);
    }
}
