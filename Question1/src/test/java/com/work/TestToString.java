package com.work;

import com.work.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class TestToString {
    private LinkedList<Cow> cows;
    private MilkFarm milkFarm;

    private static final String STRING = """
            1  Main Cow
            2  Aleks
            3  Nice Cow
            4  Bad Cow
            5  Usual Cow
            """;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        milkFarm = MilkFarm.getMilkFarm();
        cows = Util.getCows(MilkFarm.getMilkFarm());
        Util.setRandomNextValues(cows);
    }

    @Test
    public void testToString() {
        assertEquals(STRING, milkFarm.toString());
    }

    @After
    public void after() throws NoSuchFieldException, IllegalAccessException {
        Util.clearMilkFarm();
    }
}
