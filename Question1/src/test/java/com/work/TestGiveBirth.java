package com.work;

import com.work.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class TestGiveBirth {
    private static final int SIZE_COWS = 6;

    private LinkedList<Cow> cows;
    private MilkFarm milkFarm;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        milkFarm = MilkFarm.getMilkFarm();
        cows = Util.getCows(MilkFarm.getMilkFarm());
    }

    @Test
    public void testGiveBirth() {
        assertTrue(milkFarm.giveBirth(1, 2, "Nick"));
        assertFalse(milkFarm.giveBirth(1, 3, "Rocky"));
        assertTrue(milkFarm.giveBirth(2, 3, "Aleks"));
        assertFalse(milkFarm.giveBirth(3, 2, "Diana"));
        assertTrue(milkFarm.giveBirth(3, 4, "Nice Cow"));
        assertTrue(milkFarm.giveBirth(4, 5, "Bad Cow"));
        assertTrue(milkFarm.giveBirth(5, 6, "Usual Cow"));

        assertEquals(SIZE_COWS, cows.size());
    }

    @After
    public void after() throws NoSuchFieldException, IllegalAccessException {
        Util.clearMilkFarm();
    }
}
