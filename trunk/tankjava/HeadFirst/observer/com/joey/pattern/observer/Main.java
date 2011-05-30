package com.joey.pattern.observer;

import com.joey.pattern.observer.interfaces.impl.CurrentConditionsDisplay;
import com.joey.pattern.observer.interfaces.impl.WeatherData;

public class Main {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(
				weatherData);
		
		weatherData.setMeasurements(80, 90, 100);
	}

}
