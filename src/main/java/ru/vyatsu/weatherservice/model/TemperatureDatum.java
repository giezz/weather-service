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
@Table(name = "temperature_data")
public class TemperatureDatum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "temperature_value", precision = 10, scale = 1)
    private BigDecimal temperatureValue;

    @Column(name = "created_at")
    private Instant createdAt;


    public TemperatureDatum(BigDecimal temperatureValue, Instant createdAt) {
        this.temperatureValue = temperatureValue;
        this.createdAt = createdAt;
    }
}