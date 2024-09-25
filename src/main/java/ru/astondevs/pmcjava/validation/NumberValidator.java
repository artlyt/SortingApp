package ru.astondevs.pmcjava.validation;

public class NumberValidator implements Validator<String> {

    @Override
    public String validate(String busNumber) {
        if (isNull(busNumber)) {
            return "Номер не может быть null";
        }
        if (!isFormatValid(busNumber)) {
            return "Номер имеет неверный формат";
        }
        if (!isRegionValid(busNumber)) {
            return "Регион в номере некорректен";
        }
        return null;
    }

    private boolean isNull(String value) {
        return value == null;
    }

    private boolean isFormatValid(String busNumber) {
        String regex = "^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2}(\\d?)$";
        return busNumber.matches(regex);
    }

    private boolean isRegionValid(String busNumber) {
        String region = getRegionFromBusNumber(busNumber);
        return !(region.length() == 3 && region.charAt(0) == '0');
    }

    private String getRegionFromBusNumber(String busNumber) {
        return busNumber.substring(busNumber.length() - (busNumber.length() == 8 ? 2 : 3));
    }
}