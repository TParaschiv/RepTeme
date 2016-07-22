package observer;

import observer.Stream;

public class TwitterStream extends Stream {

    @Override
    public void act() {
        setChanged();
        notifyObservers(Streams.TWEETER);
    }
}
