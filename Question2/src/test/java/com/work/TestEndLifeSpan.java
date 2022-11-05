package com.work;

import com.work.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestEndLifeSpan {
    private Cow mainCow;
    private MilkFarm milkFarm;

    private static final int SIZE = 3;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        milkFarm = MilkFarm.getMilkFarm();
        mainCow = Util.getMainCow(MilkFarm.getMilkFarm());
        Util.setRandomNextValues(mainCow);
    }

    @Test
    public void testEndLifeSpan() {
        assertTrue(milkFarm.endLifeSpan(2));
        assertTrue(milkFarm.endLifeSpan(3));
        assertFalse(milkFarm.endLifeSpan(3));
        assertFalse(milkFarm.endLifeSpan(22));
        assertEquals(SIZE, Util.getSizeCows(mainCow));
    }

    @After
    public void after() throws NoSuchFieldException, IllegalAccessException {
        Util.clearMilkFarm();
    }
}
