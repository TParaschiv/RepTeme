package visitor;

import java.util.ArrayList;
import java.util.List;

public class Document implements Element{

    private List<String> lines;

    public Document() {
        this.lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        String ret = "";
        for (String line : lines)
            ret += line + System.lineSeparator();
        return ret;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
