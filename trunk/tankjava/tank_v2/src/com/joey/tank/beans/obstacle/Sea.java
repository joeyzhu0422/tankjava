package com.joey.tank.beans.obstacle;

import java.awt.Color;

public class Sea extends Obstacle {

	public Sea(int x, int y) {

		super(x, y);
		this.color = Color.BLUE;
		this.isPass = false;
		this.isBulletPass = true;

	}

	public void bulletAction() {
		// Do Nothing
	}
}
