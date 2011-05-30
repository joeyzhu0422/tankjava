package com.joey.pattern.command.entities.command.impl;

import com.joey.pattern.command.entities.Command;
import com.joey.pattern.command.entities.impl.CeilingFan;

public class CeilingFanOnCommand implements Command {

	private CeilingFan ceilingFan;

	private int prevSpeed;

	public CeilingFanOnCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	public void execute() {
		prevSpeed = ceilingFan.getSpeed();
		
		if (prevSpeed == CeilingFan.OFF) {
			ceilingFan.low();
		} else if (prevSpeed == CeilingFan.LOW) {
			ceilingFan.medium();
		} else if (prevSpeed == CeilingFan.MEDIUM) {
			ceilingFan.high();
		} else if (prevSpeed == CeilingFan.HIGH) {
			// Do Nothing
		}
	
	}

	public void undo() {
		if (prevSpeed == CeilingFan.HIGH) {
			ceilingFan.high();
		} else if (prevSpeed == CeilingFan.MEDIUM) {
			ceilingFan.medium();
		} else if (prevSpeed == CeilingFan.LOW) {
			ceilingFan.low();
		} else if (prevSpeed == CeilingFan.OFF) {
			ceilingFan.off();
		}
	}
}
