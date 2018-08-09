package NhanVien;

public class LuongException extends Exception {
    @Override
    public String getMessage() {
        return "Lương bị âm rồi kìa"+super.getMessage();
    }
}
