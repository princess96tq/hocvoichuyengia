package Buoi3;

import java.util.Scanner;

public enum GioiTinh {
    NAM(1), NU(0), KXD(-1);
    private int tmp;

    GioiTinh(int tmp) {
        this.tmp = tmp;
    }

    public int getTmp() {
        return tmp;
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }

    public void nhap() {
        System.out.print("Giới tính: 1= Nam, 0=Nữ, -1 = Không xác định");
        this.tmp = new Scanner(System.in).nextInt();
    }
}
