package com.joey.tank.beans.tank;

import java.awt.Graphics;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.constant.Constant;

public abstract class BaseAbstractTank extends ActiviteElement {

	public void draw(Graphics g) {
		System.out.println("Tank draw");

		g.setColor(color);

		g.fillRect(x * Constant.Scene.CELL_LENGTH, y
				* Constant.Scene.CELL_LENGTH + Constant.Scene.TOP_HEIGHT,
				width, height);

		int barrelX = 0, barrelY = 0, barrelWidth = 0, barrelHeight = 0;

		switch (direction) {
		case Constant.ActiviteElement.DIRECTION_UP:
			barrelWidth = width / 10;
			barrelHeight = height / 3;
			barrelX = x * Constant.Scene.CELL_LENGTH + width / 2 - barrelWidth
					/ 2;
			barrelY = y * Constant.Scene.CELL_LENGTH - barrelHeight;
			break;
		case Constant.ActiviteElement.DIRECTION_DOWN:
			barrelWidth = width / 10;
			barrelHeight = height / 3;
			barrelX = x * Constant.Scene.CELL_LENGTH + width / 2 - barrelWidth
					/ 2;
			barrelY = y * Constant.Scene.CELL_LENGTH + height;
			break;
		case Constant.ActiviteElement.DIRECTION_LEFT:
			barrelHeight = width / 10;
			barrelWidth = height / 3;
			barrelX = x * Constant.Scene.CELL_LENGTH - barrelWidth;
			barrelY = y * Constant.Scene.CELL_LENGTH + height / 2
					- barrelHeight / 2;
			break;
		case Constant.ActiviteElement.DIRECTION_RIGHT:
			barrelHeight = width / 10;
			barrelWidth = height / 3;
			barrelX = x * Constant.Scene.CELL_LENGTH + width;
			barrelY = y * Constant.Scene.CELL_LENGTH + height / 2
					- barrelHeight / 2;
			break;
		}

		g.fillRect(barrelX, barrelY + Constant.Scene.TOP_HEIGHT, barrelWidth,
				barrelHeight);
	}

}
