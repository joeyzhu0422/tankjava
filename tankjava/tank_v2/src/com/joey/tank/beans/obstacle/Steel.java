package com.joey.tank.beans.obstacle;

import java.awt.Color;

public class Steel extends Obstacle{

	public Steel(int x, int y) {
		
		super(x, y);
		this.color = Color.WHITE;
		this.isPass = false;
		this.isBulletPass = false;
		
	}

	@Override
	public void bulletAction() {
		// Do thing
	}

}
