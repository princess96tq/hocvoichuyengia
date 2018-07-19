package Buoi3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            showMenu();
        }
    }

    private static void showMenu() {
        System.out.println("Learning JAVA");
        System.out.println("----------------------------------------------------------");
        System.out.println("1.  Nhập danh sách nhân viên.");
        System.out.println("2.  Hiện nhân viên đã có trong hệ thống.");
        System.out.println("3.  Tìm nhân viên theo  giới tính và sắp xếp kết quả theo tên nhân viên. ");
        System.out.println("4.  Thoát ");
        System.out.println("Your choice (1-4), other to quit):");
        Scanner sc=new Scanner(System.in);
        String chon=sc.nextLine();

        switch(chon){
            case"1":
//              QuanLiNV quanLiNV=new QuanLiNV();
//              quanLiNV.nhapThongTin();
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
}
