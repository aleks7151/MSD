package com.work;

import java.util.Objects;

public class Cow {
    private Cow next;
    private final int cowId;
    private final String nickName;

    public Cow(Cow next, int cowId, String nickName) {
        this(cowId, nickName);
        this.next = next;
    }

    public Cow(int cowId, String nickName) {
        this.cowId = cowId;
        this.nickName = nickName;
    }

    public Cow getNext() {
        return next;
    }

    public int getCowId() {
        return cowId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNext(Cow next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("%d  %s%s", cowId, nickName, next == null ? "" : "\n" + next);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cow cow = (Cow) o;
        return cowId == cow.cowId && Objects.equals(nickName, cow.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cowId, nickName);
    }
}
