package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAvgTemp () {
        Map<String, Double> calculatedAvgMap = temperatures.getTemperatures();

        double suma = 0;
        for (double temp : calculatedAvgMap.values()) {
            suma += temp;
        }
        return suma / temperatures.getTemperatures().size();
    }

    public double calculateMedianTemp() {
        Map<String, Double> calculatedMedianMap = temperatures.getTemperatures();

        if (calculatedMedianMap.size() == 0) {
            return 0.0;
        }

        List<Double> values = new ArrayList<>(calculatedMedianMap.values());
        Collections.sort(values);

        int size = values.size();
        if (size % 2 == 0) {
            //parzysta liczba elementów
            double left = values.get(size / 2) - 1;
            double right = values.get(size / 2);
            return (left + right) / 2;
        }else {
            //nieparzysta liczba elementów
            return values.get(size / 2);
        }
    }
}
