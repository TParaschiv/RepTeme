package com.endava.junit.process;

import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;
import static junit.framework.TestCase.assertNull;

@PrepareForTest(ProcessPattern.class)
public class SplitPatternTest {

    private SplitPattern pattern;

    @Before
    public void setUp() {
        pattern = new SplitPattern();
    }

    @Test
    public void testStringLengthNull() {
        String res = pattern.getStringLength(null);
        assertNull(res);
    }

    @Test
    public void testStringLengthSmall() {
        String res = pattern.getStringLength("ceva");
        assertSame("small", res);
    }

    @Test
    public void testStringLengthMedium() {
        String res = pattern.getStringLength("123456789");
        assertSame("medium", res);
    }

    @Test
    public void testStringLengthLong() {
        /*//Trying out mock
        pattern = Mockito.mock(SplitPattern.class);
        Mockito.when(
                pattern.getStringLength("123456789012345"))
                .thenReturn("medium");
        */
        String res = pattern.getStringLength("123456789012345");
        assertSame("long", res);
    }

    @Test
    public void testSplitByLength() {
        List<String> list = new ArrayList<String>();
        list.add("1234");
        list.add("");
        list.add("12345");
        list.add(null);
        list.add("1234567890123456");
        List<String> results = new ArrayList<String>();
        results.add("small");
        results.add("small");
        results.add("medium");
        results.add(null);
        results.add("long");
        List<String> res = pattern.splitByLength(list);
        assertEquals(results, res);
    }
}
