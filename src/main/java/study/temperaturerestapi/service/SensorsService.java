package study.temperaturerestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.temperaturerestapi.model.Sensor;
import study.temperaturerestapi.repository.SensorsRepository;

@Service
public class SensorsService {

    @Autowired
    SensorsRepository sensorsRepository;

	@Transactional
    public void registerSensor(Sensor sensor) {
        sensorsRepository.save(sensor);
    }

}
