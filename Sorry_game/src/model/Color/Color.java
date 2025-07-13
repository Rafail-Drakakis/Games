package model.Color;

public enum Color {
    RED("red"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue");

    private final String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
