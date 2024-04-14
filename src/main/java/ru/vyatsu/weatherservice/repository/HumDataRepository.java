package ru.vyatsu.weatherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyatsu.weatherservice.model.HumData;

import java.util.List;

@Repository
public interface HumDataRepository extends JpaRepository<HumData, Integer> {

    List<HumData> findAllByOrderByCreatedAtAsc();
}