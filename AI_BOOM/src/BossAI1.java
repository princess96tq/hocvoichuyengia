import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Princess on 13-Mar-17.
 */
public  class BossAI1 extends Entity {
    int countchangeorient=0;
    int speed=1;

    boolean check=true;
    ArrayList<Map> Fringe;
    ArrayList<Map> Closed;
    Image[]imgLeft={
            new ImageIcon(getClass().getResource("/image/monster_left.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_left1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_left2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_left3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_left4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_left5.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_left6.png")).getImage(),

    };

    Image [] imgRight={
            new ImageIcon(getClass().getResource("/image/monster_right.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_right1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_right2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_right3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_right4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_right5.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_right6.png")).getImage(),

    };

    Image [] imgUp={
            new ImageIcon(getClass().getResource("/image/monster_up.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_up1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_up2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_up3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_up4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_up5.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_up6.png")).getImage(),


    };

    Image [] imgDown={
            new ImageIcon(getClass().getResource("/image/monster_down.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_down1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_down2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_down3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_down4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_down5.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/monster_down6.png")).getImage(),



    };

    public BossAI1(int x, int y) {
        super(x, y);

        arrImage =new Image[][]{imgLeft, imgRight,imgUp, imgDown};
        image=getImage();
    }


    public void creatOrient(Player player,ArrayList<Map> arrMap) {
        ArrayList<Map> result = new ArrayList<Map>();
        ArrayList<Map> fringe = new ArrayList<Map>();
        ArrayList<Map> closed = new ArrayList<Map>();
        fringe.add(new Map(x, y, 0));

        if (!search(player.x, player.y, arrMap, fringe, closed).equals(false)) {
            result = (ArrayList<Map>) this.search(player.x, player.y, arrMap, fringe, closed);
        }
        if (result.get(1).x/52!= x/52 ) {
            if (result.get(1).x / 52 > x / 52) changeOrient(RIGHT);
            else changeOrient(LEFT);
        } else if(result.get(1).y / 52 != y/52) {
            if (result.get(1).y / 52 > y / 52) changeOrient(DOWN);
            else changeOrient(UP);
        }

//        int tmpX=x;
//        int tmpY=y;
//        if(distince(tmpX-speed, this.y,player.x,player.y)<distince(this.x,this.y,player.x,player.y)) changeOrient(LEFT);
//        else if(distince(tmpX+speed, this.y,player.x,player.y)<distince(this.x,this.y,player.x,player.y)) changeOrient(RIGHT);
//        else if (x==player.x){
//            if(distince(this.x, tmpY+speed,player.x,player.y)<distince(this.x,this.y,player.x,player.y)) changeOrient(DOWN);
//            else if(distince(this.x, tmpY-speed,player.x,player.y)<distince(this.x,this.y,player.x,player.y)) changeOrient(UP);
//        }

    }
    public int distince(int x,int y,int xplayer,int yplayer){
        return (int) Math.sqrt(( (x-xplayer)*(x-xplayer) +(y-yplayer)*(y-yplayer)));
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


    public boolean getcheck() {
        return check;
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(image,x,y,52,52,null);
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
//    boolean checkBoom(ArrayList<Boom>arrBoom){
//        for (Boom boom:arrBoom) {
//            Rectangle rect= getRect().intersection(boom.getRectMid());
//            if(rect.isEmpty()==false){
//                return false;
//            }
//        }
//        return true;
//    }
//    boolean checkBoom(ArrayList<Boom>arrBoom){
//        for (Boom boom:arrBoom) {
//            Rectangle rect= getRect().intersection(boom.getRectMid());
//            if(rect.isEmpty()==false){
//                return false;
//            }
//        }
//        return true;
//    }
/*
 search tra ve danh sach cac dinh da duyet
 tra ve false naeu khong tim duoc duong di
  */
    Object  search(int xfinal,int yfinal, ArrayList<Map> arrMap, ArrayList<Map> fringe, ArrayList<Map> closed){



        closed.add(fringe.get(0));
        int row=fringe.get(0).y/52;
        int collum=fringe.get(0).x/52;

        Compare compare=new Compare();
        compare.xplayer=xfinal;
        compare.yplayer=yfinal;

        if(arrMap.get(15*row+collum).left!=null){
            fringe.add(arrMap.get(15*row+collum).left);
        }
        if(arrMap.get(15*row+collum).right!=null){
            fringe.add(arrMap.get(15*row+collum).right);
        }
        if(arrMap.get(15*row+collum).up!=null){
            fringe.add(arrMap.get(15*row+collum).up);
        }
        if(arrMap.get(15*row+collum).down!=null){
            fringe.add(arrMap.get(15*row+collum).down);
        }
        fringe.remove(0);
        Collections.sort(fringe,compare);
         while (true) {
             if (fringe.isEmpty()) return false;

             Map node = fringe.get(fringe.size() - 1);
//            Map node=arrMap.get(arrMap.size()-1);
             if (node.x/52 == xfinal/52 && node.y/52 == yfinal/52) {
                 closed.add(node);
                 return closed;
             } else {
                 if (closed.contains(node)) {
                     fringe.remove(node);
                 } else {
                     closed.add(node);
                     fringe.remove(node);
                     fringe=insert(fringe,node,arrMap);

                     Collections.sort(fringe,compare);

                 }
             }

         }

//            if(!closed.contains(fringe.get(fringe.size()-1))){
//                closed.add(fringe.get(fringe.size()-1));
//                fringe.remove(fringe.size()-1);
//            }else fringe.remove(arrMap.get(arrMap.size()-1));
//            if (closed.get(closed.size()-1).x==xfinal && closed.get(closed.size()-1).y==yfinal){
//                return closed;
//            };
//



    }
/*
Chen vao finge cac dinh con
 */
    public ArrayList<Map> insert(ArrayList<Map> fringe,Map node,ArrayList<Map> arrMap){
//        int row=fringe.
//        if(fringe.get(fringe.size()-1).left!=null) fringe.add()
//
//        fringe.sort();

//        Collections.sort(fringe,new Compare());
        int row=node.y/52;
        int collum=node.x/52;

        if(arrMap.get(COLLUM*row+collum).left!=null){
            fringe.add(arrMap.get(COLLUM*row+collum).left);
        }
        if(arrMap.get(COLLUM*row+collum).right!=null){
            fringe.add(arrMap.get(COLLUM*row+collum).right);
        }
        if(arrMap.get(COLLUM*row+collum).up!=null){
            fringe.add(arrMap.get(COLLUM*row+collum).up);
        }
        if(arrMap.get(COLLUM*row+collum).down!=null){
            fringe.add(arrMap.get(COLLUM*row+collum).down);
        }
        return fringe;
    }

//    public ArrayList<Map> sort(ArrayList<Map> sx){
//
//        return sx;
//    }


}
