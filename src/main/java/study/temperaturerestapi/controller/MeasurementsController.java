package study.temperaturerestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import study.temperaturerestapi.exception.InvalidMeasurementBodyException;
import study.temperaturerestapi.exception.response.MeasurementErrorResponse;
import study.temperaturerestapi.mapper.MeasurementMapper;
import study.temperaturerestapi.model.Measurement;
import study.temperaturerestapi.model.dto.MeasurementDTO;
import study.temperaturerestapi.service.MeasurementsService;
import study.temperaturerestapi.validator.MeasurementValidator;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    @Autowired
    private MeasurementsService measurementsService;

    @Autowired
    private MeasurementValidator measurementValidator;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult) {
        measurementValidator.validate(measurementDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(". "));

            throw new InvalidMeasurementBodyException(message);
        }

        Measurement measurement = MeasurementMapper.fromDTO(measurementDTO);
        measurementsService.addMeasurement(measurement);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public List<MeasurementDTO> getAllMeasurements() {
        return measurementsService.findAll()
                .stream()
                .map(MeasurementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/rainyDaysCount")
    public int countRainyDays() {
        return measurementsService.countRainyDays();
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(InvalidMeasurementBodyException exception) {
        MeasurementErrorResponse response = new MeasurementErrorResponse();

        response.setMessage(exception.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
