import java.util.List;

public class PThread implements Runnable{
    private int start, stop;
    private List<Integer> numbers;
    private List<Integer> primes;

    public PThread(int start, int stop, List<Integer> numbers, List<Integer> primes) {
        this.start = start;
        this.stop = stop;
        this.numbers = numbers;
        this.primes = primes;
    }

    private boolean isPrime(Integer integer) {
        for (int i = 2; i <= (integer + 1) / 2; i++)
            if (integer % i == 0)
                return false;
        return true;
    }

    @Override
    public void run() {
        for (int i = start; i < stop; i++) {
            if (isPrime(numbers.get(i))) {
                primes.add(numbers.get(i));
            }
        }
    }
}
