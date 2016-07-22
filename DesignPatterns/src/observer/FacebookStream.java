package observer;

import observer.Stream;
import observer.Streams;

public class FacebookStream extends Stream {
    @Override
    public void act() {
        setChanged();
        notifyObservers(Streams.FACEBOOK);
    }
}
