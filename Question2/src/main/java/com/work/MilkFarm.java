package com.work;

public class MilkFarm {
    private static MilkFarm milkFarm;
    private final Cow mainCow;

    private MilkFarm() {
        mainCow = new Cow(null, 1, "Main Cow");
    }

    public static MilkFarm getMilkFarm() {
        if (milkFarm == null)
            milkFarm = new MilkFarm();
        return milkFarm;
    }

    /**
     * This method creates a new cow and adds to chain of cows. A new cow is not created, if the potential parent
     * already has a child or a child with the same Id is already exist in the chain of cows.
     * It follows from the first condition that we can only add a new cow in the end of the chain of cows.
     *
     * @param parentCowId   parent Id
     * @param childCowId    child Id
     * @param childNickName child Name
     * @return if child was created, return true
     */
    public boolean giveBirth(int parentCowId, int childCowId, String childNickName) {
        Cow cow = mainCow;
        while (cow.getNext() != null) {
            if (cow.getCowId() == childCowId)
                return false;
            cow = cow.getNext();
        }
        if (cow.getCowId() == childCowId || cow.getCowId() != parentCowId)
            return false;
        cow.setNext(new Cow(null, childCowId, childNickName));
        return true;
    }

    public boolean endLifeSpan(int cowId) {
        Cow cow = mainCow.getNext();
        Cow previousCow = mainCow;
        while (cow != null) {
            if (cow.getCowId() == cowId) {
                previousCow.setNext(cow.getNext());
                return true;
            }
            previousCow = cow;
            cow = cow.getNext();
        }
        return false;
    }

    public Cow getCowById(int id) {
        Cow cow = mainCow;
        while (cow != null) {
            if (cow.getCowId() == id)
                return cow;
            cow = cow.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        return mainCow.toString();
    }
}
