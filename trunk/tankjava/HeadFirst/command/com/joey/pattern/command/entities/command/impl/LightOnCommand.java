package com.joey.pattern.command.entities.command.impl;

import com.joey.pattern.command.entities.Command;
import com.joey.pattern.command.entities.impl.Light;

public class LightOnCommand implements Command {

	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}

	public void undo() {
		light.off();
	}
}
