package com.joey.pattern.command.entities.command.impl;

import com.joey.pattern.command.entities.Command;
import com.joey.pattern.command.entities.impl.Light;

public class LightOffCommand implements Command {

	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}
	
	public void undo() {
		light.on();
	}

}
