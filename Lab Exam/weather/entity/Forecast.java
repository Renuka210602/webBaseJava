package com.weather.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Forecast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer forecastId;
	private Date date;
	private Double temprature;
	private Double windSpeed;
	@Column(length = 50)
	private String weatherComdition;
	@Column(length = 50)
	private String location;

	public Forecast() {
	}

	public Forecast(Integer forecastId, Date date, Double temprature, Double windSpeed, String weatherComdition,
			String location) {
		super();
		this.forecastId = forecastId;
		this.date = date;
		this.temprature = temprature;
		this.windSpeed = windSpeed;
		this.weatherComdition = weatherComdition;
		this.location = location;
	}

	public Integer getForecastId() {
		return forecastId;
	}

	public void setForecastId(Integer forecastId) {
		this.forecastId = forecastId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTemprature() {
		return temprature;
	}

	public void setTemprature(Double temprature) {
		this.temprature = temprature;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWeatherComdition() {
		return weatherComdition;
	}

	public void setWeatherComdition(String weatherComdition) {
		this.weatherComdition = weatherComdition;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Forecast [forecastId=" + forecastId + ", date=" + date + ", temprature=" + temprature + ", windSpeed="
				+ windSpeed + ", weatherComdition=" + weatherComdition + ", location=" + location + "]";
	}
}
