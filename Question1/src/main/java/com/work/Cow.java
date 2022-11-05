package com.work;

public record Cow(int cowId, String nickName) {
    @Override
    public String toString() {
        return String.format("%d  %s", cowId, nickName);
    }
}
