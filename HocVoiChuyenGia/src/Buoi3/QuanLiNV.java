package Buoi3;

import java.util.*;

public class QuanLiNV {
    List<NhanVien> list = new ArrayList<>();
    NhanVien nhanVien;
    ArrayList<NhanVien> danhSach = new ArrayList();
    public QuanLiNV() {
    }
    public void nhapThongTin() {
        System.out.println("Nhập vào số nhân viên muốn thêm: ");
        int n = new Scanner(System.in).nextInt();
        for (int i = n; i >0 ; i--) {
            if(list.size()>0) {
                nhanVien = new NhanVien(list.get(list.size() - 1).getMaNV() + 1);
            }else {
                nhanVien = new NhanVien(1);
            }
            nhanVien.nhapTT();
            list.add(nhanVien);
        }
        System.out.println();
    }

    public void hienThongTin() {
        System.out.println("Danh sách nhân viên công ty HVAT");
        System.out.println("===========================================================");
        System.out.println(" Mã nhân viên ||" + "   Họ và tên   ||" + " Giới tính ");
        for (NhanVien nhanVien : list){
            nhanVien.hienTT();
        }

    }
    public void sapXep(){
        Collections.sort(danhSach, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nhanVien1, NhanVien nhanVien2) {
                return (nhanVien1.getTenNV().compareTo(nhanVien2.getTenNV()));
            }
        });

        System.out.println("Danh sách sắp xếp theo tên: ");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println("Tên: " + danhSach.get(i).getTenNV() + " Giới tính: " + danhSach.get(i).getGioiTinh());
        }

    }

    public void timNhanVien() {
        System.out.println("Tìm nhân viên theo giới tình nào?????");
        System.out.println("Chọn 1 nếu là Nam, 0 là Nữ, -1 nếu không xác định ");
        Scanner sc=new Scanner(System.in);
        String chon=sc.nextLine();
        switch(chon){
            case"1":
                for (NhanVien nhanVien : list) {
                    if (nhanVien.getGioiTinh() == GioiTinh.NAM) {
                        danhSach.add(nhanVien);
                    }
                    sapXep();
                }

                break;
            case "2":
                for (NhanVien nhanVien : list) {
                    if (nhanVien.getGioiTinh() == GioiTinh.NU) {
                        danhSach.add(nhanVien);
                    }
                    sapXep();
                }

                break;
            case "3":
                break;

        }
    }
}
