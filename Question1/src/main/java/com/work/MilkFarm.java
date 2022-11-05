package com.work;

import java.util.LinkedList;

public class MilkFarm {
    private static MilkFarm milkFarm;
    private final LinkedList<Cow> cows;

    private MilkFarm() {
        cows = new LinkedList<>() {{
            add(new Cow(1, "Main Cow"));
        }};
    }

    public static MilkFarm getMilkFarm() {
        if (milkFarm == null)
            milkFarm = new MilkFarm();
        return milkFarm;
    }

    /**
     * This method creates a new cow and adds to list. A new cow is not created, if the potential parent already has
     * a child or a child with the same Id is already in the list.
     * It follows from the first condition that we can only add a new cow in the end of the list.
     *
     * @param parentCowId   parent Id
     * @param childCowId    child Id
     * @param childNickName child Name
     * @return if child was created, return true
     */
    public boolean giveBirth(int parentCowId, int childCowId, String childNickName) {
        if (cows.getLast().cowId() != parentCowId ||
                cows.stream().filter(cow -> cow.cowId() == childCowId).findAny().orElse(null) != null)
            return false;
        cows.addLast(new Cow(childCowId, childNickName));
        return true;
    }

    public boolean endLifeSpan(int cowId) {
        for (int i = 1; i < cows.size(); i++) {
            if (cows.get(i).cowId() == cowId) {
                cows.remove(i);
                return true;
            }
        }
        return false;
    }

    public Cow getCowById(int id) {
        return cows.stream().filter(cow -> cow.cowId() == id).findAny().orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        cows.forEach(cow -> builder.append(cow).append('\n'));
        return builder.toString();
    }
}
