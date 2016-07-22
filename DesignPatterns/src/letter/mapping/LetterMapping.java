package letter.mapping;

public class LetterMapping {

    private String letter;
    private Number number;

    public LetterMapping(String letter, Number number) {
        this.letter = letter;
        this.number = number;
    }

    @Override
    public String toString() {
        return letter + ":" + number;
    }
}
