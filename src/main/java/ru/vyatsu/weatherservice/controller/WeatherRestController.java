package ru.vyatsu.weatherservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vyatsu.weatherservice.model.HumDatum;
import ru.vyatsu.weatherservice.model.LightDatum;
import ru.vyatsu.weatherservice.model.TemperatureDatum;
import ru.vyatsu.weatherservice.repository.HumDatumRepository;
import ru.vyatsu.weatherservice.repository.LightDatumRepository;
import ru.vyatsu.weatherservice.repository.TemperatureDatumRepository;

import java.math.BigDecimal;
import java.time.Instant;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class WeatherRestController {

    private final HumDatumRepository humDatumRepository;
    private final LightDatumRepository lightDatumRepository;
    private final TemperatureDatumRepository temperatureDatumRepository;

    @GetMapping("/weather")
    public void weather(@RequestParam(required = false) String temp,
                        @RequestParam(required = false) String light,
                        @RequestParam(required = false) String hum) {
        final Instant now = Instant.now();
        if (temp != null) {
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(temp));
            temperatureDatumRepository.save(new TemperatureDatum(bigDecimal, now));
        }
        if (light != null) {
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(light));
            lightDatumRepository.save(new LightDatum(bigDecimal, now));
        }
        if (hum != null) {
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(hum));
            humDatumRepository.save(new HumDatum(bigDecimal, now));
        }
    }
}
