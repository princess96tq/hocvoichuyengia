import java.util.Scanner;

public class NhanVien {
    private int maNV;
    private String tenNV;
    private GioiTinh gioiTinh;
    private float luong;
    private ChucVu chucVu;

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

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

    public NhanVien(int maNV, String tenNV, GioiTinh gioiTinh, Float luong, ChucVu chucVu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.luong = luong;
        this.chucVu = chucVu;
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
        System.out.println("Nhap luong co ban: ");
        this.luong = new Scanner(System.in).nextFloat();
    }

    public void hienTT(){
        System.out.print("        " + maNV + "       " + tenNV + "       " + gioiTinh+"     ");
    }

    public float thuNhap(){
        return  luong;
    }

}

