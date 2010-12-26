package com.joey.tank.map;

import java.awt.Graphics;

import com.joey.tank.beans.obstacle.Obstacle;
import com.joey.tank.beans.obstacle.ObstacleFactory;
import com.joey.tank.constant.Constant;

public class Map {

	private int[][] models;

	private Obstacle[][] obstacles;

	public int[][] getModels() {
		return models;
	}

	public void setModels(int[][] models) {

		this.models = models;
		this.toElements();

	}

	public Obstacle[][] getObstacles() {
		return obstacles;
	}

	public void setObstacles(Obstacle[][] obstacles) {
		this.obstacles = obstacles;
	}

	private void toElements() {

		if (null == models) {
			throw new RuntimeException("models is null");
		}

		Obstacle[][] obstacles = new Obstacle[models.length][];

		for (int i = 0; i < models.length; i++) {

			obstacles[i] = new Obstacle[models[i].length];

			for (int j = 0; j < models[i].length; j++) {

				obstacles[i][j] = ObstacleFactory.createObstacle(j
						* Constant.Scene.CELL_LENGTH, i
						* Constant.Scene.CELL_LENGTH
						+ Constant.Scene.TOP_HEIGHT, models[i][j]);
			}
		}

		this.setObstacles(obstacles);
	}

	public Obstacle getObstacle(int x, int y) {

		try {
			return obstacles[y][x];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}

	}

	public void draw(Graphics g) {

		System.out.println("Map draw");

		for (int i = 0; i < obstacles.length; i++) {
			for (int j = 0; j < obstacles[i].length; j++) {

				obstacles[i][j].draw(g);

			}
		}

	}
}
