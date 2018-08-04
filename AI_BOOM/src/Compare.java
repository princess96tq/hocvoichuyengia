import java.util.Comparator;

/**
 * Created by Princess on 19-Mar-17.
 */
public class Compare implements Comparator<Map> {
    int xplayer;
    int yplayer;

    @Override
    public int compare(Map o1, Map o2) {
//        if((o1.x/52-xplayer/52)+(o1.y/52-yplayer/52)>(o2.x/52-xplayer/52)+(o2.y/52-yplayer/52)) return 1;
//        else if((o1.x/52-xplayer/52)+(o1.y/52-yplayer/52)==(o2.x/52-xplayer/52)+(o2.y/52-yplayer/52))return 0;
//        else return -1;
        if (Math.sqrt(((o1.x - xplayer) * (o1.x - xplayer) + (o1.y - yplayer) * (o1.y - yplayer))) >
                Math.sqrt(((o2.x - xplayer) * (o2.x - xplayer) + (o2.y - yplayer) * (o2.y - yplayer)))) {
            return 1;
        } else if (Math.sqrt(((o1.x - xplayer) * (o1.x - xplayer) + (o1.y - yplayer) * (o1.y - yplayer))) ==
                Math.sqrt(((o2.x - xplayer) * (o2.x - xplayer) + (o2.y - yplayer) * (o2.y - yplayer)))) return 0;
        else return -1;
    }
}
