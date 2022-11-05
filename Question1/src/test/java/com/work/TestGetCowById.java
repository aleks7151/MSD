package com.work;

import com.work.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestGetCowById {
    private LinkedList<Cow> cows;
    private MilkFarm milkFarm;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        milkFarm = MilkFarm.getMilkFarm();
        cows = Util.getCows(MilkFarm.getMilkFarm());
        Util.setRandomNextValues(cows);
    }

    @Test
    public void testGetCowById() {
        assertEquals(new Cow(1, "Main Cow"), milkFarm.getCowById(1));
        assertEquals(new Cow(5, "Usual Cow"), milkFarm.getCowById(5));
        assertNull(milkFarm.getCowById(12));
    }

    @After
    public void after() throws NoSuchFieldException, IllegalAccessException {
        Util.clearMilkFarm();
    }
}
