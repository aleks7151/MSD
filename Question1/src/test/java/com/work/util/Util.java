package com.work.util;

import com.work.Cow;
import com.work.MilkFarm;

import java.lang.reflect.Field;
import java.util.LinkedList;

public class Util {
    public static LinkedList<Cow> getCows(MilkFarm milkFarm) throws NoSuchFieldException, IllegalAccessException {
        Field field = milkFarm.getClass().getDeclaredField("cows");
        field.setAccessible(true);
        return (LinkedList<Cow>) field.get(milkFarm);
    }

    public static void clearMilkFarm() throws NoSuchFieldException, IllegalAccessException {
        Field field = MilkFarm.class.getDeclaredField("milkFarm");
        field.setAccessible(true);
        field.set(null, null);
    }

    public static void setRandomNextValues(LinkedList<Cow> cows) {
        cows.add(new Cow(2, "Aleks"));
        cows.add(new Cow(3, "Nice Cow"));
        cows.add(new Cow(4, "Bad Cow"));
        cows.add(new Cow(5, "Usual Cow"));
    }
}
