package visitor;

import java.util.List;

public class WordCountVisitor implements Visitor {
    @Override
    public int visit(Document doc) {
        List<String> lines = doc.getLines();
        int cnt = 0;
        for(String line : lines) {
            String[] words = line.split(" ");
            for (String word : words)
                if (word != null && word.length() > 0)
                    cnt += 1;
        }
        return cnt;
    }
}
