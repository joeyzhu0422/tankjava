package com.joey.tank.beans.tank;

import java.awt.Graphics;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.constant.Constant;

public abstract class BaseAbstractTank extends ActiviteElement {

	public void draw(Graphics g) {
		System.out.println("Tank draw");

		g.setColor(color);

		g.fillRect(x, y, width, height);

		int barrelX = 0, barrelY = 0, barrelWidth = 0, barrelHeight = 0;

		switch (direction) {
		case Constant.Tank.DIRECTION_UP:
			barrelWidth = width / 10;
			barrelHeight = height / 3;
			barrelX = x + width / 2 - barrelWidth / 2;
			barrelY = y - barrelHeight;
			break;
		case Constant.Tank.DIRECTION_DOWN:
			barrelWidth = width / 10;
			barrelHeight = height / 3;
			barrelX = x + width / 2 - barrelWidth / 2;
			barrelY = y + height;
			break;
		case Constant.Tank.DIRECTION_LEFT:
			barrelHeight = width / 10;
			barrelWidth = height / 3;
			barrelX = x - barrelWidth;
			barrelY = y + height / 2 - barrelHeight / 2;
			break;
		case Constant.Tank.DIRECTION_RIGHT:
			barrelHeight = width / 10;
			barrelWidth = height / 3;
			barrelX = x + width;
			barrelY = y + height / 2 - barrelHeight / 2;
			break;
		}

		g.fillRect(barrelX, barrelY, barrelWidth, barrelHeight);
	}

}
