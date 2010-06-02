package com.joey.game.base.sprite;

import java.awt.Image;

import org.loon.framework.game.simple.utils.GraphicsUtils;

import com.joey.game.constant.Constant;

public class RpgSprite implements IRpgSprite {

	protected static final int UP = Constant.RpgSprite.UP;

	protected static final int RIGHT = Constant.RpgSprite.RIGHT;

	protected static final int DOWN = Constant.RpgSprite.DOWN;

	protected static final int LEFT = Constant.RpgSprite.LEFT;

	protected Image shadowImage;

	protected Image[][] images;

	protected int imageHeight;

	protected int imageWidth;

	protected int size;

	protected int x;

	protected int y;

	protected int xValue;

	protected int yValue;

	protected int type;

	public RpgSprite(String fileName, int width, int height, int type, int size) {
		this(fileName, width, height, type, 0, 0, size);
	}

	public RpgSprite(String fileName, int width, int height, int type, int x,
			int y, int size) {
		this.size = size;
		this.images = GraphicsUtils.getSplit2Images(fileName, width, height,
				false);
		this.images = GraphicsUtils.getFlipHorizintalImage2D(this.images);
		this.imageWidth = width;
		this.imageHeight = height;
		this.x = x;
		this.y = y;
		this.xValue = x * 20;
		this.yValue = y * 20;
		this.type = type;
	}

	public Image[][] getImages() {
		return images;
	}

	public Image[] getMoveImage(int index) {
		return images[index];
	}

	public Image getOnlyMove(int index) {
		return images[index][0];
	}

	public int getImageHeight() {
		return imageHeight;
	}

	@Override
	public int getImageWidth() {
		return imageWidth;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Image makeShadowImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	@Override
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXy(int xValue, int yValue) {
		this.xValue = xValue;
		this.yValue = yValue;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getxValue() {
		return xValue;
	}

	public void setxValue(int xValue) {
		this.xValue = xValue;
	}

	public int getyValue() {
		return yValue;
	}

	public void setyValue(int yValue) {
		this.yValue = yValue;
	}

}
