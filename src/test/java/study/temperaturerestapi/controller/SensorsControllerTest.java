package study.temperaturerestapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import study.temperaturerestapi.model.dto.SensorDTO;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // TODO: do not build the whole context
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class SensorsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void can_not_register_a_sensor_with_the_same_name() throws Exception {
        SensorDTO sensorDTO = SensorDTO.builder()
                .name("some long name")
                .build();

        mockMvc.perform(post("/sensors/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(sensorDTO)))
                .andExpect(status().isOk());

        mockMvc.perform(post("/sensors/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(sensorDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", containsString("is already registered")));
    }

}