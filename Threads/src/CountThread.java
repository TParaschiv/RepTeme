import java.io.*;
import java.util.Map;

public class CountThread extends Thread {

    private String f_name;
    private long f_start;
    private long chunk_size;
    private Map<String, Integer> map;

    public CountThread(Map<String, Integer> map, String f_name, long f_start, long chunk_size) {
        this.f_start = f_start;
        this.chunk_size = chunk_size;
        this.f_name = f_name;
        this.map = map;
    }

    private void addToMap(String word) {
        synchronized (map) {
            if (map.get(word) == null)
                map.put(word, 1);
            else
                map.put(word, map.get(word) + 1);
        }
    }

    @Override
    public void run() {

        String word = "";
        try (RandomAccessFile file = new RandomAccessFile(f_name, "r")) {

            /* Go back a word */
            if (f_start != 0) {
                int reverse = 0;
                while (true && f_start - reverse > 0) {
                    file.seek(f_start - reverse);
                    char ch = (char)file.readByte();
                    if (Character.isDigit(ch) || Character.isLetter(ch)) {
                        reverse += 1;
                        continue;
                    }
                    break;
                }
                if (f_start - reverse > 0)
                    reverse -= 1;
                f_start -= reverse;
                chunk_size += reverse;
            }

            /* Read */
            file.seek(f_start);
            while (chunk_size-- > 0) {
                char ch = (char)file.readByte();
                if (Character.isDigit(ch) || Character.isLetter(ch)) {
                    word += Character.toLowerCase(ch);
                }
                else {
                    if (!word.equals(""))
                        addToMap(word);
                    word = "";
                }
            }
            if (!word.equals("")) {
                char ch = (char)file.readByte();
                if (!(Character.isDigit(ch) || Character.isLetter(ch)))
                    addToMap(word);
                word = "";
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + f_name + " counld not be found");
        } catch (EOFException e) {
                if (!word.equals(""))
                    addToMap(word);
        } catch (IOException e) {
            System.err.println("IOException at " + f_name);
        }
    }
}
