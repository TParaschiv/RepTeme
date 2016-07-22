package visitor;

import java.util.List;

public class CharacterCountVisitor implements Visitor {
    @Override
    public int visit(Document doc) {
        List<String> lines = doc.getLines();
        int cnt = 0;
        for (String line : lines)
            cnt += line.length();
        return cnt;
    }
}
