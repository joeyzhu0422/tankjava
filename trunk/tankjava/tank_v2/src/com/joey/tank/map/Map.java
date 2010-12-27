package com.joey.tank.map;

import java.awt.Graphics;

import com.joey.tank.beans.MapElement;
import com.joey.tank.beans.obstacle.ObstacleFactory;
import com.joey.tank.beans.tank.Tank;
import com.joey.tank.constant.Constant;

public class Map {

	private int[][] models;

	private MapElement[][] mapElements;

	public int[][] getModels() {
		return models;
	}

	public void setModels(int[][] models) {

		this.models = models;
		this.toElements();

	}

	public MapElement[][] getMapElements() {
		return mapElements;
	}

	public void setMapElements(MapElement[][] mapElements) {
		this.mapElements = mapElements;
	}

	private void toElements() {

		if (null == models) {
			throw new RuntimeException("models is null");
		}

		MapElement[][] obstacles = new MapElement[models.length][];

		for (int i = 0; i < models.length; i++) {

			obstacles[i] = new MapElement[models[i].length];

			for (int j = 0; j < models[i].length; j++) {

				obstacles[i][j] = ObstacleFactory.createObstacle(j
						* Constant.Scene.CELL_LENGTH, i
						* Constant.Scene.CELL_LENGTH
						+ Constant.Scene.TOP_HEIGHT, models[i][j]);
			}
		}

		this.setMapElements(obstacles);
	}

	public MapElement getMapElement(int x, int y) {

		try {
			return mapElements[y][x];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}

	}

	public void init() {

		for (int i = 0; i < mapElements.length; i++) {
			for (int j = 0; j < mapElements[i].length; j++) {
				mapElements[i][j].init();
			}
		}

	}

	public void draw(Graphics g) {

		System.out.println("Map draw");

		for (int i = 0; i < mapElements.length; i++) {
			for (int j = 0; j < mapElements[i].length; j++) {

				if (!(mapElements[i][j] instanceof Tank)) {
					mapElements[i][j].draw(g);
				}

			}
		}

		for (int i = 0; i < mapElements.length; i++) {
			for (int j = 0; j < mapElements[i].length; j++) {

				if (mapElements[i][j] instanceof Tank) {
					mapElements[i][j].draw(g);
				}

			}
		}

	}
}
