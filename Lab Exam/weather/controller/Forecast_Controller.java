package com.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weather.entity.Forecast;
import com.weather.service.Forecast_Service;

@RestController
public class Forecast_Controller {
	@Autowired
	private Forecast_Service forecastService;
	
	@PostMapping("/add")
    public Forecast add(@RequestBody Forecast forecast) {
        return forecastService.add(forecast);
    }
	
	@GetMapping("/all")
	public List<Forecast> findAll() {
		return forecastService.findAll();
	}

    @PutMapping("/{id}")
    public Forecast updateForecast(@PathVariable Integer id, @RequestBody Forecast updatedForecast) 
    {
       return forecastService.updateForecast(id, updatedForecast);
    }

    @DeleteMapping("/{id}")
    public void deleteForecast(@PathVariable Integer id) {
    	forecastService.deleteForecast(id);
    }
}
