package com.work;

import com.work.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestToString {
    private MilkFarm milkFarm;
    private Cow mainCow;

    private static final String STRING = """
            1  Main Cow
            2  Aleks
            3  Nice Cow
            4  Bad Cow
            5  Usual Cow""";

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        milkFarm = MilkFarm.getMilkFarm();
        mainCow = Util.getMainCow(MilkFarm.getMilkFarm());
        Util.setRandomNextValues(mainCow);
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
