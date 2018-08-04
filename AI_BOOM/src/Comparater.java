import java.util.Comparator;

/**
 * Created by Princess on 23-Mar-17.
 */
//value=63 giá trị max cua dương đi
public class Comparater implements Comparator<Map> {
    int xplayer;
    int yplayer;
    @Override
    public int compare(Map o1, Map o2) {
        if(Math.abs( o1.x-xplayer) +Math.abs(o1.y-yplayer) +o1.value > Math.abs(o2.x - xplayer) + Math.abs(o2.y - yplayer) + o2.value)
            return 1;
        else if(Math.abs( o1.x-xplayer) +Math.abs(o1.y-yplayer) +o1.value== Math.abs(o2.x-xplayer)+Math.abs(o2.y-yplayer)+o2.value)
            return 0;
        else return -1;

    }
}
