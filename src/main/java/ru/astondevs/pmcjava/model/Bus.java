package ru.astondevs.pmcjava.model;

public class Bus {
    private final String number;
    private final String model;
    private final double mileage;

    private Bus(Builder builder) {
        this.number = builder.number;
        this.model = builder.model;
        this.mileage = builder.mileage;
    }

    public String getNumber() { return number; }

    public String getModel() { return model; }

    public double getMileage() { return mileage; }

    public static class Builder {
        private String number;
        private String model;
        private double mileage;

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setMileage(double mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() { return new Bus(this); }
    }
}