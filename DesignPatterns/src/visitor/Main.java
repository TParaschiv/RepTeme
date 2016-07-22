package visitor;

public class Main {
    public static void main(String[] args) {
        /* -------------- Ex4 --------------  */
        System.out.println(" -------------- Ex4 -------------- ");
        Element document = DocumentReader.readDocument("text.txt");
        System.out.println("Word Count: " + document.accept(new WordCountVisitor()));
        System.out.println("Char Count: " + document.accept(new CharacterCountVisitor()));
    }
}
