package com.joey.tank.beans.obstacle;

import java.awt.Color;

public class Forest extends Obstacle {

	public Forest(int x, int y) {

		super(x, y);
		this.color = new Color(13, 115, 6);
		this.isPass = true;
		this.isBulletPass = true;

	}

	public void bulletAction() {
		// Do thing
	}

}
