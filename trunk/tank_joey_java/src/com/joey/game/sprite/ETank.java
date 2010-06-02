package com.joey.game.sprite;

public class ETank extends Tank{

	public ETank(String fileName, int width, int height, int x, int y, int size) {
		super(fileName, width, height, x, y, size);
	}

	
	public void ai() {
		this.move(callback);
	}
}
