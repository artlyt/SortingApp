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


    public static final String DESCRIPTION_SORT_BUSES = """
                                Введите порядок сортировки, где
                                1 - Номерной знак
                                2 - Модель
                                3 - Пробег
                                """;

    public static final String DESCRIPTION_SORT_STUDENTS = """
                                Введите порядок сортировки, где
                                1 - Номер группы
                                2 - Средний балл
                                3 - Номер зачетной книжки
                                """;

    public static final String DESCRIPTION_SORT_USERS = """
                                Введите порядок сортировки, где
                                1 - Имя
                                2 - Пароль
                                3 - email
                                """;

}
