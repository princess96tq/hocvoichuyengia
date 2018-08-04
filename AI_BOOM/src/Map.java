import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * Created by Heart Of Dead on 23-Feb-17.
 */
public class Map {
    int x;
    int y;
    int bit;


    int value;//Chi phi di tu điểm xuất phát
    boolean check;//Kiểm tra map đã được duyệt qua chưa, khởi tạo là false trong thuat toan A*
    boolean checkBFS;
    Map parent;
    Map parentBFS;
    Map left;
    Map right;
    Map up;
    Map down;
    Image[] images = {
            new ImageIcon(getClass().getResource("/image/1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/5.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/6.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/7.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/8.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/9.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/10.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/11.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/12.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/13.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/14.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/15.png")).getImage()


    };

    // gia tri cua map bang 63 khi vi tri day map la vat can
    public Map(int x, int y, int bit) {

        this.x = x;
        this.y = y;
        this.bit = bit;

        setdefaultA();

    }

    public void setdefaultA() {
        if (this.bit != 0) this.value = 10001;
        else this.value = 1;
        check = false;
        parent = null;

    }

    public void setdefaultBFS() {
        checkBFS = false;
        parentBFS = null;
    }

    void draw(Graphics2D g2d) {
        if (bit > 0) {
            g2d.drawImage(images[bit - 1], x, y, 52, 52, null);
//        g2d.drawImage(images[bit-1],this.x,this.y,null);
        }
    }

    Rectangle getRect() {
        if (bit == 0) {
            return new Rectangle();
        }
        Rectangle rectangle = new Rectangle(x, y, 52, 52);
//                new Rectangle(x,y,images[bit-1].getWidth(null),images[bit-1].getHeight(null));
        return rectangle;
    }
    //Tra ve true neu vat the k va cham vs map
//    public boolean vacham(int xtmp,int ytmp){
//        if (bit!=0){
//            if(x>xtmp && x-xtmp<52) return false;
//            if (x<xtmp && xtmp-x<52) return  false;
//            if(y>ytmp && y-ytmp<52) return false;
//            if(y<ytmp && ytmp-y<52) return false;
//            return true;}
//        return true;
//    }

    public void setLeft(Map left) {
        this.left = left;
    }

    public void setRight(Map right) {
        this.right = right;
    }

    public void setUp(Map up) {
        this.up = up;
    }

    public void setDown(Map down) {
        this.down = down;
    }
}