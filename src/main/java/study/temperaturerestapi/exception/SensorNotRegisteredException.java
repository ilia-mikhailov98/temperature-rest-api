package study.temperaturerestapi.exception;

public class SensorNotRegisteredException extends RuntimeException {

    public SensorNotRegisteredException(String message) {
        super(message);
    }

}
