package ru.astondevs.pmcjava.functional;

public class TextMenu {
    private TextMenu() {
    }
    public static final String CREATE_COLLECTION = """
                === Choose type ===
                1. Buses
                2. Users
                3. Students
                Choose an option:""";
    public static final String SEPARATOR = "::";

    public static final String STOP ="STOP";

    public static final String TYPE_INPUT = """
            ==Select input type
            1. Keyboard
            2. Read File
            3. Random generation
            """;

}
