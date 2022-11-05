package com.work;

import com.work.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class TestEndLifeSpan {
    private LinkedList<Cow> cows;
    private MilkFarm milkFarm;

    private static final int SIZE = 3;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        milkFarm = MilkFarm.getMilkFarm();
        cows = Util.getCows(MilkFarm.getMilkFarm());
        Util.setRandomNextValues(cows);
    }

    @Test
    public void testEndLifeSpan() {
        assertTrue(milkFarm.endLifeSpan(2));
        assertTrue(milkFarm.endLifeSpan(3));
        assertFalse(milkFarm.endLifeSpan(3));
        assertFalse(milkFarm.endLifeSpan(22));
        assertEquals(SIZE, cows.size());
    }

    @After
    public void after() throws NoSuchFieldException, IllegalAccessException {
        Util.clearMilkFarm();
    }
}
