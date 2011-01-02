package com.joey.tank.beans;

import java.awt.Graphics;

public interface IExplode {

	public boolean isExploded();

	public int getCurrentExplodeStep();

	public int getTotalExplodeStep();

	public void removeExplode();

	public void explode(Graphics g);
}
