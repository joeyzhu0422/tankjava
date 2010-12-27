package com.joey.tank.beans.obstacle;

import java.awt.Color;

public class Brick extends Obstacle {

	public Brick(int x, int y) {

		super(x, y);
		this.color = new Color(190, 80, 11);
		this.isPass = false;
		this.isBulletPass = false;

	}

	public void bulletAction() {
		// TODO Auto-generated method stub

	}

}
