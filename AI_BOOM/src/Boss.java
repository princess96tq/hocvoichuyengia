import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Heart Of Dead on 23-Feb-17.
 */
public class Boss extends Entity {
    boolean check = true;
    Random random = new Random();
    Image[] imgLeft = {
            new ImageIcon(getClass().getResource("/image/boss_left_01.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_left_02.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_left_03.PNG.png")).getImage(),

    };

    Image[] imgRight = {
            new ImageIcon(getClass().getResource("/image/boss_right_01.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_right_02.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_right_03.PNG.png")).getImage(),

    };

    Image[] imgUp = {
            new ImageIcon(getClass().getResource("/image/boss_up_01.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_up_02.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_up_03.PNG.png")).getImage(),

    };

    Image[] imgDown = {
            new ImageIcon(getClass().getResource("/image/boss_down_01.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_down_02.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_down_03.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_down_04.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_down_05.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_down_06.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_down_07.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_down_08.PNG.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/boss_down_09.PNG.png")).getImage(),


    };


    public void turnAround() {
        // quay dau tro lai khi gap vat can
        Random random = new Random();
        switch (orient) {
            case UP:
                int r = random.nextInt(3);
                if (r == 0) {
                    orient = LEFT;
                } else if (r == 1) {
                    orient = RIGHT;
                } else {
                    orient = DOWN;
                }
                break;
            case DOWN:
                int r2 = random.nextInt(3);
                if (r2 == 0) {
                    orient = LEFT;
                } else if (r2 == 1) {
                    orient = RIGHT;
                } else {
                    orient = UP;
                }
                break;
            case LEFT:
                int r3 = random.nextInt(3);
                if (r3 == 0) {
                    orient = UP;
                } else if (r3 == 1) {
                    orient = DOWN;
                } else {
                    orient = RIGHT;
                }
                break;
            case RIGHT:
                int r4 = random.nextInt(3);
                if (r4 == 0) {
                    orient = UP;
                } else if (r4 == 1) {
                    orient = DOWN;
                } else {
                    orient = LEFT;
                }
                break;
        }
    }

    public void creatOrient() {
        int percent = random.nextInt(101);
        if (percent > 98) {
            int newOrient = random.nextInt(4);
            changeOrient(newOrient);
        }
    }

//        if(x<player.x) changeOrient(LEFT);
//        else if(x<player.x) changeOrient(RIGHT);
//        if(x==player.x){
//            if(y<player.y) changeOrient(DOWN);
//            else if(y>player.y) changeOrient(UP);
//        }
//
//    }


    public Boss(int x, int y) {
        super(x, y);
        orient = UP;
        arrImage = new Image[][]{imgLeft, imgRight, imgUp, imgDown};

        image = getImage();
    }

    @Override
//    public boolean getcheck() {
//        return check;
//    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, 52, 52, null);
    }

    void move(ArrayList<Map> arrMap) {
        //(y / 52 + "move 1st" + x / 52);
        if (countmove % 10 == 0) {
            image = getImage();
            countmove = 0;
        }
        countmove++;
        int speed = 1;
        int xRaw = x;
        int yRaw = y;
        switch (orient) {
            case LEFT:
                x -= speed;
//               if (interact(arrMap))
//                    x += speed;
                break;
            case RIGHT:
                x += speed;
                //if (interact(arrMap)) x -= speed;
                break;
            case UP:
                y -= speed;
                // if (interact(arrMap)) y += speed;
                break;
            case DOWN:
                y += speed;
                // if (interact(arrMap)) y -= speed;
                break;
        }
        if (interact(arrMap)) {
            x = xRaw;
            y = yRaw;
            turnAround();
        }


    }


    boolean interact(ArrayList<Map> arrMap) {
        int i, j;
        //(y / 52 + "interact " + x / 52);
        switch (orient) {
            case LEFT:
                i = (x) / 52;
                j = y / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                j = (y + 50) / 52;
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
                i = (x + 50) / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                return false;
            case RIGHT:
                i = (x + 50) / 52;
                j = y / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                j = (y + 50) / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                return false;
            default:
                i = (x) / 52;
                j = (y + 50) / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                i = (x + 50) / 52;
                if (arrMap.get(j * COLLUM + i).bit != 0) {
                    return true;//xảy ra va chạm
                }
                return false;

        }
    }

    boolean checkMap(ArrayList<Map> arrMap) {
        for (Map map : arrMap) {
            Rectangle rect = getRect().intersection(map.getRect());
            if (rect.isEmpty() == false) {
                return false;
            }
        }
        return true;
    }

    boolean checkBoom(ArrayList<Boom> arrBoom) {
        for (Boom boom : arrBoom) {
            Rectangle rect = getRect().intersection(boom.getRectMid());
            if (rect.isEmpty() == false) {
                return false;
            }
        }
        return true;
    }
}
