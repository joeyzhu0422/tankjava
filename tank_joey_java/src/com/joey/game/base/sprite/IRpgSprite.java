package com.joey.game.base.sprite;

import java.awt.Image;

public interface IRpgSprite {

	/**
	 * 
	 * 
	 * @return
	 */
	public Image makeShadowImage();

	public Image[][] getImages();

	public Image[] getMoveImage(int index);

	public Image getOnlyMove(int index);

	public int getSize();

	public int getImageHeight();

	public void setImageHeight(int imageHeight);

	public int getImageWidth();

	public void setImageWidth(int imageWidth);

	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);

	public void setXy(int x, int y);

	public int getxValue();

	public void setxValue(int xValue);

	public int getyValue();

	public void setyValue(int yValue);

	public int getType();

	public void setType(int type);
}
