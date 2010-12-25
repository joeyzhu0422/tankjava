package com.joey.tank.beans.obstacle;

import java.awt.Color;

public class Brick extends Obstacle {

	public Brick(int x, int y) {

		super(x, y);
		this.color = Color.getHSBColor(255, 90, 8);

	}

}
