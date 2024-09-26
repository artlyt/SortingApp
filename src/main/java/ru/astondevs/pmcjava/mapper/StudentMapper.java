package ru.astondevs.pmcjava.mapper;

import ru.astondevs.pmcjava.model.Student;

public class StudentMapper {
    private StudentMapper() {
    }

    public static Student map(int groupNumber, double averageGrade, int recordBookNumber) {
    return new Student.Builder()
            .setGroupNumber(groupNumber)
            .setAverageGrade(averageGrade)
            .setRecordBookNumber(recordBookNumber)
            .build();
    }
}
