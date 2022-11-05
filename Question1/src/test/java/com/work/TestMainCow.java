package com.work;

import com.work.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class TestMainCow {
    private static final int SIZE_COWS = 1;
    private static final int COW_ID = 1;
    private static final String COW_NICK_NAME = "Main Cow";
    private LinkedList<Cow> cows;
    private MilkFarm milkFarm;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        milkFarm = MilkFarm.getMilkFarm();
        cows = Util.getCows(milkFarm);
    }

    @Test
    public void testMainCow() {
        milkFarm.endLifeSpan(1);
        assertEquals(SIZE_COWS, cows.size());
        assertEquals(COW_ID, cows.get(0).cowId());
        assertEquals(COW_NICK_NAME, cows.get(0).nickName());
    }

    @After
    public void after() throws NoSuchFieldException, IllegalAccessException {
        Util.clearMilkFarm();
    }
}
