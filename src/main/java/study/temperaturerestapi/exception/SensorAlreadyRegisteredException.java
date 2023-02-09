package study.temperaturerestapi.exception;

public class SensorAlreadyRegisteredException extends RuntimeException {

    public SensorAlreadyRegisteredException(String message) {
        super(message);
    }

}
