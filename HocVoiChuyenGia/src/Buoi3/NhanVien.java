package Buoi3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVien {
    private int maNV =0;
    private String tenNV;
    private GioiTinh gioiTinh;
    public int getMaNV() {
        return maNV++;
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

    public NhanVien(int maNV, String tenNV, GioiTinh gioiTinh) {
        this.maNV = maNV++;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
    }
    public void nhapTT(){
        int tmp;
        System.out.println("            Mời nhập danh sách nhân viên");
        System.out.println("======================================================");
        System.out.print("              Số lượng nhân viên: ");
        tmp = new Scanner(System.in).nextInt();
        System.out.println(" Mã nhân viên ||" + "   Họ và tên   ||" + " Giới tính ");
        for (int i = this.maNV;i<tmp; i++){
            System.out.print(i+".");
            System.out.print("Họ tên: ");
            this.tenNV = new Scanner(System.in).nextLine();
            this.gioiTinh.nhap();
        }
    }
    public void hienTT(){
        System.out.println("Danh sách nhân viên công ty HVAT");
        System.out.println("===========================================================");
        System.out.println(" Mã nhân viên ||" + "   Họ và tên   ||" + " Giới tính ");
        System.out.println("  "+maNV+"    ||"+  tenNV + "||"+gioiTinh);

    }
}
