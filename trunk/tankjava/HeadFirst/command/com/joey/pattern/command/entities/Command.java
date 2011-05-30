package com.joey.pattern.command.entities;

public interface Command {

	public void execute();
	
	public void undo();
	
}
