package study.temperaturerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.temperaturerestapi.model.Measurement;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {

}
