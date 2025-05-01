package com.weather.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.weather.entity.Forecast;
import com.weather.exception.ResourceNotFoundException;
import com.weather.repository.ForecastRepository;

@Service
public  class Forecast_Service {
	@Autowired
	private ForecastRepository forecastRepo;
	
	
	public Forecast add(Forecast newForecast) {
		forecastRepo.save(newForecast);
		System.out.println("Data added Succcessfully");
		return newForecast;
	}

	public List<Forecast> findAll() {
		return forecastRepo.findAll();
	}
	
	public Forecast getForecastById(Integer id) {
        return forecastRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Forecast id is not available"));
    }

    public Forecast updateForecast(Integer id, Forecast updatedForecast) {
        Forecast existingForecast = forecastRepo.findById(id)
             .orElseThrow(()-> new ResourceNotFoundException("Forecast id is not available"));
        existingForecast.setDate(updatedForecast.getDate());
        existingForecast.setTemprature(updatedForecast.getTemprature());
        existingForecast.setWindSpeed(updatedForecast.getWindSpeed());
        existingForecast.setLocation(updatedForecast.getLocation());
        System.out.println("Data updated successfully");
        return existingForecast;
    }

    public void deleteForecast(Integer id) {
    	forecastRepo.deleteById(id);
    	System.out.println("Data deleted successfully");
    }
	
}
