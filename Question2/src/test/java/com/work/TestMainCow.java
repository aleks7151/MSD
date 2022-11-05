package com.work;

import com.work.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMainCow {
    private static final int SIZE_COWS = 1;
    private static final int COW_ID = 1;
    private static final String COW_NICK_NAME = "Main Cow";
    private Cow mainCow;
    private MilkFarm milkFarm;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        milkFarm = MilkFarm.getMilkFarm();
        mainCow = Util.getMainCow(milkFarm);
    }

    @Test
    public void testMainCow() {
        milkFarm.endLifeSpan(1);
        int size = Util.getSizeCows(mainCow);

        assertEquals(SIZE_COWS, size);
        assertEquals(COW_ID, mainCow.getCowId());
        assertEquals(COW_NICK_NAME, mainCow.getNickName());
    }

    @After
    public void after() throws NoSuchFieldException, IllegalAccessException {
        Util.clearMilkFarm();
    }
}
