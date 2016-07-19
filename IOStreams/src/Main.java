import java.io.*;
import java.util.Stack;
import java.util.jar.Pack200;

public class Main {

    static int ex1(String f_name, long pos) {
        int count = 0;
        try (RandomAccessFile reader = new RandomAccessFile(f_name, "r")) {
            reader.seek(pos);
            int ch;
            while ((ch = reader.read()) != -1) {
                if ((char)ch == 'a')
                    count += 1;
            }
        } catch (Exception e) {
            System.err.println("Caught " + e);
        } finally {
            return count;
        }

    }

    static void ex2(String f_name) {
        Stack<String> stack = new Stack<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(f_name))) {
            String line;
            while((line = reader.readLine()) != null) {
                for (String str : line.split(" ")) {
                    stack.push(str);
                    stack.push(" ");
                }
                stack.pop();
                stack.push(System.lineSeparator());
            }
            while (!stack.empty()) {
                System.out.print(stack.pop());
            }
        } catch (Exception e) {
            System.err.println("Caught " + e);
        }
    }

    static void ex3Recursion(File file, String space) {

        if (file.exists()) {
           if (file.isDirectory()) {
               System.out.println(space + file.getName() + "\\");
               space += "\t";
               for (File f : file.listFiles()) {
                   ex3Recursion(f, space);
               }
           } else {
               System.out.println(space + file.getName());
           }
       }
       else System.out.println(file.getName() + " does not exist");
    }

    static void ex3(String f_name) {
        File file;
        try {
            file = new File(f_name);
            String space = "";

            if (file.exists()) {
                String[] path = file.getAbsolutePath().split("\\\\");
                for (int i = 0; i < path.length - 1; i++) {
                    System.out.println(space + path[i] + "\\");
                    if (i > 0)
                        space += "\t";
                }
                ex3Recursion(file, space);
            }
        } catch (Exception e) {
            System.err.println("Caught " + e);
        }

    }

    public static void main(String[] args) {
        /* Ex 1 */
        System.out.println("---------------- Ex 1 ----------------");
        System.out.println("Got " + ex1("ex1.txt", 2) + " occurrences of 'a'");
        System.out.println();
        /* Ex 2 */
        System.out.println("---------------- Ex 2 ----------------");
        ex2("ex1.txt");
        System.out.println();
        /* Ex 3 */
        System.out.println("---------------- Ex 3 ----------------");
        ex3("dir1");
    }
}
