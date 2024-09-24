package ru.astondevs.pmcjava.validation;

public class BusNumberValidator implements Validator<String> {

    @Override
    public boolean validate(String busNumber) {
        return isFormatValid(busNumber) && isRegionValid(busNumber);
    }

    // Метод для проверки формата номера
    private boolean isFormatValid(String busNumber) {
        String regex = "^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2}(\\d?)$";
        return busNumber.matches(regex);
    }

    // Метод для проверки корректности региона
    private boolean isRegionValid(String busNumber) {
        String region = getRegionFromBusNumber(busNumber);
        return !(region.length() == 3 && region.charAt(0) == '0');
    }

    // Метод для получения региона из номера автобуса
    private String getRegionFromBusNumber(String busNumber) {
        return busNumber.substring(busNumber.length() - (busNumber.length() == 8 ? 2 : 3));
    }
}