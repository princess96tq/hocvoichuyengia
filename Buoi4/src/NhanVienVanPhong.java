import java.util.Scanner;

public class NhanVienVanPhong extends NhanVien{
    private float heSoLuong;

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public NhanVienVanPhong() {
    }

    public NhanVienVanPhong(int maNV) {
        super(maNV);
    }

    public NhanVienVanPhong(int maNV, String tenNV, GioiTinh gioiTinh, Float luong, ChucVu chucVu, float heSoLuong) {
        super(maNV, tenNV, gioiTinh, luong, chucVu);
        this.heSoLuong = heSoLuong;
    }

    @Override
    public void nhapTT() {
        super.nhapTT();
        setChucVu(ChucVu.NHAN_VIEN_VP);
        System.out.println("Nhap he so luong: ");
        heSoLuong = new Scanner(System.in).nextFloat();
    }

    @Override
    public void hienTT() {
        super.hienTT();
        System.out.println("  "+ getChucVu() + "   Thu nhap: "+thuNhap());
    }

    @Override
    public float thuNhap() {
        return getLuong()+heSoLuong*getLuong();
    }
}
