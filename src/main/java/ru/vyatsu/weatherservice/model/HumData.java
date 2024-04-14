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
public class HumData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private BigDecimal humValue;

    @Column
    private Instant createdAt;

    public HumData(BigDecimal humValue, Instant createdAt) {
        this.humValue = humValue;
        this.createdAt = createdAt;
    }
}