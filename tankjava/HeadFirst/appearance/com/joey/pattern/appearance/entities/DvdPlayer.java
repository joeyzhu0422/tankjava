package com.joey.pattern.appearance.entities;

public class DvdPlayer {

	private String movie;

	public void on() {
		System.out.println("Top-O-Line DVD Player on");
	}

	public void play(String movie) {
		this.movie = movie;
		System.out.println("Top-O-Line DVD Player playing " + movie);
	}

	public void stop() {
		System.out.println("Top-O-Line DVD Player stopped \"" + this.movie
				+ "\"");
	}

	public void eject() {
		System.out.println("Top-O-Line DVD Player eject");
	}

	public void off() {
		System.out.println("Top-O-Line DVD Player off");
	}

	public String toString() {
		return "Top-O-Line DVD Player";
	}
}
