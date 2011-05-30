package com.joey.pattern.command;

import com.joey.pattern.command.entities.command.impl.CeilingFanOffCommand;
import com.joey.pattern.command.entities.command.impl.CeilingFanOnCommand;
import com.joey.pattern.command.entities.command.impl.LightOffCommand;
import com.joey.pattern.command.entities.command.impl.LightOnCommand;
import com.joey.pattern.command.entities.impl.CeilingFan;
import com.joey.pattern.command.entities.impl.Light;
import com.joey.pattern.command.entities.impl.RemoteControl;

public class Main {

	public static void main(String[] args) {
		// create remote control
		RemoteControl remoteControl = new RemoteControl();

		// create entities
		Light livingRoomLight = new Light("Living Room");
		CeilingFan ceilingFan = new CeilingFan("Living Room");

		// create command
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(
				livingRoomLight);

		CeilingFanOnCommand livingRoomCeilingFanOn = new CeilingFanOnCommand(
				ceilingFan);
		CeilingFanOffCommand livingRoomCeilingFanOff = new CeilingFanOffCommand(
				ceilingFan);

		// set command to remote control
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, livingRoomCeilingFanOn,
				livingRoomCeilingFanOff);

		System.out.println(remoteControl);

		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.undoButtonWasPushed();
		remoteControl.onButtonWasPushed(1);
		remoteControl.onButtonWasPushed(1);
		remoteControl.undoButtonWasPushed();
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.undoButtonWasPushed();
	}

}
