import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static boolean isPrime(Integer integer) {
        for (int i = 2; i <= (integer + 1) / 2; i++)
            if (integer % i == 0)
                return false;
        return true;
    }

    /* V1 */
public static void ex1_v1(List<Integer> numbers) {
        System.out.println("--------------------- Serial ---------------------\n");
        List<Integer> primes = new ArrayList<>();
        long time = System.currentTimeMillis();
        for (Integer integer : numbers)
            if (isPrime(integer))
                primes.add(integer);
        time = System.currentTimeMillis() - time;
        System.out.println("Primes: " + primes);
        System.out.println("Serial it took: " + time + " ms\n");
    }

    /* V2 */
    public static void ex1_v2(List<Integer> numbers, int nr_threads) {
        System.out.println("--------------------- Pool + synchronized in thread ---------------------\n");
        ExecutorService executor = Executors.newFixedThreadPool(4);
        int chunk = numbers.size() / nr_threads;
        System.out.println("Chunk: " + chunk);
        List<Integer> primes = new ArrayList<>();
        long time = System.currentTimeMillis();
        for (int i = 0; i < nr_threads; i++)
            executor.execute(new SPThread(i * chunk, Math.min((i + 1) * chunk, numbers.size()), numbers, primes));
        executor.shutdown();
        while (!executor.isTerminated()) { }
        time = System.currentTimeMillis() - time;
        System.out.println("Primes: " + primes);
        System.out.println("Thread pool it took: " + time + " ms\n");
    }

    /* V3 */
    public static void ex1_v3(List<Integer> numbers, int nr_threads) {
        System.out.println("--------------------- Pool + synchronized collection ---------------------\n");
        ExecutorService executor = Executors.newFixedThreadPool(4);
        int chunk = numbers.size() / nr_threads;
        List<Integer> primes = Collections.synchronizedList(new ArrayList<>());
        long time = System.currentTimeMillis();
        for (int i = 0; i < nr_threads; i++)
            executor.execute(new SPThread(i * chunk, Math.min((i + 1) * chunk, numbers.size()), numbers, primes));
        executor.shutdown();
        while (!executor.isTerminated()) { }
        time = System.currentTimeMillis() - time;
        System.out.println("Primes: " + primes);
        System.out.println("Thread pool it took: " + time + " ms\n");
    }

    /* V4 */
    public static void ex1_v4(List<Integer> numbers, int nr_threads) {
        System.out.println("--------------------- Array of threads + synchronized in thread ---------------------\n");
        List<Thread> threads = new ArrayList<>();
        List<Integer> primes = new ArrayList<>();
        int chunk = numbers.size() / nr_threads;
        long time = System.currentTimeMillis();
        for (int i = 0; i < nr_threads; i++) {
            Thread thr = new Thread(new SPThread(i * chunk, Math.min((i + 1) * chunk, numbers.size()), numbers, primes));
            threads.add(thr);
            thr.run();
        }
        try {
            for (Thread thr : threads)
                thr.join();
        } catch (Exception e) {
            System.err.println("A crapat");
        } finally {
            time = System.currentTimeMillis() - time;
            System.out.println("Primes: " + primes);
            System.out.println("Threads it took: " + time + " ms\n");
        }
    }

    /* V5 */
    public static void ex1_v5(List<Integer> numbers, int nr_threads) {
        System.out.println("--------------------- Array of threads + synchronized collection ---------------------\n");
        List<Thread>threads = new ArrayList<>();
        List<Integer> primes = Collections.synchronizedList(new ArrayList<>());
        int chunk = numbers.size() / nr_threads;
        long time = System.currentTimeMillis();
        for (int i = 0; i < nr_threads; i++) {
            Thread thr = new Thread(new PThread(i * chunk, Math.min((i + 1) * chunk, numbers.size()), numbers, primes));
            threads.add(thr);
            thr.run();
        }
        try {
            for (Thread thr : threads)
                thr.join();
        } catch (Exception e) {
            System.err.println("A crapat");
        }
        finally {
            time = System.currentTimeMillis() - time;
            System.out.println("Primes: " + primes);
            System.out.println("Threads it took: " + time + " ms\n");
        }
    }

    public static void ex1(int length, int max_nr, int nr_threads) {

        List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < length; i++)
            numbers.add((int)Math.rint(Math.random() * max_nr));
        System.out.println("Numbers: " + numbers);

        ex1_v1(numbers);
        ex1_v2(numbers, nr_threads);
        ex1_v3(numbers, nr_threads);
        ex1_v4(numbers, nr_threads);
        ex1_v5(numbers, nr_threads);
    }

    /* V1 */
    public static void ex2_v1(String in_file, String out_file, boolean write) {

        System.out.println("--------------------- Serial ---------------------\n");
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        long time = System.currentTimeMillis();

        /* read */
        try (BufferedReader reader = new BufferedReader(new FileReader(in_file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split(" |-|\\\\|\\.|\\?|!");
                for (String word : words) {
                    // Because empty spaces
                    if (word == null || word.length() == 0)
                        continue;
                    count += 1;
                    if (map.get(word) == null)
                        map.put(word, 1);
                    else
                        map.put(word, map.get(word) + 1);
                }
            }
        } catch (Exception e) {
            System.err.println("A crapat");
        }
        System.out.println("Serial took: " + (System.currentTimeMillis() - time) + " ms");
        System.out.println(map);

        /* write */
        if (write) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(out_file))) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    writer.write(entry.getKey() + ", ");
                    writer.write(String.valueOf(entry.getValue() * 100f / count) + System.lineSeparator());
                }
            } catch (Exception e) {
                System.err.println("A crapat");
            }
        }
    }

    /* V2 */
    public static void ex2_v2(String in_file, String out_file, int nr_threads) {

        System.out.println("--------------------- Array of threads + synchronized in thread ---------------------\n");
        Map<String, Integer> map = new HashMap<>();
        List<CountThread> threads = new ArrayList<>();
        File file = new File(in_file);
        while (file.length() / nr_threads > Integer.MAX_VALUE)
            nr_threads += 1;
        int chunk = (int)Math.ceil(file.length() / nr_threads);

        long time = System.currentTimeMillis();
        for (int i = 0; i < nr_threads; i++) {
            CountThread thr = new CountThread(map, in_file, i * chunk, chunk);
            threads.add(thr);
            thr.run();
        }
        for (CountThread thr : threads)
            try {
                thr.join();
            } catch (Exception e) { }
        System.out.println("Threads took: " + (System.currentTimeMillis() - time) + " ms");
        System.out.println(map);
    }

    public static void ex2(String in_file, String out_file, int nr_threads) {

        ex2_v1(in_file, out_file, true);
        ex2_v2(in_file, out_file, nr_threads);
    }

    public static void main(String[] args) {
        //ex1(50000, 20, 5);
        ex2("in.txt", "out.txt", 2);

    }
}
