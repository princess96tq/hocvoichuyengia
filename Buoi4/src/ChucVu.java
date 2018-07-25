public enum ChucVu {
    QUAN_LY(1), NHAN_VIEN_VP(2), CONG_NHAN(3), KXD(4);
    private int tmp;

    ChucVu(int tmp) {
        this.tmp = tmp;
    }

    public int getTmp() {
        return tmp;
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }
}
