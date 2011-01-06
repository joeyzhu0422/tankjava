package com.joey.tank.ai.impl;

import java.util.Random;

import com.joey.tank.ai.IAi;
import com.joey.tank.beans.tank.Tank;
import com.joey.tank.constant.Constant;

public class TankAi implements IAi {

	protected Tank tank;

	public TankAi(Tank tank) {
		this.tank = tank;
	}

	public void action() {
		// System.out.println("Tank ai action");
//		int random = new Random().nextInt(5);
//
//		if (random == Constant.ActiviteElement.EnemyTank.Ai.STATUS_FIRE) {
//
//			tank.fire();
//
//		} else {
//
//			tank.setDirection(random);
//			tank.move();
//
//		}

	}

}
