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
public class LightData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private BigDecimal lightValue;

    @Column
    private Instant createdAt;

    public LightData(BigDecimal lightValue, Instant createdAt) {
        this.lightValue = lightValue;
        this.createdAt = createdAt;
    }
}