public class Main {
    public static void main(String[] args) {
        ThreadEx a = new ThreadEx("Số thứ nhất");
        a.start();
        ThreadEx b = new ThreadEx("Số thứ hai");
        b.start();
    }
}
