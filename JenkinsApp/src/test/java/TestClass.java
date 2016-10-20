import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import static junit.framework.TestCase.assertEquals;

@PrepareForTest(DummyClass.class)
public class TestClass {

    @Test
    public void testRight() {
        assertEquals(DummyClass.greater(13, 14), 14);
    }

    @Test
    public void testLeft() {
        assertEquals(DummyClass.greater(14, 13), 14);
    }

    @Test
    public void testEquals() {
        assertEquals(DummyClass.greater(14, 14), 14);
    }
}
