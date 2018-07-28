package Interface;

import NhanVien.QuanLyNhanVien;


public interface IMain {
    default void showMenu(IQuanLyNhanVien QuanLyNhanVien ){
        System.out.println("===========================================================");
        System.out.println("                       Learning JAVA");
        System.out.println("----------------------------------------------------------");
        System.out.println("1.  Nhập danh sách nhân viên.");
        System.out.println("2.  Hiện nhân viên đã có trong hệ thống.");
        System.out.println("3.  Tìm nhân viên có thu nhập cao nhất  ");
        System.out.println("4.  Thoát ");
        System.out.println("Your choice (1-4), other to quit):");
        System.out.println("===========================================================");
    }
    };

