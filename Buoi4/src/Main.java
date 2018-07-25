import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        QuanLyNhanVien quanLiNV=new QuanLyNhanVien();
        while (true){
            showMenu(quanLiNV);
        }
    }

    private static void showMenu(QuanLyNhanVien quanLiNV) {
        System.out.println("===========================================================");
        System.out.println("                       Learning JAVA");
        System.out.println("----------------------------------------------------------");
        System.out.println("1.  Nhập danh sách nhân viên.");
        System.out.println("2.  Hiện nhân viên đã có trong hệ thống.");
        System.out.println("3.  Tìm nhân viên có thu nhập cao nhất  ");
        System.out.println("4.  Thoát ");
        System.out.println("Your choice (1-4), other to quit):");
        System.out.println("===========================================================");
        Scanner sc=new Scanner(System.in);
        String chon=sc.nextLine();

        switch(chon){
            case"1":
                quanLiNV.nhapThongTin();
                break;
            case "2":
                quanLiNV.hienThongTin();
                break;
            case "3":
                quanLiNV.timNhanVien();
                break;
            case "4":
                System.out.println("Xin chân thành cảm ơn");
                System.exit(0);
                break;
            default:
                System.out.println("Xin chân thành cảm ơn");
                System.exit(0);
                break;

        }
    }
}