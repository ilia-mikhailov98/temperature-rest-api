package study.temperaturerestapi.model.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SensorDTO {

    @NotEmpty
    @Size(min = 3, max = 30, message = "Name should be al least 3 and not more than 30 symbols")
    private String name;

}
