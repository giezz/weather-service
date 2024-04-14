package ru.vyatsu.weatherservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class TemperatureData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private BigDecimal temperatureValue;

    @Column
    private Instant createdAt;

    public TemperatureData(BigDecimal temperatureValue, Instant createdAt) {
        this.temperatureValue = temperatureValue;
        this.createdAt = createdAt;
    }
}