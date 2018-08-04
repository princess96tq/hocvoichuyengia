import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

/**
 * Created by DucAnh on 25-Feb-17.
 */
public class AudioManager {
   public static Clip getClip(String name) {

        try {
            URL url = AudioManager.class.getResource("/sounds/" + name);
            //File file = new File("/sounds" + name);
            AudioInputStream stream = AudioSystem.getAudioInputStream(url);
            //trinh choi nhac
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
//            clip.loop(Clip.LOOP_CONTINUOUSLY);
//            clip.start();
            return clip;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
