package com.joey.tank.ai.impl;

import com.joey.tank.ai.IAi;
import com.joey.tank.beans.tank.Tank;

public class TankAi implements IAi {

	protected Tank tank;

	public TankAi(Tank tank) {
		this.tank = tank;
	}

	public void action() {
//		System.out.println("Tank ai action");
		tank.move();
	}

}
