package visitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DocumentReader {

    static Document readDocument(String f_name) {
        Document ret = new Document();

        try (BufferedReader reader = new BufferedReader(new FileReader(f_name))) {
            String line;
            while((line = reader.readLine()) != null)
                ret.addLine(line);
        } catch (FileNotFoundException e) {
            System.err.println("File " + f_name + " not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return ret;
    }
}
