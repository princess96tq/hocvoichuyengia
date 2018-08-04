import javax.swing.*;
import java.awt.*;

/**
 * Created by DucAnh on 18-Feb-17.
 */
public class MyFrame extends JFrame {
    static final int W=795;
    static final int H=715;

    public MyFrame()  {
        setTitle("Boom");
        setSize(W,H);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new myPanel());

    }


}
