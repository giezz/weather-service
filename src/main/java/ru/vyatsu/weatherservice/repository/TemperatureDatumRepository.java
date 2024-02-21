package ru.vyatsu.weatherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyatsu.weatherservice.model.TemperatureDatum;

import java.util.List;

@Repository
public interface TemperatureDatumRepository extends JpaRepository<TemperatureDatum, Integer> {
    List<TemperatureDatum> findAllByOrderByCreatedAtAsc();
}