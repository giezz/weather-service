package ru.vyatsu.weatherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyatsu.weatherservice.model.LightDatum;

import java.util.List;

@Repository
public interface LightDatumRepository extends JpaRepository<LightDatum, Integer> {
    List<LightDatum> findAllByOrderByCreatedAtAsc();
}