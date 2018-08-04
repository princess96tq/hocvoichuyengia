import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Princess on 23-Mar-17.
 */
public class BossAI3 extends Entity {

    ArrayList<Map> Fringe = new ArrayList<Map>();
    ArrayList<Map> Closed = new ArrayList<Map>();
    ArrayList<Map> path = new ArrayList<Map>();
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
            // new ImageIcon(getClass().getResource("/image/boss_down_09.PNG.png")).getImage(),


    };

    public BossAI3(int x, int y) {
        super(x, y);
        arrImage = new Image[][]{imgLeft, imgRight, imgUp, imgDown};
        image = getImage();
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

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, 52, 52, null);
    }

    boolean search(int xfinal, int yfinal, ArrayList<Map> arrMap) {
        Fringe.clear();//Đã ktra
        Closed.clear();//Đã ktra
        for (Map map : arrMap) {
            map.setdefaultA();
        }
        int size = 52;
        int row = y / size;
        int collum = x / size;
        Fringe.add(arrMap.get(row * COLLUM + collum));// ĐÃ ktra
        Fringe.get(0).value = 0;
        Fringe.get(0).check = true;
//        Closed.add(Fringe.get(0));//Đã ktra
//        Closed.get(0).check = true;
//        Fringe.remove(0);
        Comparater compare = new Comparater();
        compare.xplayer = xfinal;
        compare.yplayer = yfinal;
//        Fringe = insert(Fringe, Closed.get(0), arrMap);
        //SX cac phan tu trong Fringe theo thu tu tăng dần ve value
//        Collections.sort(Fringe, compare);
        while (true) {
            if (Fringe.isEmpty()) return false;
            Map node = Fringe.get(0);
            if (node.x / size == xfinal / size && node.y / size == yfinal / size) {
                Closed.add(node);
                return true;
            } else {
                if (Closed.contains(node)) {
                    Fringe.remove(node);
                } else {
                    Closed.add(node);
                    Fringe.remove(node);
                    Fringe = insert(Fringe, node, arrMap);

                    Collections.sort(Fringe, compare);
                }
            }
        }
    }

    public ArrayList<Map> insert(ArrayList<Map> Fringe, Map node, ArrayList<Map> arrMap) {

        int row = node.y / 52;
        int collum = node.x / 52;

        if (arrMap.get(COLLUM * row + collum).left != null
                && arrMap.get(COLLUM * row + collum).left.check == false) {
            Fringe.add(arrMap.get(COLLUM * row + collum).left);
            arrMap.get(COLLUM * row + collum).left.check = true;
            arrMap.get(COLLUM * row + collum).left.parent = arrMap.get(COLLUM * row + collum);
            arrMap.get(COLLUM * row + collum).left.value += arrMap.get(COLLUM * row + collum).left.parent.value;

        }

        if (arrMap.get(COLLUM * row + collum).right != null && arrMap.get(COLLUM * row + collum).right.check == false) {
            Fringe.add(arrMap.get(COLLUM * row + collum).right);
            arrMap.get(COLLUM * row + collum).right.check = true;
            arrMap.get(COLLUM * row + collum).right.parent = arrMap.get(COLLUM * row + collum);
            arrMap.get(COLLUM * row + collum).right.value += arrMap.get(COLLUM * row + collum).right.parent.value;
        }
        if (arrMap.get(COLLUM * row + collum).up != null && arrMap.get(COLLUM * row + collum).up.check == false) {
            Fringe.add(arrMap.get(COLLUM * row + collum).up);
            arrMap.get(COLLUM * row + collum).up.check = true;
            arrMap.get(COLLUM * row + collum).up.parent = arrMap.get(COLLUM * row + collum);
            arrMap.get(COLLUM * row + collum).up.value += arrMap.get(COLLUM * row + collum).up.parent.value;
//            fringe.add(arrMap.get(COLLUM*row+collum).up);
//            arrMap.get(COLLUM*row+collum).up.check=true;
        }
        if (arrMap.get(COLLUM * row + collum).down != null && arrMap.get(COLLUM * row + collum).down.check == false) {
            Fringe.add(arrMap.get(COLLUM * row + collum).down);
            arrMap.get(COLLUM * row + collum).down.check = true;
            arrMap.get(COLLUM * row + collum).down.parent = arrMap.get(COLLUM * row + collum);
            arrMap.get(COLLUM * row + collum).down.value += arrMap.get(COLLUM * row + collum).down.parent.value;
//            fringe.add(arrMap.get(COLLUM*row+collum).down);
//            arrMap.get(COLLUM*row+collum).down.check=true;
        }
        return Fringe;
    }

    public void creatOrient(Player player, ArrayList<Map> arrMap) {
        path.clear();
//       //(path.isEmpty());
        //(arrMap.get(10 * COLLUM + 8).y + " map " + arrMap.get(10 * COLLUM + 7).x);
        //(y + "boss" + x);
        //(player.y / 52 + "+++" + player.x / 52);
        if (search(player.x, player.y, arrMap)) {
            Map parentMap = Closed.get(Closed.size() - 1).parent;
            path.add(Closed.get(Closed.size() - 1));
            while (parentMap != null) {
                path.add(parentMap);
                parentMap = path.get(path.size() - 1).parent;
            }
            for (Map map : path) {
                //(map.y / 52 + " " + map.x / 52);
            }
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
//                System.out.println("vào");
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
}

//       //(y/52+" "+x/52);

//       //(player.y/52+" "+player.x/52);
//        Fringe = new ArrayList<Map>();
//        Closed = new ArrayList<Map>();
//        fringe.add(new Map(x, y, 0));

//        if (!search(player.x, player.y, arrMap, fringe, closed).equals(false)) {
//            result = (ArrayList<Map>) this.search(player.x, player.y, arrMap, fringe, closed);
//        }

//        path = new ArrayList<Map>();


//System.out.println(parentMap.y/52+" "+parentMap.x/52);

//               //(parentMap.y/52+" "+parentMap.x/52);


//&& arrMap.get((y/52)*COLLUM+(x/52)).right.bit==0){
//                    if(checkMap(arrMap,x+1,y)==true)

//

//

//&&arrMap.get((y/52)*COLLUM+(x/52)).left.bit==0){
//                    if (checkMap(arrMap,x-1,y)==true)

//&& arrMap.get((y/52)*COLLUM+(x/52)).down.bit==0)
//                    if(checkMap(arrMap,x,y+1)==true){

//                    kt=true;


//            for (int i = path.size() - 1; i > 0; i--) {
//                if (x / 52 > path.get(i).x / 52 && (checkMap(arrMap, x - 1, y) == true)) {
//                    changeOrient(LEFT);
//                } else if (x / 52 < path.get(i).x / 52 && (checkMap(arrMap, x + 1, y) == true)) {
//                    changeOrient(RIGHT);
//                } else if (y / 52 > path.get(i).y / 52 && (checkMap(arrMap, x, y - 1) == true)) {
//                    changeOrient(UP);
//                } else if (y / 52 < path.get(i).y / 52 && (checkMap(arrMap, x, y + 1) == true)) {
//                    changeOrient(DOWN);
//                }
//            }
//        }
//            int count=1;
//            while(count <path.size()){
//                do{
//                if (path.get(path.size()-count).x / 52 > x / 52 && arrMap.get((y/52)*COLLUM+(x/52)).right.bit==0)
//                    changeOrient(RIGHT);
//                else if(path.get(path.size()-count).x / 52 < x / 52&&arrMap.get((y/52)*COLLUM+(x/52)).left.bit==0)
//                    changeOrient(LEFT);
//
//                }while (x/52==path.get(path.size()-count).x/52);
//
//                do{
//
//                if (path.get(path.size()-count).y / 52 > y / 52 && arrMap.get((y/52)*COLLUM+(x/52)).down.bit==0)
//                    changeOrient(DOWN);
//                else if(path.get(path.size()-count).y/ 52 < y / 52&&arrMap.get((y/52)*COLLUM+(x/52)).up.bit==0)
//                    changeOrient(UP);
//
//                }while (y/52==path.get(path.size()-count).y/52);
//
//            }
//            int step=1;
////            int size=path.size();
////            while (path.get(size-step).x/52!= x/52 )
//                boolean kt=false;
//
//            if (path.get(path.size()-2).x/52!= x/52 ) {
//                if (path.get(path.size()-2).x / 52 > x / 52){
//                        //&& arrMap.get((y/52)*COLLUM+(x/52)).right.bit==0){
//                    if(checkMap(arrMap,x+1,y)==true) changeOrient(RIGHT);
////
//                }
////
//                else if(path.get(path.size()-2).x / 52 < x / 52){
//                        //&&arrMap.get((y/52)*COLLUM+(x/52)).left.bit==0){
//                    if (checkMap(arrMap,x-1,y)==true)changeOrient(LEFT);}
//            } else if(path.get(path.size()-2).y / 52 != y/52) {
//                if (path.get(path.size()-2).y / 52 > y / 52 )changeOrient(DOWN);
//                        //&& arrMap.get((y/52)*COLLUM+(x/52)).down.bit==0)
////                    if(checkMap(arrMap,x,y+1)==true){
//
////                    kt=true;
//
//                else if(path.get(path.size()-2).y / 52 < y / 52 )changeOrient(UP);
//            }
//    }
//&& arrMap.get((y/52)*COLLUM+(x/52)).up.bit==0)
//                    if(checkMap(arrMap,x,y-1)==true){

//kt=true;

//
//        }
//                if (kt==false) {
//                step++;
//                }
//                   //(path.get(size-s));


//    boolean checkMap(ArrayList<Map>arrMap){
//        if(arrMap.get((y/52 )*COLLUM + x/52).bit!=0){
//            int xtmp=arrMap.get((y/52 )*COLLUM + x/52).x;
//            int ytmp=arrMap.get((y/52 )*COLLUM + x/52).y;
//            if(x>xtmp && )return false;
//
//        }
//        return true;
//
//    }

//    boolean     checkMap(ArrayList<Map> arrMap,int xtmp,int ytmp){
//        //Rectangle rect= new Rectangle(x,y,52,52);
//        Rectangle rectTmp=new Rectangle(xtmp+17,ytmp+36,image.getWidth(null)-40,image.getHeight(null)-55);
//        for(Map map:arrMap){
//              Rectangle rect=rectTmp.intersection(map.getRect());
////            if(rect.intersects(map.getRect())==false){
//            if(rect.intersects(map.getRect())==true){
//                return false;
//            }
//        }
//        return true;
//    }

//    boolean search(int xfinal, int yfinal, ArrayList<Map> arrMap) {
////        Fringe=new ArrayList<Map>();
////        Closed=new ArrayList<Map>();
////        //(Fringe.isEmpty());
////        //(Closed.isEmpty());
//        Fringe.clear();//Đã ktra
//
////        //(Fringe.isEmpty());
//
//        Closed.clear();//Đã ktra
////        //(Fringe.isEmpty());
//        for (Map map : arrMap) {
//            map.setdefault();
//        }
//        int size = 52;
//        int row = y / size;
//        int collum = x / size;
////        //(arrMap.get(row*COLLUM+collum).y/52+" +"+arrMap.get(row*COLLUM+collum).x/52);
//        Fringe.add(arrMap.get(row * COLLUM + collum));// ĐÃ ktra
//        Closed.add(Fringe.get(0));//Đã ktra
//
//        Closed.get(0).check = true;
//        Fringe.remove(0);
//        Comparater compare = new Comparater();
//        compare.xplayer = xfinal;
//        compare.yplayer = yfinal;
//
//        Fringe = insert(Fringe, Closed.get(0), arrMap);
//        //SX cac phan tu trong Fringe theo thu tu giam dan ve value
//        Collections.sort(Fringe, compare);
//        while (true) {
//            if (Fringe.isEmpty()) return false;
//
//            Map node = Fringe.get(Fringe.size() - 1);
////            Map node=arrMap.get(arrMap.size()-1);
//            if (node.x / size == xfinal / size && node.y / size == yfinal / size) {
//                Closed.add(node);
////                //("++++++++++Lần mới++++++++++");
////                 for(Map map:Closed){
////                    //(map.y/52+" "+map.x/52);
////                 }
//                return true;
//            } else {
//                if (Closed.contains(node)) {
//                    Fringe.remove(node);
//                } else {
//                    Closed.add(node);
//                    Fringe.remove(node);
//                    Fringe = insert(Fringe, node, arrMap);
//
//                    Collections.sort(Fringe, compare);
//
//                }
//            }
//        }
//
////         if(arrMap.get(COLLUM*row+collum).left!=null){
////
////             Fringe.add(arrMap.get(COLLUM*row+collum).left);
////             arrMap.get(COLLUM*row+collum).left.check=true;//Đánh dấu mảng đã duyệt qua
////             arrMap.get(COLLUM*row+collum).left.parent=arrMap.get(COLLUM*row+collum);
////             arrMap.get(COLLUM*row+collum).left.value++;
////         }
////         if(arrMap.get(COLLUM*row+collum).right!=null){
////
////             Fringe.add(arrMap.get(COLLUM*row+collum).right);
////             arrMap.get(COLLUM*row+collum).right.check=true;
////             arrMap.get(COLLUM*row+collum).right.parent=arrMap.get(COLLUM*row+collum);
////             arrMap.get(COLLUM*row+collum).right.value++;
////         }
////         if(arrMap.get(COLLUM*row+collum).up!=null){
////
////             Fringe.add(arrMap.get(COLLUM*row+collum).up);
////             arrMap.get(COLLUM*row+collum).up.check=true;
////             arrMap.get(COLLUM*row+collum).up.parent=arrMap.get(COLLUM*row+collum);
////             arrMap.get(COLLUM*row+collum).up.value++;
////         }
////         if(arrMap.get(COLLUM*row+collum).down!=null){
////
////             Fringe.add(arrMap.get(COLLUM*row+collum).down);
////             arrMap.get(COLLUM*row+collum).down.check=true;
////             arrMap.get(COLLUM*row+collum).down.parent=arrMap.get(COLLUM*row+collum);
////             arrMap.get(COLLUM*row+collum).down.value++;
////         }
////         Fringe.remove(0);
//
////        return true;
//
//    }