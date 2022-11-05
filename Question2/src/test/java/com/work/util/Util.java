package com.work.util;

import com.work.Cow;
import com.work.MilkFarm;

import java.lang.reflect.Field;

public class Util {
    public static Cow getMainCow(MilkFarm milkFarm) throws NoSuchFieldException, IllegalAccessException {
        Field field = milkFarm.getClass().getDeclaredField("mainCow");
        field.setAccessible(true);
        return (Cow) field.get(milkFarm);
    }

    public static void clearMilkFarm() throws NoSuchFieldException, IllegalAccessException {
        Field field = MilkFarm.class.getDeclaredField("milkFarm");
        field.setAccessible(true);
        field.set(null, null);
    }

    public static int getSizeCows(Cow cow) {
        int size = 0;
        while (cow != null) {
            size++;
            cow = cow.getNext();
        }
        return size;
    }

    public static void setRandomNextValues(Cow mainCow) {
        Cow cow5 = new Cow(null, 5, "Usual Cow");
        Cow cow4 = new Cow(cow5, 4, "Bad Cow");
        Cow cow3 = new Cow(cow4, 3, "Nice Cow");
        Cow cow2 = new Cow(cow3, 2, "Aleks");
        mainCow.setNext(cow2);
    }
}
