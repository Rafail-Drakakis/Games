package model.Square;

public enum SquareType {
    RED_HOME("redHome"),
    RED_SAFETY_ZONE("redSafetyZone"),
    RED_SLIDE_START("redSlideStart"),
    RED_SLIDE_MEDIUM("redSlideMedium"),
    RED_SLIDE_END("redSlideEnd"),
    BLUE_HOME("blueHome"),
    BLUE_SAFETY_ZONE("blueSafetyZone"),
    BLUE_SLIDE_START("blueSlideStart"),
    BLUE_SLIDE_MEDIUM("blueSlideMedium"),
    BLUE_SLIDE_END("blueSlideEnd"),
    GREEN_HOME("greenHome"),
    GREEN_SAFETY_ZONE("greenSafetyZone"),
    GREEN_SLIDE_START("greenSlideStart"),
    GREEN_SLIDE_MEDIUM("greenSlideMedium"),
    GREEN_SLIDE_END("greenSlideEnd"),
    YELLOW_HOME("yellowHome"),
    YELLOW_SAFETY_ZONE("yellowSafetyZone"),
    YELLOW_SLIDE_START("yellowSlideStart"),
    YELLOW_SLIDE_MEDIUM("yellowSlideMedium"),
    YELLOW_SLIDE_END("yellowSlideEnd"),
    SIMPLE_SQUARE("simpleSquare");

    private final String value;
    /**
     * Constructs a SquareType object with the specified value.
     *
     * @param value The value representing the type of square.
     */
    SquareType(String value) {
        this.value = value;
    }
    /**
     * Gets the value representing the type of square.
     *
     * @return The value representing the type of square.
     */
    public String getValue() {
        return value;
    }
}
