package study.temperaturerestapi.exception;

public class InvalidMeasurementBodyException extends RuntimeException {

    public InvalidMeasurementBodyException(String message) {
        super(message);
    }

}
