package com.endava.junit.process;
import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

@PrepareForTest(ProcessPattern.class)
public class ProcessPatternTest {

    private ProcessPattern pattern;

    @Before
    public void setUP() {
        pattern = new ProcessPattern();
    }

    @Test
    public void testUnderAge() {
        String res = pattern.generatePosition("junior", 0);
        assertNull(res);
    }

    @Test
    public void testNullPosition() {
        String res = pattern.generatePosition(null, 10);
        assertNull(res);
    }

    @Test
    public void testUnknownPosition() {
        String res = pattern.generatePosition("ceva", 10);
        assertSame("Unknown Position", res);
    }

    @Test
    public void testJuniorPass() {
        String res = pattern.generatePosition("junior", 10);
        assertSame("Junior Developer", res);
    }

    @Test
    public void testDev1Pass() {
        String res = pattern.generatePosition("middle", 1);
        assertSame("Developer 1", res);
    }

    @Test
    public void testDev2Pass() {
        String res = pattern.generatePosition("middle", 3);
        assertSame("Developer 2", res);
    }

    @Test
    public void testSenior1Pass() {
        String res = pattern.generatePosition("senior", 3);
        assertSame("Senior 1", res);
    }

    @Test
    public void testSenior2Pass() {
        String res = pattern.generatePosition("senior", 6);
        assertSame("Senior 2", res);
    }
}
