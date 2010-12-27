package com.joey.tank.beans;

import java.awt.Graphics;

public interface MapElement {

	public void bulletAction();

	public boolean isPass();

	public boolean isBulletPass();

	public void draw(Graphics g);

}
