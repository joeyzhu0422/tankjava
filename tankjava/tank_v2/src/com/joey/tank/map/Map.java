package com.joey.tank.map;

import java.awt.Graphics;

import com.joey.tank.beans.MapElement;
import com.joey.tank.beans.obstacle.ObstacleFactory;
import com.joey.tank.constant.Constant;

public class Map {

	private int[][] models;

	private MapElement[][][] mapElements;

	private Object lock = new Object();

	public int[][] getModels() {
		return models;
	}

	public void setModels(int[][] models) {

		this.models = models;
		this.toElements();

	}

	public MapElement[][] getMapElements(int layer) {
		return mapElements[layer];
	}

	public void setMapElements(int layer, MapElement[][] mapElements) {

		synchronized (lock) {

			if (null == this.mapElements) {

				synchronized (lock) {

					this.mapElements = new MapElement[2][][];

				}

			}

		}

		this.mapElements[layer] = mapElements;
	}

	private void toElements() {

		if (null == models) {
			throw new RuntimeException("models is null");
		}

		MapElement[][] singleLayerObstacles = new MapElement[models.length][];
		MapElement[][] multipleLayerObstacles = new MapElement[models.length][];

		for (int i = 0; i < models.length; i++) {

			singleLayerObstacles[i] = new MapElement[models[i].length];
			multipleLayerObstacles[i] = new MapElement[models[i].length];

			for (int j = 0; j < models[i].length; j++) {

				singleLayerObstacles[i][j] = ObstacleFactory.createObstacle(j
						* Constant.Scene.CELL_LENGTH, i
						* Constant.Scene.CELL_LENGTH
						+ Constant.Scene.TOP_HEIGHT, models[i][j]);
			}
		}

		this.setMapElements(Constant.Map.SINGLE_LAYER, singleLayerObstacles);
		this
				.setMapElements(Constant.Map.MULTIPLE_LAYER,
						multipleLayerObstacles);
	}

	public MapElement getSingleLayerElement(int x, int y) {

		try {
			return mapElements[Constant.Map.SINGLE_LAYER][y][x];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}

	}

	public MapElement getMultipleLayerElement(int x, int y) {

		try {
			return mapElements[Constant.Map.MULTIPLE_LAYER][y][x];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}

	}

	public void init() {

		MapElement[][] multipleElements = this
				.getMapElements(Constant.Map.MULTIPLE_LAYER);

		for (int i = 0; i < multipleElements.length; i++) {
			for (int j = 0; j < multipleElements[i].length; j++) {
				if (null != multipleElements[i][j]) {
					multipleElements[i][j].init();
				}
			}
		}

	}

	public void draw(Graphics g) {

		System.out.println("Map draw");

		for (int x = 0; x < mapElements.length; x++) {
			for (int y = 0; y < mapElements[x].length; y++) {
				for (int z = 0; z < mapElements[x][y].length; z++) {
					if (null != mapElements[x][y][z]) {
						mapElements[x][y][z].draw(g);
					}
				}
			}
		}

	}
}
