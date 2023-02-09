package study.temperaturerestapi.exception;

public class InvalidSensorBodyException extends RuntimeException {

    public InvalidSensorBodyException(String message) {
        super(message);
    }

}
