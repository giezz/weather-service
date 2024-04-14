package ru.vyatsu.weatherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyatsu.weatherservice.model.LightData;

import java.util.List;

@Repository
public interface LightDataRepository extends JpaRepository<LightData, Integer> {
    List<LightData> findAllByOrderByCreatedAtAsc();
}