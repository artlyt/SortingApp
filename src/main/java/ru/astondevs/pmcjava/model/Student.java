package ru.astondevs.pmcjava.model;

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

        public Builder setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public Builder setAverageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
            return this;
        }

        public Builder setRecordBookNumber(int recordBookNumber) {
            this.recordBookNumber = recordBookNumber;
            return this;
        }

        public Student build() { return new Student(this); }
    }
}