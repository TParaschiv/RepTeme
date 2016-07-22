package observer;

public class MyspaceStream extends Stream {
    @Override
    public void act() {
        setChanged();
        notifyObservers(Streams.MYSPACE);
    }
}
