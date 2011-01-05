package com.joey.tank.beans.obstacle;

import java.awt.Color;
import java.awt.Graphics;

import com.joey.tank.beans.IExplode;
import com.joey.tank.beans.IMultipleMapElement;
import com.joey.tank.beans.StaticElement;
import com.joey.tank.constant.Constant;

public class Home extends StaticElement implements IMultipleMapElement,
		IExplode {

	protected boolean isExploed;

	protected boolean isDrawed;

	public Home(int x, int y) {

		this.x = x;
		this.y = y;
		this.width = 2 * Constant.Scene.CELL_LENGTH;
		this.height = 2 * Constant.Scene.CELL_LENGTH;
		this.color = new Color(255, 215, 000);

	}

	@Override
	public void draw(Graphics g) {

		if (!isDrawed()) {
			g.setColor(this.color);
			g.fill3DRect(x, y, width, height, true);
		}
	}

	@Override
	public boolean isDrawed() {
		return isDrawed;
	}

	@Override
	public void bulletAction() {

		this.color = Color.GRAY;
		this.isExploed = true;

	}

	@Override
	public void init() {
		this.isDrawed = false;
	}

	@Override
	public boolean isBulletPass() {
		return false;
	}

	@Override
	public boolean isPass() {
		return false;
	}

	@Override
	public void explode(Graphics g) {
		// Do Nothing
	}

	@Override
	public int getCurrentExplodeStep() {
		// Do Nothing
		return 0;
	}

	@Override
	public int getTotalExplodeStep() {
		// Do Nothing
		return 0;
	}

	@Override
	public boolean isExploded() {
		return isExploed;
	}

	@Override
	public void removeExplode() {
		// Do Nothing
	}

}
