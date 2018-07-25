import java.util.Scanner;

public class QuanLy extends NhanVien {
    private int soNhanVien;
    private int phuCap;

    public QuanLy() {
    }

    public QuanLy(int maNV) {
        super(maNV);
    }

    public QuanLy(int maNV, String tenNV, GioiTinh gioiTinh, Float luong,ChucVu chucVu, int soNhanVien, int phuCap) {
        super(maNV, tenNV, gioiTinh, luong, chucVu);
        this.soNhanVien = soNhanVien;
        this.phuCap = phuCap;
    }

    public int getSoNhanVien() {
        return soNhanVien;
    }

    public void setSoNhanVien(int soNhanVien) {
        this.soNhanVien = soNhanVien;
    }

    public int getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(int phuCap) {
        this.phuCap = phuCap;
    }

    @Override
    public void nhapTT() {
        super.nhapTT();
        setChucVu(ChucVu.QUAN_LY);
        System.out.println("Nhap so nhan vien: ");
        soNhanVien = new Scanner(System.in).nextInt();
    }

    @Override
    public void hienTT() {
        super.hienTT();
        System.out.println("  "+ getChucVu() + "   Thu nhap: "+thuNhap());
    }

    @Override
    public float thuNhap() {
        if (soNhanVien <10){
            phuCap = 500;
        } else if ((soNhanVien >20)){
            phuCap = 2000;
        } else {
            phuCap = 1000;
        }
        setLuong(getLuong()+phuCap);
        return getLuong()+phuCap;
    }
}
