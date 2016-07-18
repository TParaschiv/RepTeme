package endava.training.collections;

import java.util.Comparator;
import java.util.List;

public class CustomComparator implements Comparator<Penguin>{

    /**
     * Get average of penguins age
     * @param penguins mates to average
     * @param age main penguin age
     * @return average of the mates + main penguin age
     */
    private double getAvg(List<Penguin> penguins, double age) {
        for (Penguin penguin : penguins)
            age += penguin.getAge();
        return age / (penguins.size() + 1);
    }

    @Override
    public int compare(Penguin p1, Penguin p2) {
        double res = p1.getMatingPartners().size() - p2.getMatingPartners().size();
        if (res == 0) {
            res = getAvg(p1.getMatingPartners(), p1.getAge()) - getAvg(p2.getMatingPartners(), p2.getAge());
            if (res == 0)
                return p1.getName().compareTo(p2.getName());
            else if (res < 0)
                return -1;
            return 1;
        }
        else if (res < 0)
            return -1;
        return 1;
    }
}
