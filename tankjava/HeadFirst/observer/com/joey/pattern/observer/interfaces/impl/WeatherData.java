package com.joey.pattern.observer.interfaces.impl;

import java.util.ArrayList;
import java.util.List;

import com.joey.pattern.observer.interfaces.Observer;
import com.joey.pattern.observer.interfaces.Subject;

public class WeatherData implements Subject {

	private List<Observer> observers;

	private float temperature;

	private float humidity;

	private float pressure;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity,
			float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.measurementsChanged();
	}

	/** setter and getter */
	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
