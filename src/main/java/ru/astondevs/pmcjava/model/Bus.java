package ru.astondevs.pmcjava.model;

import ru.astondevs.pmcjava.validation.*;

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
        private final ValidationErrorCollector errorCollector = new ValidationErrorCollector();

        public Builder setNumber(String number) {
            this.number = number;
            NumberValidator validator = new NumberValidator();
            errorCollector.collectError(validator.validate(number));
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            ModelValidator validator = new ModelValidator();
            errorCollector.collectError(validator.validate(model));
            return this;
        }

        public Builder setMileage(double mileage) {
            this.mileage = mileage;
            MileageValidator validator = new MileageValidator();
            errorCollector.collectError(validator.validate(mileage));
            return this;
        }

        public Bus build() {
            errorCollector.throwIfErrors();
            return new Bus(this);
        }
    }
}