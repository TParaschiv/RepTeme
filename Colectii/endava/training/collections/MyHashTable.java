package endava.training.collections;
import java.util.*;

class PenguinPair implements Map.Entry<Penguin, String> {

    private Penguin penguin;
    private String name;

    public PenguinPair(Penguin penguin, String name) {
        this.penguin = penguin;
        this.name = name;
    }

    @Override
    public Penguin getKey() {
        return penguin;
    }

    @Override
    public String getValue() {
        return name;
    }

    @Override
    public String setValue(String value) {
        name = value;
        return name;
    }
}

public class MyHashTable {

    private List<List<PenguinPair>> penguins;
    private int size;

    /**
     * Constructor
     * @param size size of the list of buckets list
     */
    public MyHashTable(int size) {
        this.size = size;
        penguins = new ArrayList<>();
        for (int i = 0; i < size; i++)
            penguins.add(new ArrayList<>());
    }

    /**
     * Get the bucket index
     * @param p penguin
     * @return bucket index
     */
    private int getInd(Penguin p) {
        return Math.abs(p.hashCode()) % size;
    }

    /**
     * Add to a bucket
     * @param p penguin
     */
    public void put(Penguin p) {
        int ind = getInd(p);
        if (!penguins.get(ind).contains(p))
            penguins.get(ind).add(new PenguinPair(p, p.getName()));
    }

    /**
     * Get penguin name
     * @param p penguin
     * @return penguin name
     */
    public String get(Penguin p) {
        int ind = getInd(p);
        for (PenguinPair pair : penguins.get(ind))
            if (pair.getKey().equals(p))
                return pair.getValue();
        return "";
    }
}
