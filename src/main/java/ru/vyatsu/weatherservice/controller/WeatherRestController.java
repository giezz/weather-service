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
    public void weather(@RequestParam(required = false) BigDecimal temp,
                        @RequestParam(required = false) BigDecimal light,
                        @RequestParam(required = false) BigDecimal hum) {
        if (temp != null) {
            temperatureDatumRepository.save(new TemperatureDatum(temp, Instant.now()));
        }
        if (light != null) {
            lightDatumRepository.save(new LightDatum(light, Instant.now()));
        }
        if (hum != null) {
            humDatumRepository.save(new HumDatum(hum, Instant.now()));
        }
    }
}
