import java.util.Scanner;

public class CongNhan extends NhanVien {
    private int ngayCong;

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }

    public CongNhan() {
    }

    public CongNhan(int maNV) {
        super(maNV);
    }

    public CongNhan(int maNV, String tenNV, GioiTinh gioiTinh, Float luong, ChucVu chucVu, int ngayCong) {
        super(maNV, tenNV, gioiTinh, luong, chucVu);
        this.ngayCong = ngayCong;
    }

    @Override
    public void nhapTT() {
        super.nhapTT();
        setChucVu(ChucVu.CONG_NHAN);
        System.out.println("Nhap so ngay cong: ");
        ngayCong = new Scanner(System.in).nextInt();
    }

    @Override
    public void hienTT() {
        super.hienTT();
        System.out.println("  "+ getChucVu() + "   Thu nhap: "+thuNhap());
    }

    @Override
    public float thuNhap() {
        return getLuong()+ (ngayCong/26)*getLuong();
    }
}
