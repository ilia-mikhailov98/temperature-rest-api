package study.temperaturerestapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MeasurementDTO {

    @NotNull
    @Min(value = -100, message = "Value should be at least -100")
    @Max(value = 100, message = "Value should not be greater than 100")
    private Double value;

    @NotNull(message = "'Raining' should not be null")
    private Boolean raining;

    @NotNull(message = "'Sensor' should not be null")
    private SensorDTO sensor;

}
