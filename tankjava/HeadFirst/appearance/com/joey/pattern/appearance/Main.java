package com.joey.pattern.appearance;

import com.joey.pattern.appearance.entities.Amplifier;
import com.joey.pattern.appearance.entities.DvdPlayer;
import com.joey.pattern.appearance.entities.HomeTheaterFacade;
import com.joey.pattern.appearance.entities.PopcornPopper;
import com.joey.pattern.appearance.entities.Projector;
import com.joey.pattern.appearance.entities.Screen;
import com.joey.pattern.appearance.entities.TheaterLights;

public class Main {

	public static void main(String[] args) {

		Amplifier amp = new Amplifier();
		DvdPlayer dvd = new DvdPlayer();
		Projector projector = new Projector();
		TheaterLights lights = new TheaterLights();
		Screen screen = new Screen();
		PopcornPopper popper = new PopcornPopper();

		HomeTheaterFacade facade = new HomeTheaterFacade(amp, dvd, projector,
				lights, screen, popper);

		facade.watchMovie("Raiders of the Lost Ark");
		facade.endMovie();
	}
}
