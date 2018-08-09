public class ThreadC extends Thread {
    public int Add(int a, int b){
        int tmpc = a+b;
        System.out.println("Tổng hai số là: "+tmpc);
        return tmpc;
    }
}
