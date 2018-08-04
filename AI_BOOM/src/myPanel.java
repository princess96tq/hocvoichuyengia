import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.BitSet;

/**
 * Created by DucAnh on 18-Feb-17.
 */
public class myPanel extends JPanel {
    Clip clip;
    GameManager gameManager;
    BitSet bitSet=new BitSet(256);


    public myPanel() {
        gameManager=new GameManager();
        //setBackground(Color.CYAN);
        gameManager.initGame();
        setFocusable(true);
        addKeyListener(listener);
        Thread thread=new Thread(runnable);
        thread.start();



    }
    KeyListener listener=new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
                if(
                        e.getKeyCode()==KeyEvent.VK_RIGHT||
                        e.getKeyCode()==KeyEvent.VK_LEFT||
                        e.getKeyCode()==KeyEvent.VK_DOWN||
                        e.getKeyCode()==KeyEvent.VK_UP)
                {if(clip==null||clip.isRunning()==false){
                  clip=AudioManager.getClip("move.wav");
                  clip.loop(Clip.LOOP_CONTINUOUSLY);
                  clip.start();
                }
                }
                bitSet.set(e.getKeyCode());

//            if (e.getKeyCode()== KeyEvent.VK_LEFT){
//                gameManager.playerMove(Entity.LEFT);
//            }
//            else if (e.getKeyCode()== KeyEvent.VK_RIGHT){
//                gameManager.playerMove(Entity.RIGHT);
//            }
//            else if (e.getKeyCode()== KeyEvent.VK_UP){
//                gameManager.playerMove(Entity.UP);
//            }
//            else if (e.getKeyCode()== KeyEvent.VK_DOWN){
//                gameManager.playerMove(Entity.DOWN);
//            }
//            else if(e.getKeyCode()==KeyEvent.VK_DOWNPACE){
//                gameManager.playerFire();
//            }
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

            bitSet.clear(e.getKeyCode());
        }
    };

    @Override
    //SD Graphics2D co net ve min hon Graphics
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d=(Graphics2D) g;

        gameManager.draw(g2d);
    }
    Runnable runnable= new Runnable() {
        @Override
        public void run() {
            //thowif gian giua 2 lan dat boom
            int time=100;
            while (true){
                time++;
                if (bitSet.get(KeyEvent.VK_LEFT)==true){
                    gameManager.playerMove(Entity.LEFT);

                }
                else if (bitSet.get(KeyEvent.VK_RIGHT)==true){
                    gameManager.playerMove(Entity.RIGHT);
                }
                else if (bitSet.get(KeyEvent.VK_UP)==true){
                    gameManager.playerMove(Entity.UP);
                }
                else if (bitSet.get(KeyEvent.VK_DOWN)==true){
                    gameManager.playerMove(Entity.DOWN);
                }else{
                    if(clip!=null)
                    clip.stop();
                }
                if( (bitSet.get(KeyEvent.VK_SPACE)==true)&&(time>100)){
                    time =0;
                    gameManager.playerFire();

                }
                boolean check= gameManager.AI() ;
                if(check==false){
                    Clip clip=AudioManager.getClip("lose.wav");
//                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    clip.start();
                    int result=JOptionPane.showConfirmDialog(
                            null,"Do you want to replay?","Game Over",JOptionPane.YES_NO_OPTION);
                    if(result==0){
                        bitSet.clear();
                        gameManager.initGame();
                    }
                    else{
                        System.exit(0);
                    }
                }
                if (gameManager.checkFinish()){
                    int result= JOptionPane.showConfirmDialog(
                            null,"Do you want to replay?","You won!",JOptionPane.YES_NO_OPTION);
                    if (result==0){
                        bitSet.clear();
                        gameManager.initGame();
                    }
                    else{
                        System.exit(0);
                    }

                }

                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    };

}
