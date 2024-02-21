package ru.vyatsu.weatherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyatsu.weatherservice.model.HumDatum;

import java.util.List;

@Repository
public interface HumDatumRepository extends JpaRepository<HumDatum, Integer> {

    List<HumDatum> findAllByOrderByCreatedAtAsc();
}