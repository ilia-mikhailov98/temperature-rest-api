package study.temperaturerestapi.mapper;

import org.modelmapper.ModelMapper;
import study.temperaturerestapi.model.Measurement;
import study.temperaturerestapi.model.dto.MeasurementDTO;

public class MeasurementMapper {

    private final static ModelMapper mapper = new ModelMapper();

//    TODO
    public static Measurement fromDTO(MeasurementDTO measurementDTO) {
        return mapper.map(measurementDTO, Measurement.class);
    }

    //    TODO
    public static MeasurementDTO toDTO(Measurement measurement) {
        return mapper.map(measurement, MeasurementDTO.class);
    }

}
