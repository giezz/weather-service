package ru.vyatsu.weatherservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vyatsu.weatherservice.model.HumData;
import ru.vyatsu.weatherservice.model.LightData;
import ru.vyatsu.weatherservice.model.TemperatureData;
import ru.vyatsu.weatherservice.repository.HumDataRepository;
import ru.vyatsu.weatherservice.repository.LightDataRepository;
import ru.vyatsu.weatherservice.repository.TemperatureDataRepository;

import java.math.BigDecimal;
import java.time.Instant;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class WeatherRestController {

    private final HumDataRepository humDataRepository;
    private final LightDataRepository lightDataRepository;
    private final TemperatureDataRepository temperatureDataRepository;

    @GetMapping("/weather")
    public void weather(@RequestParam(required = false) String temp,
                        @RequestParam(required = false) String light,
                        @RequestParam(required = false) String hum) {
        final Instant now = Instant.now();
        if (temp != null) {
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(temp));
            temperatureDataRepository.save(new TemperatureData(bigDecimal, now));
        }
        if (light != null) {
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(light));
            lightDataRepository.save(new LightData(bigDecimal, now));
        }
        if (hum != null) {
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(hum));
            humDataRepository.save(new HumData(bigDecimal, now));
        }
    }
}
