import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Heart Of Dead on 23-Feb-17.
 */
public class Entity {
    static final int ROW = 13;
    static final int COLLUM = 15;
    int index = 0;
    int countmove = 0;

    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int UP = 2;
    static final int DOWN = 3;

    int x;
    int y;
    int orient;//huong di chuyen
    Image image;
    Image[][] arrImage;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Tra ve hinh anh hien thi hien tai
    Image getImage() {
        index++;
        if (index >= arrImage[orient].length) index = 0;
        return arrImage[orient][index];
    }

    void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, 52, 52, null);
    }

    //Thay doi huong di chuyen
    void changeOrient(int newOrient) {
        if (orient != newOrient) {
            index = 0;
            countmove = 0;
        }
        orient = newOrient;
    }


    public Rectangle getRect() {
        Rectangle rectangle =
//                new Rectangle(x+17,y+36,20,30);
                new Rectangle(x + 17, y + 36, image.getWidth(null) - 40, image.getHeight(null) - 55);
//        Rectangle rectangle=new Rectangle(x,y+20,image.getWidth(null)-20,image.getHeight(null)-30);
//        Rectangle rectangle=new Rectangle(x,y,image.getWidth(null),image.getHeight(null));
//        Rectangle rectangle=new Rectangle(x+17,y+55,image.getWidth(null)-45,image.getHeight(null)-55);
        return rectangle;
    }
//Tra ve true neu khong bi vuong vao map

//    boolean checkMap(ArrayList<Map>arrMap){
//        for (Map map : arrMap) {
//            if(map.vacham(x,y)==false)return false;
//        }
//        return true;
//    }

    //        for(Map map:arrMap){
//            Rectangle rect=getRect().intersection(map.getRect());
//            if(rect.isEmpty()==false){
//                return false;
//            }
//        }
//        return  true;
//    }
}
