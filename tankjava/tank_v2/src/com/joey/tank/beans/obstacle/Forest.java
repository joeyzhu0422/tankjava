package com.joey.tank.beans.obstacle;

import java.awt.Color;

public class Forest extends Obstacle {

	public Forest(int x, int y) {

		super(x, y);
		this.color = Color.GREEN;
		this.isPass = true;
		this.isBulletPass = true;

	}

	public void bulletAction() {
		// Do thing
	}

}
