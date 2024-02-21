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
@Table(name = "hum_data")
public class HumDatum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "hum_value", precision = 10, scale = 1)
    private BigDecimal humValue;

    @Column(name = "created_at")
    private Instant createdAt;

    public HumDatum(BigDecimal humValue, Instant createdAt) {
        this.humValue = humValue;
        this.createdAt = createdAt;
    }
}