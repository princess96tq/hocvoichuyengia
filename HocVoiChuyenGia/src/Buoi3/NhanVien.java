package Buoi3;

import java.util.*;

public class NhanVien {
    private int maNV;
    private String tenNV;
    private GioiTinh gioiTinh;


    public int getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public NhanVien() {
    }

    public NhanVien(int maNV) {
        this.maNV = maNV;
    }

    public NhanVien(int maNV, String tenNV, GioiTinh gioiTinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
    }

    public void nhapTT() {
        System.out.println("            Mời nhập thông tin nhân viên");
        System.out.println("======================================================");
        System.out.println("Mã nhân viên sẽ tự sinh bởi hệ thống!");
        System.out.println("Họ tên: ");
        this.tenNV = new Scanner(System.in).nextLine();
        System.out.println("Nhập 1 nếu là Nam, 0 là Nữ, -1 nếu không xác định");
        int input = new Scanner(System.in).nextInt();
        if (input == 1) {
            gioiTinh = GioiTinh.NAM;
        }else if(input == 0){
            gioiTinh = GioiTinh.NU;
        }else {
            gioiTinh = GioiTinh.KXD;
        }
    }

    public void hienTT() {
        System.out.println("\t" + maNV + "\t||" + tenNV + "||" + gioiTinh);
    }

}
