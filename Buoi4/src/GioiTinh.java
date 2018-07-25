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

    }
