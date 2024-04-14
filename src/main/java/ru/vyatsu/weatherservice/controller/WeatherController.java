package ru.vyatsu.weatherservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vyatsu.weatherservice.model.HumData;
import ru.vyatsu.weatherservice.model.LightData;
import ru.vyatsu.weatherservice.model.TemperatureData;
import ru.vyatsu.weatherservice.repository.HumDataRepository;
import ru.vyatsu.weatherservice.repository.LightDataRepository;
import ru.vyatsu.weatherservice.repository.TemperatureDataRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WeatherController {

    private final HumDataRepository humDataRepository;
    private final LightDataRepository lightDataRepository;
    private final TemperatureDataRepository temperatureDataRepository;

    @GetMapping()
    public String weather(Model model) {
        List<HumData> humData = humDataRepository.findAllByOrderByCreatedAtAsc();
        List<LightData> lightData = lightDataRepository.findAllByOrderByCreatedAtAsc();
        List<TemperatureData> tempData = temperatureDataRepository.findAllByOrderByCreatedAtAsc();

        model.addAttribute("humValues", humData.stream().map(HumData::getHumValue).toList());
        model.addAttribute("humDates", humData.stream().map(HumData::getCreatedAt).toList());
        model.addAttribute("lightValues", lightData.stream().map(LightData::getLightValue).toList());
        model.addAttribute("lightDates", lightData.stream().map(LightData::getCreatedAt).toList());
        model.addAttribute("tempValues", tempData.stream().map(TemperatureData::getTemperatureValue).toList());
        model.addAttribute("tempDates", tempData.stream().map(TemperatureData::getCreatedAt).toList());

        return "weather";
    }
}
