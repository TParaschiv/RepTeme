import java.util.List;

public class Calculator {

    public Integer add(Integer a, Integer b) throws OverflowException, UnderflowException{
        if (Integer.MAX_VALUE - a < b)
            throw new OverflowException();
        if (a < 0 && b < 0 && Integer.MIN_VALUE - a - b > 0)
            throw new UnderflowException();
        return a + b;
    }

    public Integer divide(Integer a, Integer b) {
        return a / b;
    }

    public Integer average(List<Integer> list) throws OverflowException, UnderflowException {
        Integer sum = 0;
        for (Integer elem : list)
            sum = add(sum, elem);
        return divide(sum, list.size());
    }
}
