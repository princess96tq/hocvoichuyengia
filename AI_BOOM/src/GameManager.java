import jdk.internal.util.xml.impl.ReaderUTF8;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Heart Of Dead on 23-Feb-17.
 */
public class GameManager {
    Clip clip;
    static final int ROW=13;
    static final int COLLUM=15;
//    ArrayList<Boss> arrBoss;
    Random random =new Random();
    ArrayList<Boom> arrBoom;
    ArrayList<Map> arrMap = new ArrayList<Map>();
    Player player;
//    Boss boss;
    ArrayList<Boss> arrBoss;
    ArrayList<BossAI1> arrBoss1;
    ArrayList<BossAI2> arrBoss2;
    ArrayList<BossAI> arrBoss0;
    ArrayList<BossAI3> arrBoss3;
    //BossAI boss2;
//    BossAI2 boss2;
//    BossAI1 boss1;
    Image im=new ImageIcon(getClass().getResource("/image/back_ground_boom.png")).getImage();
    int[][] bits = new int[ROW][COLLUM];




    public GameManager() {
        initGame();
    }

    private void readMap() {
        BufferedReader reader = null;
        try {
            URL url = getClass().getResource("/maps/map9");
            InputStream inputStream = url.openStream();
            reader = new BufferedReader(new ReaderUTF8(inputStream));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < ROW; i++) {
            String tmp = "";
            try {
                tmp = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] arrBit = tmp.split(" ");
            for (int j = 0; j < arrBit.length; j++) {
                bits[i][j] = Integer.parseInt(arrBit[j]);
            }
            ;
        }
    }


    public void initGame(){
        readMap();
        if(clip!=null){
            clip.stop();
        }


        for(int j=0;j<ROW;j++){
        for(int i=0;i<COLLUM;i++){

                int b=bits[j][i];
                int x=(i)*52;
                int y=(j)*52;
                Map map=new Map(x,y,b);

                arrMap.add(map);

            }
        }
//        System.out.println(arrMap.get(138).bit+" "+arrMap.get(138).x+" "+arrMap.get(138).y);
//        System.out.println((200/52-1)+" "+ 200/52+" "+arrMap.get((220/52 -1)*COLLUM + 200/52).bit+arrMap.get(33).y/52+" "+arrMap.get(33).x/52);
//        System.out.println(arrMap.get(15).bit);
//        for(int i=0;i<arrMap.size();i++){
//            if(i%15==0)System.out.println();
//            System.out.print(arrMap.get(i).y+" ");
//        }
//        for(int i=0;i<arrMap.size();i++) {
////            if (i >= 30&& i<45) System.out.print(arrMap.get(i-COLLUM).bit + " ");
////             if (i %COLLUM==14) System.out.print(arrMap.get(i).bit);
////            else if (i % COLLUM == 0) {
////                System.out.print(arrMap.get(i).bit);
////                System.out.println(arrMap.get(i + 14).bit);
////            }
//        }


//            else if(i>178) System.out.print(arrMap.get(i).bit);
//            else if(i>179) System.out.print(arrMap.get(i).bit);
//            else if(i%COLLUM==0) {System.out.print(arrMap.get(i).bit);
//                System.out.println(arrMap.get(i+14).bit);}
//            if ((arrMap.get(i).x/52)%COLLUM==0) {System.out.println();System.out.print(arrMap.get(i).bit);}
//            else System.out.print(arrMap.get(i).bit);


//        for( int i=0;i<arrMap.size();i++){
//            if(i<=COLLUM) arrMap.get(i).setUp(null);
//            else arrMap.get(i).setUp(arrMap.get(i-COLLUM));
//            if(i>179) arrMap.get(i).setDown(null);
//            else arrMap.get(i).setDown(arrMap.get(i+COLLUM));
//            if(i%COLLUM==0) arrMap.get(i).setLeft(null);
//            else arrMap.get(i).setLeft(arrMap.get(i-1));
//            if(i%COLLUM==14) arrMap.get(i).setRight(null);
//            else arrMap.get(i).setRight(arrMap.get(i+1));
//
//        }

        for( int i=0;i<arrMap.size();i++){
            if(i<=COLLUM) arrMap.get(i).setUp(null);
            else{ arrMap.get(i).setUp(arrMap.get(i-COLLUM));
            }

            if(i>179) arrMap.get(i).setDown(null);
            else arrMap.get(i).setDown(arrMap.get(i+COLLUM));
            if(i%COLLUM==0) arrMap.get(i).setLeft(null);
            else {arrMap.get(i).setLeft(arrMap.get(i-1));
            }
            if(i%COLLUM==14) arrMap.get(i).setRight(null);
            else arrMap.get(i).setRight(arrMap.get(i+1));
//            System.out.println(arrMap.get(i).left.bit);
        }


        arrBoom= new ArrayList<>();
        arrBoss=new ArrayList<Boss>();
        arrBoss0=new ArrayList<BossAI>();
        arrBoss1=new ArrayList<BossAI1>();
        arrBoss2=new ArrayList<BossAI2>();
        arrBoss3=new ArrayList<BossAI3>();
        player=new Player(365,400);
 //       Boss boss1=new Boss(300,200);

//        boss2=new BossAI(300,200);
        arrBoss.add(new Boss(300,53));//random
//        arrBoss0.add(new BossAI(300,200));
//        arrBoss1.add(new BossAI1(300,53) );
        arrBoss2.add(new BossAI2(300,52));//BFS
        arrBoss3.add(new BossAI3(300,53));//A*
        //arrBoss3.add(new BossAI3(600,53));

       // arrBoss.add(new Boss(300,200));
//        boss2= new BossAI2(300,200);
//        boss1=new BossAI1(300,200);
//        boss=new Boss(300,200);
//        arrBoss.add(boss);
//        arrBoss.add(boss1);
//        arrBoss.add(boss2);
//        Boss boss3=new Boss(400,250);

//        arrBoss.add(boss1);
//        arrBoss.add(boss2);
//        arrBoss.add(boss3);
//        arrBoss.add(new Boss(570,520));


    }
    void draw(Graphics2D g2d){
        g2d.drawImage(im,0,0, 780 ,676,null);
        for(Map map: arrMap){

            map.draw(g2d);
        }
        for(Boss boss: arrBoss){
            boss.draw(g2d);

        }
        for (BossAI1 boss:arrBoss1){
            boss.draw(g2d);

        }
        for (BossAI2 boss:arrBoss2){
            boss.draw(g2d);

        }
        for (BossAI boss:arrBoss0){
            boss.draw(g2d);

        }
        for (BossAI3 ai3 : arrBoss3) {
            ai3.draw(g2d);
        }
//        if(boss1.check==true){
//        boss1.draw(g2d);}
//        if(boss2.check==true){
//        boss2.draw(g2d);}
//        if(boss.check==true) boss.draw(g2d);
//        boss2.draw(g2d);
        for(int i=arrBoom.size()-1;i>=0;i--){

            boolean check=arrBoom.get(i).draw(g2d);
            if(check==true){
                arrBoom.remove(i);

            }}

        player.draw(g2d);




        }

    boolean AI(){
        for( int i=0;i<arrBoss.size();i++){
            //arrBoss.get(i).orient=random.nextInt(4);
            arrBoss.get(i).creatOrient();
            arrBoss.get(i).move(arrMap);
        }

        for( int i=0;i<arrBoss1.size();i++){
            //arrBoss.get(i).orient=random.nextInt(4);
            arrBoss1.get(i).creatOrient(player,arrMap);
            arrBoss1.get(i).move(arrMap);
        }
        for( int i=0;i<arrBoss2.size();i++){
            //arrBoss.get(i).orient=random.nextInt(4);
            arrBoss2.get(i).creatOrient(player,arrMap);
            arrBoss2.get(i).move(arrMap);
        }
        for( int i=0;i<arrBoss0.size();i++){
            //arrBoss.get(i).orient=random.nextInt(4);
            arrBoss0.get(i).creatOrient(player);
            arrBoss0.get(i).move(arrMap);
        }
//        System.out.println("---------------------------");
        for (BossAI3 ai3 : arrBoss3) {

            ai3.creatOrient(player,arrMap);
//            for (Map map : ai3.path) {
////                System.out.println(map.y/52+" bosAI3 "+map.x/52);
//            }

            ai3.move(arrMap);



        }


//        boss.creatOrient(player,arrMap);
//        boss1.creatOrient(player,arrMap);
//
////        System.out.println(boss3.orient);
////        System.out.println(boss3.orient);
//        boss1.move(arrMap,arrBoom);
//        boss2.creatOrient(player,arrMap);
//        boss2.move(arrMap,arrBoom);
//        boss.move(arrMap,arrBoom);

//        boss2.creatOrient(player);
//        System.out.println(boss2.orient);
//        boss2.move(arrMap,arrBoom);
//
        for(int i=0;i<arrBoom.size();i++){
            boolean check =arrBoom.get(i).explosion(arrMap,player,arrBoss,arrBoss0,arrBoss1,arrBoss2,arrBoss3);
            if(check==false){//check booom
                return false;
            }
        }
//    if ((player.checkBoss1(boss1)==false)||player.checkBoss2(boss2)==false) return (false);
    return (player.checkBoss(arrBoss,arrBoss0,arrBoss1,arrBoss2,arrBoss3));
//            ||player.checkBoss1(boss1));
//    return true;
    }

    public void playerMove(int newOrient){

        player.changeOrient(newOrient);
        player.move(arrMap);
//        System.out.println(player.y/52+" ++"+player.x/52);

    }

   public void playerFire(){
        Boom boom=player.fire();
        arrBoom.add(boom);
    }

    //Tra ve true neu thang
    //Tra ve false neu chua chien thang
    public boolean checkFinish(){
        if(arrBoss.isEmpty()&& arrBoss1.isEmpty()&&arrBoss2.isEmpty()&& arrBoss0.isEmpty()&&arrBoss3.isEmpty())return true;
        else return false;
    }

//    public static void main(String[] args) {
//        GameManager gmng=new GameManager();
//        gmng.initGame();
//        for (int i = 0; i <gmng.arrMap.size() ; i++) {
//            if(i%COLLUM==0) System.out.println();
//            System.out.print(gmng.bits[i]+" ");
//        }
//    }
}
