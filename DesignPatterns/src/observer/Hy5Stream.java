package observer;

import observer.Stream;
import observer.Streams;

public class Hy5Stream extends Stream {
    @Override
    public void act() {
        setChanged();
        notifyObservers(Streams.HY5);
    }
}
