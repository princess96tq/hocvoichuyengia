package Buoi2;

public class Bai1 {
    public Bai1(){

    }
    private static Bai1 ex;
    public static Bai1 getInstance(){
        if (ex == null){
            ex = new Bai1();
        }
        return ex;
    }

    public static void main(String[] args) {
        System.out.println(Bai1.getInstance());
    }
}
