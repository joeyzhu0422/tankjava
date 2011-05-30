package com.joey.pattern.observer.interfaces.impl;

import com.joey.pattern.observer.interfaces.DisplayElement;
import com.joey.pattern.observer.interfaces.Observer;
import com.joey.pattern.observer.interfaces.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;

	private float humidity;

	private Subject weatherData;

	public CurrentConditionsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update() {
		if (weatherData instanceof WeatherData) {
			WeatherData _weatherData = (WeatherData) weatherData;

			this.temperature = _weatherData.getTemperature();
			this.humidity = _weatherData.getHumidity();
		}

		display();
	}

	public void display() {
		System.out.println("Current conditions: " + temperature
				+ "F degrees and " + humidity + "% humidity");
	}

}
