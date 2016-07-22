package letter.mapping;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<LetterMapping> mapLetters() {
        List<LetterMapping> map = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.add(new LetterMapping(String.valueOf(ch), ch - 'a' + 1));
        }
        return map;
    }

    public static void main(String[] args) {

        /* -------------- Ex1 --------------  */
        System.out.println(" -------------- Ex1 -------------- ");
        System.out.println(mapLetters());
    }
}
