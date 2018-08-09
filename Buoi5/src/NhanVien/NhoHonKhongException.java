package NhanVien;

public class NhoHonKhongException extends Exception {
    @Override
    public String getMessage() {
        return "input không được nhỏ hơn 0" +super.getMessage();
    }
}
