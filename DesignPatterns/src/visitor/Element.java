package visitor;

public interface Element {
    public int accept(Visitor visitor);
}
