package ru.astondevs.pmcjava.model;

import ru.astondevs.pmcjava.validation.GradeValidator;
import ru.astondevs.pmcjava.validation.GroupNumberValidator;
import ru.astondevs.pmcjava.validation.RecordBookNumberValidator;
import ru.astondevs.pmcjava.validation.ValidationErrorCollector;

public class Student {
    private final int groupNumber;
    private final double averageGrade;
    private final int recordBookNumber;

    private Student(Builder builder) {
        this.groupNumber = builder.groupNumber;
        this.averageGrade = builder.averageGrade;
        this.recordBookNumber = builder.recordBookNumber;
    }

    public int getGroupNumber() { return groupNumber; }

    public double getAverageGrade() { return averageGrade; }

    public int getRecordBookNumber() { return recordBookNumber; }

    public static class Builder {
        private int groupNumber;
        private double averageGrade;
        private int recordBookNumber;
        private final ValidationErrorCollector errorCollector = new ValidationErrorCollector();

        public Builder setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            GroupNumberValidator validator = new GroupNumberValidator();
            errorCollector.collectError(validator.validate(groupNumber));
            return this;
        }

        public Builder setAverageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
            GradeValidator validator = new GradeValidator();
            errorCollector.collectError(validator.validate(averageGrade));
            return this;
        }

        public Builder setRecordBookNumber(int recordBookNumber) {
            this.recordBookNumber = recordBookNumber;
            RecordBookNumberValidator validator = new RecordBookNumberValidator();
            errorCollector.collectError(validator.validate(recordBookNumber));
            return this;
        }

        public Student build() {
            errorCollector.throwIfErrors();
            return new Student(this);
        }
    }
}