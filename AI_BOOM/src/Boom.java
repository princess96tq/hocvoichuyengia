import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Princess on 23-Feb-17.
 */
public class Boom {
    int x;
    int y;
    int timeExplosion = 200;
    int index;
    int countDraw;
    Image image;
    Image[] arrImg = {
            new ImageIcon(getClass().getResource("/image/boom1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boom2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boom3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boom4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boom5.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boom6.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boom7.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boom8.png")).getImage(),
    };

    Image imgMid = new ImageIcon(getClass().getResource("/image/bombbang_mid_2.png")).getImage();
    Image imgLeft = new ImageIcon(getClass().getResource("/image/bombbang_left_1.png")).getImage();
    Image imgRight = new ImageIcon(getClass().getResource("/image/bombbang_right_1.png")).getImage();
    Image imgUp = new ImageIcon(getClass().getResource("/image/bombbang_up_1.png")).getImage();
    Image imgDown = new ImageIcon(getClass().getResource("/image/bombbang_down_1.png")).getImage();


    public Boom(int x, int y) {
        this.x = x;
//        this.x = x;
        //-arrImg[index].getWidth(null)/2;
        this.y = y;
        //-arrImg[index].getHeight(null)/2;
    }
//Đếm ngược thời gian nổ của boom
//Trong thoi gian nay boom se được thay đổi ảnh 10 lần

    public Image getImage() {
        if (countDraw > 10) {
            index++;
            if (index >= arrImg.length) {
                index = 0;
            }
            countDraw = 0;
        }
        return arrImg[index];
    }

    /*@return true nếu boom đã bị nổ

    *@retrun false nếu
* */
    public boolean draw(Graphics2D g2d) {
        timeExplosion--;
        // thoi gian cho boom no
        if (timeExplosion > 0) {
            //Đếm để thay đổi hình ảnh chờ của boom
            countDraw++;
            image = getImage();
            g2d.drawImage(image, x, y, 52, 52, null);
        }
        //0-30 tgian hien thi boom no
        else if (timeExplosion > -20) {
            Clip clip = AudioManager.getClip("bigexplode.wav");
            clip.start();
            g2d.drawImage(imgMid, x + 52, y, 52, 52, null);
            g2d.drawImage(imgLeft, x - 52, y, 52, 52, null);
            g2d.drawImage(imgRight, x, y, 52, 52, null);
            g2d.drawImage(imgUp, x, y - 52, 52, 52, null);
            g2d.drawImage(imgDown, x, y + 52, 52, 52, null);
//            g2d.drawImage(imgLeft, x-imgLeft.getWidth(null),y,52,52,null);
//            g2d.drawImage(imgRight, x+imgRight.getWidth(null),y,52,52,null);
//            g2d.drawImage(imgUp, x,y-imgUp.getHeight(null),52,52,null);
//            g2d.drawImage(imgDown, x,y+imgDown.getHeight(null),52,52,null);

        }
        //de xoa bom khoi mang

        else {
            return true;
        }
        return false;


    }

    Rectangle getRectMid() {
        Rectangle rect =
                new Rectangle(x, y, 52, 52);
//                new Rectangle(x,y,imgMid.getWidth(null),imgMid.getHeight(null));
        return rect;
    }

    Rectangle getRectLeft() {
        Rectangle rect =
                new Rectangle(x - 52, y, 52, 52);
//                new Rectangle(x-imgLeft.getWidth(null),y,imgLeft.getWidth(null),imgLeft.getHeight(null));
        return rect;
    }

    Rectangle getRectRight() {
        Rectangle rect =
                new Rectangle(x + 52, y, 52, 52);
//                new Rectangle(x+imgRight.getWidth(null),y,imgRight.getWidth(null),imgRight.getHeight(null));
        return rect;
    }

    Rectangle getRectUp() {
        Rectangle rect =
                new Rectangle(x, y - 52, 52, 52);
//                new Rectangle(x,y-imgUp.getHeight(null),imgUp.getWidth(null),imgUp.getHeight(null));
        return rect;
    }

    Rectangle getRectDown() {
        Rectangle rect =
                new Rectangle(x, y + 52, 52, 52);
//                new Rectangle(x,y+imgDown.getHeight(null),imgDown.getWidth(null),imgDown.getHeight(null));
        return rect;
    }

    //Kiem tra trang thai ket thuc game
    // ket thuc khi nguoi choi dinh boom
    boolean explosion(ArrayList<Map> arrMap, Player player, ArrayList<Boss> arrBoss, ArrayList<BossAI> arrBoss0, ArrayList<BossAI1> arrBoss1, ArrayList<BossAI2> arrBoss2, ArrayList<BossAI3> arrBoss3) {
        if (timeExplosion < 0) {
            //Kiem tra va vham vs map

            for (int i = arrMap.size() - 1; i >= 0; i--) {
                Rectangle rectMap = arrMap.get(i).getRect();
                boolean check = checkRect(rectMap);

                if (check == false && arrMap.get(i).bit != 7 && arrMap.get(i).bit != 9 &&
                        arrMap.get(i).bit != 10 && arrMap.get(i).bit != 11 && arrMap.get(i).bit != 12 && arrMap.get(i).bit != 13
                        && arrMap.get(i).bit != 14 && arrMap.get(i).bit != 15 && arrMap.get(i).bit != 0) {
                    arrMap.get(i).bit = 0;
                }
                //arrMap.get(i).value-=1000;

//                        arrMap.remove(i);


            }

            for (int i = arrBoss.size() - 1; i >= 0; i--) {
                Rectangle rectBoss = arrBoss.get(i).getRect();
                boolean check = checkRect(rectBoss);
                if (check == false) {

                    arrBoss.remove(i);
                }
            }
            for (int i = arrBoss0.size() - 1; i >= 0; i--) {
                Rectangle rectBoss = arrBoss0.get(i).getRect();
                boolean check = checkRect(rectBoss);
                if (check == false) {

                    arrBoss0.remove(i);
                }
            }
            for (int i = arrBoss1.size() - 1; i >= 0; i--) {
                Rectangle rectBoss = arrBoss1.get(i).getRect();
                boolean check = checkRect(rectBoss);
                if (check == false) {

                    arrBoss1.remove(i);
                }
            }
            for (int i = arrBoss2.size() - 1; i >= 0; i--) {
                Rectangle rectBoss = arrBoss2.get(i).getRect();
                boolean check = checkRect(rectBoss);
                if (check == false) {

                    arrBoss2.remove(i);
                }
            }
            for (int i = arrBoss3.size() - 1; i >= 0; i--) {
                Rectangle rectBoss = arrBoss3.get(i).getRect();
                boolean check = checkRect(rectBoss);
                if (check == false) {

                    arrBoss3.remove(i);
                }
            }

//            boolean checkboss1 = checkRect(boss1.getRect());
//            if(checkboss1==false){
//                boss1.check=false;
//            }
//            boolean checkboss2 = checkRect(boss2.getRect());
//            if(checkboss2==false){
//                boss2.check=false;
//            }
//
//            boolean checkboss=checkRect(boss.getRect());
//            if(checkboss==false) boss.check=false;
            return checkRect(player.getRect());
        }
        return true;
    }

    //kiem tra 1 doi tuong co nam trong pham vi no cua boom k
    /*@return false neu nam trong vung boom nổ
     */
    boolean checkRect(Rectangle rect) {
        Rectangle rL = getRectLeft().intersection(rect);
        Rectangle rR = getRectRight().intersection(rect);
        Rectangle rD = getRectDown().intersection(rect);
        Rectangle rU = getRectUp().intersection(rect);
        Rectangle rM = getRectMid().intersection(rect);

        //Nếu giao giữa rectangel của thực thể với bên trái hoặc phải hoặc trên hoặc dưới  khác rỗng thì là dính boom
        if (rL.isEmpty() == false || rR.isEmpty() == false || rU.isEmpty() == false || rD.isEmpty() == false || rM.isEmpty() == false) {
            return false;
        }

        return true;
    }


}
