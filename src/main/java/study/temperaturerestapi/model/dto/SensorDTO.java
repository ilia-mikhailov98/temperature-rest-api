package study.temperaturerestapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SensorDTO {

    @NotEmpty
    @Size(min = 3, max = 30, message = "Name should be al least 3 and not more than 30 symbols")
    private String name;

}
