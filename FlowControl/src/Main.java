import java.util.ArrayList;
import java.util.List;

/**
 * Created by tparaschiv on 7/14/2016.
 */
public class Main {

    public static boolean monkeyTrouble (boolean aSmile, boolean bSmile) {
        return aSmile == bSmile;
    }

    public static boolean parrotTrouble (boolean talking, int hour) {
        if(hour < 0 || hour > 23)
            return false;
        return talking && (hour < 7 || hour > 20);
    }

    public static boolean posNeg(int a, int b, boolean negative) {
        if(negative)
            return a < 0 && b < 0;
        return a * b < 0;
    }

    public static String backAround(String str) {
        String last_char = str.substring(str.length()-1, str.length());
        return last_char.concat(str.concat(last_char));
    }

    public static String everyNth(String str, int n) {
        String temp = str.substring(0, 1);
        for(int i = n; i < str.length(); i+= n)
            temp = temp.concat(str.substring(i, i + 1));
        return temp;
    }

    public static boolean scoresIncreasing(int[] scores) {
        for(int i = 1; i < scores.length; i++)
            if(scores[i] < scores[i-1])
                return false;
        return true;
    }

    public static int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for(int i = start+1; i <= end; i++)
            sum += Math.abs(heights[i-1] - heights[i]);
        return sum;
    }

    public static void outOfMem() throws OutOfMemoryError {
        throw new OutOfMemoryError();
    }

    public static void stackOverflow() throws StackOverflowError {
        throw new StackOverflowError();
    }

    public static void main (String[] args) {

        Calculator calc = new Calculator();
        List<Integer> elems = new ArrayList<Integer>();

        elems.add(10);
        elems.add(40);
        try {
            System.out.println(calc.average(elems));
            return;
        } catch (OverflowException e) {
            System.out.println("Overflow Exception");
        } catch (UnderflowException e) {
            System.out.println("Underflow Exception");
        } finally {
            System.out.println("Finally");
        }
    }
}
