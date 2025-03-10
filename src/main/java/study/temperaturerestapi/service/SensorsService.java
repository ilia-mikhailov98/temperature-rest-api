package study.temperaturerestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.temperaturerestapi.model.Sensor;
import study.temperaturerestapi.repository.SensorsRepository;

@Service
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    @Transactional
    public void registerSensor(Sensor sensor) {
        sensorsRepository.save(sensor);
    }

}
