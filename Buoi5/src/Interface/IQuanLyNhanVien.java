package Interface;

import NhanVien.QuanLyNhanVien;

public interface IQuanLyNhanVien {
    default void nhapThongTin(){
        System.out.println("Mời chọn nhập loại nhân viên: ");
        System.out.println("1 - Quản lý");
        System.out.println("2 - Nhân viên văn phòng");
        System.out.println("3 - Công nhân");

    };
    void hienThongTin();
    void timNhanVien();
}
