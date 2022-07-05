package ru.gerch.streamPractise.utils;

public enum Condition {
    NEW("NEW"),
    USED("USED"),
    BROKEN("BROKEN");

    private final String condition;


    Condition(String status) {
        this.condition = status;
    }

    public String getText() {
        return this.condition;
    }

    public static Condition fromString(String text) {
        for (Condition b : Condition.values()) {
            if (b.condition.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
