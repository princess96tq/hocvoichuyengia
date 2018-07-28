package NhanVien;

import Interface.IMain;

import java.util.Scanner;

public class Main implements IMain {
    @Override
    public static void showMenu(QuanLyNhanVien quanLiNV) {
        Scanner sc=new Scanner(System.in);
        String chon=sc.nextLine();
        switch(chon){
            case"1":
                quanLiNV.nhapThongTin();
                break;
            case "2":
                break;
            case "3":
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

    public static void main(String[] args) {
        QuanLyNhanVien quanLiNV=new QuanLyNhanVien();
        while (true){
            showMenu(quanLiNV);
        }
    }
}
