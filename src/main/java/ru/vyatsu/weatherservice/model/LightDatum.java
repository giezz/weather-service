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
@Table(name = "light_data")
public class LightDatum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "light_value", precision = 10, scale = 1)
    private BigDecimal lightValue;

    @Column(name = "created_at")
    private Instant createdAt;

    public LightDatum(BigDecimal lightValue, Instant createdAt) {
        this.lightValue = lightValue;
        this.createdAt = createdAt;
    }
}