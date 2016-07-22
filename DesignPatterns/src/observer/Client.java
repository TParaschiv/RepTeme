package observer;

import java.util.Observable;
import java.util.Observer;

public class Client implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        switch ((Streams) arg) {
            case TWEETER:
                System.out.println("Oh my imagination");
                break;
            case FACEBOOK:
                System.out.println("Oh my!");
                break;
            case HY5:
                System.out.println("I think it will bust!");
                break;
            case MYSPACE:
                System.out.println("BOOM !!11!");
                break;
            default:
                System.out.println("Why? Just why?");
        }
    }
}
