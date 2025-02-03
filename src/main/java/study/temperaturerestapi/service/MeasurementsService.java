package study.temperaturerestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.temperaturerestapi.model.Measurement;
import study.temperaturerestapi.model.Sensor;
import study.temperaturerestapi.repository.MeasurementsRepository;
import study.temperaturerestapi.repository.SensorsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;
    private final SensorsRepository sensorsRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorsRepository sensorsRepository) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsRepository = sensorsRepository;
    }

    @Transactional
    public void addMeasurement(Measurement measurement) {
        Optional<Sensor> sensor = sensorsRepository.findByName(measurement.getSensor().getName());
        measurement.setSensor(sensor.get());
        measurement.setDate(LocalDateTime.now());

        measurementsRepository.save(measurement);
    }

	@Transactional(readOnly = true)
    public List<Measurement> findAll() {
        return measurementsRepository.findAll();
    }

	@Transactional
    public int countRainyDays() {
        List<Measurement> measurements = measurementsRepository.findAll();

        return measurements.stream()
                .filter(Measurement::getRaining)
                .map(Measurement::getDate)
                .map(LocalDateTime::getDayOfYear)
                .collect(Collectors.toSet())
                .size();
    }
}
