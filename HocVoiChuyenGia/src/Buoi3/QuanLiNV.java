package Buoi3;

import java.util.ArrayList;
import java.util.List;

public class QuanLiNV {
    List<NhanVien> list = new ArrayList<>();
    public QuanLiNV() {
    }

    public void nhapThongTin() {
        NhanVien nhanVien = new NhanVien(1,"a",GioiTinh.NAM);
        nhanVien.nhapTT();
    }
}
