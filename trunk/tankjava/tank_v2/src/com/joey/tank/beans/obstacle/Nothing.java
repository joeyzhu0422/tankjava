package com.joey.tank.beans.obstacle;

import java.awt.Color;

public class Nothing extends Obstacle {

	public Nothing(int x, int y) {

		super(x, y);
		this.color = Color.BLACK;
		this.isPass = true;
		this.isBulletPass = true;

	}

	public void bulletAction() {
		// TODO Auto-generated method stub

	}

}
