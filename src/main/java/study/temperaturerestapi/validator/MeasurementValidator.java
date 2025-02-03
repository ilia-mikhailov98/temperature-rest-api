package study.temperaturerestapi.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import study.temperaturerestapi.exception.SensorNotRegisteredException;
import study.temperaturerestapi.model.dto.MeasurementDTO;
import study.temperaturerestapi.repository.SensorsRepository;

@Component
public class MeasurementValidator implements Validator {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public MeasurementValidator(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MeasurementDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementDTO measurementDTO = (MeasurementDTO) target;

        if (measurementDTO.getSensor() == null) {
            return;
        }
        
        String sensorName = measurementDTO.getSensor().getName();

        if (sensorsRepository.findByName(sensorName).isEmpty()) {
            throw new SensorNotRegisteredException(String.format("Sensor with name '%s' is not registered", sensorName));
        }
    }

}
