package study.temperaturerestapi.mapper;

import org.modelmapper.ModelMapper;
import study.temperaturerestapi.model.Sensor;
import study.temperaturerestapi.model.dto.SensorDTO;

public class SensorMapper {

    private final static ModelMapper mapper = new ModelMapper();

    public static Sensor fromDTO(SensorDTO sensorDTO) {
        return mapper.map(sensorDTO, Sensor.class);
    }

}
