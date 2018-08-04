import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by DucAnh on 22-Mar-17.
 */
public class BossAI2 extends Entity {
    //    int countchangeorient=0;
    int speed = 1;
    ArrayList<Map> Fringe = new ArrayList<Map>();
    ArrayList<Map> Closed = new ArrayList<Map>();
    ArrayList<Map> path = new ArrayList<Map>();
    ;

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

    public BossAI2(int x, int y) {
        super(x, y);

        arrImage = new Image[][]{imgLeft, imgRight, imgUp, imgDown};
        image = getImage();
    }


    public void creatOrient(Player player, ArrayList<Map> arrMap) {
        path.clear();
        if (seaechBFS(player, arrMap)) {
//            for (Map map : Closed) {
//                //(map.y/52+"----closed-----"+map.x/52);
//            }

            Map parentMap = Closed.get(Closed.size() - 1).parentBFS;
            path.add(Closed.get(Closed.size() - 1));
            while (parentMap != null) {
                path.add(parentMap);
                parentMap = path.get(path.size() - 1).parentBFS;
//                //(parentMap.y/52+" parent "+parentMap.x/52);
            }
//            //("Boss AI2");
//            for (Map map : path) {
//                //(map.x/52+" "+map.y/52);
//            }
            int size = 52;
            if (path.get(path.size() - 2).x != x) {
                if (path.get(path.size() - 2).x > x) {
//                            &&
//                            path.get(path.size()-2).x -x<52){
                    changeOrient(RIGHT);
                } else if (path.get(path.size() - 2).x < x)
//                            &&
//                            x-path.get(path.size()-2).x <52)
                {
                    changeOrient(LEFT);
                }
            } else if (path.get(path.size() - 2).y != y) {
                if (path.get(path.size() - 2).y > y)
//                            &&
//                            path.get(path.size()-2).y-y<52)
                {
                    changeOrient(DOWN);
                } else if (path.get(path.size() - 2).y < y)
//                                &&
//                            y-path.get(path.size()-2).y<52)
                    changeOrient(UP);
            }


        }
    }

    boolean seaechBFS(Player player, ArrayList<Map> arrMap) {
        Fringe.clear();
        Closed.clear();
        for (Map map : arrMap) {
            map.setdefaultBFS();
        }
        int size = 52;
        int row = y / size;
        int collum = x / size;

        Fringe.add(arrMap.get(row * COLLUM + collum));

        while (Fringe.isEmpty() == false) {
            Map node = Fringe.get(0);
            Closed.add(node);
            node.checkBFS = true;
            if (node.x / 52 == player.x / 52 && node.y / 52 == player.y / 52) return true;


            insert(node, arrMap);
            Fringe.remove(0);
        }
        return false;
    }

    public void insert(Map node, ArrayList<Map> arrMap) {
        int row = node.y / 52;
        int collum = node.x / 52;
        if (arrMap.get(COLLUM * row + collum).left != null && arrMap.get(COLLUM * row + collum).left.checkBFS == false) {
            Fringe.add(arrMap.get(COLLUM * row + collum).left);
            Fringe.get(Fringe.size() - 1).checkBFS = true;
            Fringe.get(Fringe.size() - 1).parentBFS = Fringe.get(0);

        }
        if (arrMap.get(COLLUM * row + collum).right != null && arrMap.get(COLLUM * row + collum).right.checkBFS == false) {
            Fringe.add(arrMap.get(COLLUM * row + collum).right);
            Fringe.get(Fringe.size() - 1).checkBFS = true;
            Fringe.get(Fringe.size() - 1).parentBFS = Fringe.get(0);
        }
        if (arrMap.get(COLLUM * row + collum).up != null && arrMap.get(COLLUM * row + collum).up.checkBFS == false) {
            Fringe.add(arrMap.get(COLLUM * row + collum).up);
            Fringe.get(Fringe.size() - 1).checkBFS = true;
            Fringe.get(Fringe.size() - 1).parentBFS = Fringe.get(0);
        }
        if (arrMap.get(COLLUM * row + collum).down != null && arrMap.get(COLLUM * row + collum).down.checkBFS == false) {
            Fringe.add(arrMap.get(COLLUM * row + collum).down);
            Fringe.get(Fringe.size() - 1).checkBFS = true;
            Fringe.get(Fringe.size() - 1).parentBFS = Fringe.get(0);
        }

    }


    void move(ArrayList<Map> arrMap) {
        //(y / 52 + "move 1st" + x / 52);
        if (countmove % 10 == 0) {
            image = getImage();
            countmove = 0;
        }
        countmove++;
        int speed = 1;
        switch (orient) {
            case LEFT:
                x -= speed;
                if (interact(arrMap))
                    x += speed;
                break;
            case RIGHT:
                x += speed;
                if (interact(arrMap)) x -= speed;
                break;
            case UP:
                y -= speed;
                if (interact(arrMap)) y += speed;
                break;
            case DOWN:
                y += speed;
                if (interact(arrMap)) y -= speed;
                break;
        }
    }


    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, 52, 52, null);
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
//        Rectangle rect= new Rectangle(x,y,52,52);
        for (Map map : arrMap) {
            Rectangle rect = getRect().intersection(map.getRect());
//            if(rect.intersects(map.getRect())==false){
            if (rect.intersects(map.getRect()) == true) {
                return false;
            }
        }
        return true;
    }

    //
//    boolean checkMap(int x,int y,ArrayList<Map> arrMap){
//        Rectangle rect= new Rectangle(x,y,52,52);
//        for(Map map:arrMap){
////            Rectangle rect=getRect().intersection(map.getRect());
//            if(rect.intersects(map.getRect())==false){
//                return false;
//            }
//        }
//        return  true;
//    }
    boolean checkBoom(ArrayList<Boom> arrBoom) {
        for (Boom boom : arrBoom) {
            Rectangle rect = getRect().intersection(boom.getRectMid());
            if (rect.isEmpty() == false) {
                return false;
            }
        }
        return true;
    }

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
    /*
     search tra ve danh sach cac dinh da duyet
     tra ve false naeu khong tim duoc duong di
      */
//    Object  search(int xfinal,int yfinal, ArrayList<Map> arrMap, ArrayList<Map> fringe, ArrayList<Map> closed){
//
//
//
//        closed.add(fringe.get(0));
//        int row=fringe.get(0).y/52;
//        int collum=fringe.get(0).x/52;
//
//        Compare compare=new Compare();
//        compare.xplayer=xfinal;
//        compare.yplayer=yfinal;
//
//        if(arrMap.get(15*row+collum).left!=null){
//            fringe.add(arrMap.get(15*row+collum).left);
//        }
//        if(arrMap.get(15*row+collum).right!=null){
//            fringe.add(arrMap.get(15*row+collum).right);
//        }
//        if(arrMap.get(15*row+collum).up!=null){
//            fringe.add(arrMap.get(15*row+collum).up);
//        }
//        if(arrMap.get(15*row+collum).down!=null){
//            fringe.add(arrMap.get(15*row+collum).down);
//        }
//        fringe.remove(0);
//        Collections.sort(fringe,compare);
//        while (true) {
//            if (fringe.isEmpty()) return false;
//
//            Map node = fringe.get(fringe.size() - 1);
////            Map node=arrMap.get(arrMap.size()-1);
//            if (node.x/52 == xfinal/52 && node.y/52 == yfinal/52) {
//                closed.add(node);
//                return closed;
//            } else {
//                if (closed.contains(node)) {
//                    fringe.remove(node);
//                } else {
//                    closed.add(node);
//                    fringe.remove(node);
//                    fringe=insert(fringe,node,arrMap);
//
//                    Collections.sort(fringe,compare);
//
//                }
//            }
//
//        }
//
////            if(!closed.contains(fringe.get(fringe.size()-1))){
////                closed.add(fringe.get(fringe.size()-1));
////                fringe.remove(fringe.size()-1);
////            }else fringe.remove(arrMap.get(arrMap.size()-1));
////            if (closed.get(closed.size()-1).x==xfinal && closed.get(closed.size()-1).y==yfinal){
////                return closed;
////            };
////
//
//
//
//    }
//    /*
//    Chen vao finge cac dinh con
//     */
//    public ArrayList<Map> insert(ArrayList<Map> fringe,Map node,ArrayList<Map> arrMap){
////        int row=fringe.
////        if(fringe.get(fringe.size()-1).left!=null) fringe.add()
////
////        fringe.sort();
//
////        Collections.sort(fringe,new Compare());
//        int row=node.y/52;
//        int collum=node.x/52;
//
//        if(arrMap.get(15*row+collum).left!=null){
//            fringe.add(arrMap.get(15*row+collum).left);
//        }
//        if(arrMap.get(15*row+collum).right!=null){
//            fringe.add(arrMap.get(15*row+collum).right);
//        }
//        if(arrMap.get(15*row+collum).up!=null){
//            fringe.add(arrMap.get(15*row+collum).up);
//        }
//        if(arrMap.get(15*row+collum).down!=null){
//            fringe.add(arrMap.get(15*row+collum).down);
//        }
//        return fringe;
//    }
}