import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by DucAnh on 23-Feb-17.
 */
public class Player extends Entity {
    Image effect;
    int countEffect = 0;
    int index = 0;


    Image[] imgLeft = {
            new ImageIcon(getClass().getResource("/image/player_left_1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_left_2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_left_3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_left_4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_left_5.png")).getImage(),
    };

    Image[] imgRight = {
            new ImageIcon(getClass().getResource("/image/player_right_1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_right_2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_right_3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_right_4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_right_5.png")).getImage(),
    };

    Image[] imgUp = {
            new ImageIcon(getClass().getResource("/image/player_up_1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_up_2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_up_3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_up_4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_up_5.png")).getImage(),
    };

    Image[] imgDown = {
            new ImageIcon(getClass().getResource("/image/player_down_1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_down_2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_down_3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_down_4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/player_down_5.png")).getImage(),

    };
    Image[] imgEffect = {
            new ImageIcon(getClass().getResource("/image/effect_01.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_02.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_03.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_04.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_05.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_06.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_07.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_08.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_09.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_10.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/effect_11.png")).getImage(),
    };


    public Player(int x, int y) {
        super(x, y);
        orient = UP;
        arrImage = new Image[][]{
                imgLeft,
                imgRight,
                imgUp,
                imgDown

        };

        image = getImage();
    }

    Image getEffect() {
        index++;
        if (index == imgEffect.length) index = 0;

        return imgEffect[index];
    }

    Boom fire() {
        Clip clip = AudioManager.getClip("touch.wav");
        clip.start();
        int xb = x;
        //+image.getWidth(null)/2;
        int yb = y;
        //+image.getHeight(null)/2;
        if (orient != LEFT) {
            xb -= 10;
        }
        yb += 10;
        Boom boom = new Boom(xb, yb);
        return boom;
    }
//Tra ve true neu khong va cham
//    boolean checkBoss(Boss boss){
//        Rectangle rect=getRect().intersection(boss.getRect());
//        if(rect.isEmpty()==false){
//            return false;
//        }
//        return true;
//    }

    //Kiểm tra va chạm giữa người chơi với boss
    boolean checkBoss(ArrayList<Boss> arrBoss, ArrayList<BossAI> arrBoss0, ArrayList<BossAI1> arrBoss1, ArrayList<BossAI2> arrBoss2, ArrayList<BossAI3> arrBoss3) {
//        for(Boss boss:arrBoss){
//            Rectangle rect=getRect().intersection(boss.getRect());
//            if(rect.isEmpty()==false){
//                return false;
//            }
//        }
//        for(BossAI boss:arrBoss0){
//            Rectangle rect=getRect().intersection(boss.getRect());
//            if(rect.isEmpty()==false){
//                return false;
//            }
//        }
//        for(BossAI1 boss:arrBoss1){
//            Rectangle rect=getRect().intersection(boss.getRect());
//            if(rect.isEmpty()==false){
//                return false;
//            }
//        }
//        for(BossAI2 boss:arrBoss2){
//            Rectangle rect=getRect().intersection(boss.getRect());
//            if(rect.isEmpty()==false){
//                return false;
//            }
//        }
        for (BossAI1 arr1 : arrBoss1) {
            if (arr1.x / 52 == x / 52 && arr1.y / 52 == y / 52) {
                return false;
            }
            return true;
        }

        for (BossAI2 arr2 : arrBoss2) {
            if (arr2.x / 52 == x / 52 && arr2.y / 52 == y / 52) {
                return false;
            }

        }

        for (Boss arr : arrBoss) {
            if (arr.x / 52 == x / 52 && arr.y / 52 == y / 52) {
                return false;
            }

        }
        for (BossAI arr : arrBoss0) {
            if (arr.x / 52 == x / 52 && arr.y / 52 == y / 52) {
                return false;
            }

        }


        for (BossAI3 ai3 : arrBoss3) {
            if (ai3.x / 52 == x / 52 && ai3.y / 52 == y / 52) {
                return false;
            }

        }
        return true;
    }


//    boolean checkBoss1(ArrayList<BossAI1> arrBoss){
//        for(BossAI1 boss:arrBoss){
//            Rectangle rect=getRect().intersection(boss.getRect());
//            if(rect.isEmpty()==false){
//                return false;
//            }
//        }
//        return true;
//    }
//    boolean checkBoss2(ArrayList<BossAI2> arrBoss){
//        for(BossAI2 boss:arrBoss){
//            Rectangle rect=getRect().intersection(boss.getRect());
//            if(rect.isEmpty()==false){
//                return false;
//            }
//        }
//        return true;
//    }
//    boolean checkBoss1(BossAI1 boss){
//
//            Rectangle rect=getRect().intersection(boss.getRect());
//            if(rect.isEmpty()==false){
//                return false;
//
//        }
//        return true;
//    }
//    boolean checkBoss2(BossAI2 boss){
//
//        Rectangle rect=getRect().intersection(boss.getRect());
//        if(rect.isEmpty()==false){
//            return false;
//
//        }
//        return true;
//    }

    void move(ArrayList<Map> arrMap) {
        if (countmove % 10 == 0) {
            image = getImage();
            countmove = 0;
        }
        countmove++;
//        image=getImage();
        int xRaw = x;
        int yRaw = y;
        int speed = 1;
        switch (orient) {
            case LEFT:
                x -= speed;
                if (interact(arrMap)) x += speed;
//                if(x<0 &&checkMap(arrMap)==false){
//                    x+=speed;
//                }
                break;
            case RIGHT:
                x += speed;
                if (interact(arrMap)) x -= speed;
//                if(x+image.getWidth(null)>MyFrame.W){
//                    x-=speed;
//                };

                break;
            case UP:
                y -= speed;
                if (interact(arrMap)) y += speed;
//                if(y+25<0){
//                    y+=speed;
//                }
                break;
            case DOWN:
                y += speed;
                if (interact(arrMap)) y -= speed;
//                if(y+image.getHeight(null)+40>MyFrame.H){
//                    y-=speed;
//            }
                break;

        }
//        if(arrMap.get((y/52)*COLLUM+(x/52)).bit!=0){
//            x=xRaw;y=yRaw;
//        }
//        boolean check =checkMap(arrMap);
////        System.out.println((y)/52 +" "+x/52+" "+  arrMap.get((y/52)*COLLUM+x/52).bit+" "+arrMap.get((y/52)*COLLUM+x/52).y/52+" "+arrMap.get((y/52)*COLLUM+x/52).x/52);
//        System.out.println(xRaw+" "+yRaw);
//        if(check==false){
//            x=xRaw;y=yRaw;
//        }
    }

    void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, 50, 50, null);
//        g2d.drawImage(image,x,y,52,52,null);
        countEffect++;
        if (countEffect % 11 == 0) {
            effect = getEffect();
            countEffect = 0;
        }
        g2d.drawImage(effect, x, y, 50, 50, null);
//        g2d.drawImage(effect,x,y,55,55,null);
    }

    boolean interact(ArrayList<Map> arrMap) {
        int i, j;
        switch (orient) {
            case LEFT:
                i = x / 52;
                j = y / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                j = (y + 45) / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                return false;
            case UP:
                i = x / 52;
                j = y / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                i = (x + 45) / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                return false;
            case RIGHT:
                i = (x + 45) / 52;
                j = y / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                j = (y + 45) / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                return false;
            default:
                i = (x) / 52;
                j = (y + 45) / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                i = (x + 45) / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                return false;

        }
    }
}

