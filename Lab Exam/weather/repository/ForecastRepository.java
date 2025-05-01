package com.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weather.entity.Forecast;

public interface ForecastRepository extends JpaRepository<Forecast, Integer> {

}
