package com.joey.pattern.command.entities.command.impl;

import com.joey.pattern.command.entities.Command;

public class NoCommand implements Command{

	public void execute() {
		// DO NOTHING
	}
	
	public void undo() {
		// DO NOTHING
	}

}
