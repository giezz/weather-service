package ru.vyatsu.weatherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyatsu.weatherservice.model.TemperatureData;

import java.util.List;

@Repository
public interface TemperatureDataRepository extends JpaRepository<TemperatureData, Integer> {
    List<TemperatureData> findAllByOrderByCreatedAtAsc();
}