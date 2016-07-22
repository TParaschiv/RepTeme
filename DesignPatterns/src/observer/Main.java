package observer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* -------------- Ex3 --------------  */
        System.out.println(" -------------- Ex3 -------------- ");
        Client client = new Client();
        List<Stream> streams = new ArrayList<>();
        // Tweeter
        Stream tmp = new TwitterStream();
        tmp.addObserver(client);
        streams.add(tmp);
        // Facebook
        tmp = new FacebookStream();
        tmp.addObserver(client);
        streams.add(tmp);
        // Hy5
        tmp = new Hy5Stream();
        tmp.addObserver(client);
        streams.add(tmp);
        // Myspace
        tmp = new MyspaceStream();
        tmp.addObserver(client);
        streams.add(tmp);

        for (Stream stream : streams)
            stream.act();
    }
}
