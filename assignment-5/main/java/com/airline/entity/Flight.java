package com.airline.entity;

import java.time.LocalDate;

	public class Flight {
	private int id;
	private String flight_number;
	private String source;
	private String destination;
	private LocalDate flight_date;
	private double price;

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(String flight_number, String source, String destination, LocalDate flight_date, double price) {
		super();
		this.flight_number = flight_number;
		this.source = source;
		this.destination = destination;
		this.flight_date = flight_date;
		this.price = price;
	}

	public Flight(int id, String flight_number, String source, String destination, LocalDate flight_date, double price) {
		super();
		this.id = id;
		this.flight_number = flight_number;
		this.source = source;
		this.destination = destination;
		this.flight_date = flight_date;
		this.price = price;
	}

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getFlight_date() {
		return flight_date;
	}

	public void setFlightDate(LocalDate flight_date) {
		this.flight_date = flight_date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flight_number=" + flight_number + ", source=" + source + ", destination="
				+ destination + ", flightDate=" + flight_date + ", price=" + price + "]";
	}
}
