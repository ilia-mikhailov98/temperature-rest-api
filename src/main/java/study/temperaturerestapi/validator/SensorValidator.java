package study.temperaturerestapi.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import study.temperaturerestapi.exception.SensorAlreadyRegisteredException;
import study.temperaturerestapi.model.dto.SensorDTO;
import study.temperaturerestapi.repository.SensorsRepository;

@Component
public class SensorValidator implements Validator {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorValidator(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SensorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensor = (SensorDTO) target;

        if (sensorsRepository.findByName(sensor.getName()).isPresent()) {
           throw new SensorAlreadyRegisteredException(String.format("Sensor with name '%s' is already registered", sensor.getName()));
        }
    }

}
