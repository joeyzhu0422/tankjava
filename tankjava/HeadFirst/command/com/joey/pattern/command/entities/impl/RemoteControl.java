package com.joey.pattern.command.entities.impl;

import com.joey.pattern.command.entities.Command;
import com.joey.pattern.command.entities.command.impl.NoCommand;

public class RemoteControl {

	private Command[] onCommands;

	private Command[] offCommands;
	
	private Command undoCommand;

	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];

		Command noCommand = new NoCommand();

		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		
		undoCommand = noCommand;

	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}
	
	public void undoButtonWasPushed() {
		undoCommand.undo();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n------ Remote Control ------\n");

		for (int i = 0; i < onCommands.length; i++) {
			sb.append("[slot " + i + "] " + onCommands[i].getClass().getName()
					+ "   " + offCommands[i].getClass().getName() + "\n");
		}

		return sb.toString();
	}
}
