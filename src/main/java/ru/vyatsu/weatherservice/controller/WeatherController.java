package ru.vyatsu.weatherservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vyatsu.weatherservice.model.HumDatum;
import ru.vyatsu.weatherservice.model.LightDatum;
import ru.vyatsu.weatherservice.model.TemperatureDatum;
import ru.vyatsu.weatherservice.repository.HumDatumRepository;
import ru.vyatsu.weatherservice.repository.LightDatumRepository;
import ru.vyatsu.weatherservice.repository.TemperatureDatumRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WeatherController {

    private final HumDatumRepository humDatumRepository;
    private final LightDatumRepository lightDatumRepository;
    private final TemperatureDatumRepository temperatureDatumRepository;

    @GetMapping()
    public String weather(Model model) {
        List<HumDatum> humData = humDatumRepository.findAll();
        List<BigDecimal> humValues = humData.stream().map(HumDatum::getHumValue).toList();
        List<Instant> humDates = humData.stream().map(HumDatum::getCreatedAt).toList();

        List<LightDatum> lightData = lightDatumRepository.findAllByOrderByCreatedAtAsc();
        List<BigDecimal> lightValues = lightData.stream().map(LightDatum::getLightValue).toList();
        List<Instant> lightDates = lightData.stream().map(LightDatum::getCreatedAt).toList();

        List<TemperatureDatum> tempData = temperatureDatumRepository.findAllByOrderByCreatedAtAsc();
        List<BigDecimal> tempValues = tempData.stream().map(TemperatureDatum::getTemperatureValue).toList();
        List<Instant> tempDates = tempData.stream().map(TemperatureDatum::getCreatedAt).toList();

        model.addAttribute("humValues", humValues);
        model.addAttribute("humDates", humDates);
        model.addAttribute("lightValues", lightValues);
        model.addAttribute("lightDates", lightDates);
        model.addAttribute("tempValues", tempValues);
        model.addAttribute("tempDates", tempDates);

        return "weather";
    }
}
