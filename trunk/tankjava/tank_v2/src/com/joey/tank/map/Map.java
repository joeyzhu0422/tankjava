package com.joey.tank.map;

import java.awt.Graphics;

import com.joey.tank.beans.IMapElement;
import com.joey.tank.beans.obstacle.ElementFactory;
import com.joey.tank.beans.obstacle.OutSide;
import com.joey.tank.constant.Constant;
import com.joey.tank.util.MapUtil;

public class Map {

	private int[][] models;

	private IMapElement[][][] mapElements;

	private Object lock = new Object();

	public Map(int[][] models) {
		this.models = models;
		this.toElements();
	}

	public int[][] getModels() {
		return models;
	}

	public IMapElement[][] getMapElements(int layer) {

		synchronized (lock) {

			if (null == this.mapElements) {

				synchronized (lock) {

					this.mapElements = new IMapElement[2][][];

				}

			}

		}

		if (null == mapElements[layer]) {
			System.out.println(mapElements[layer]);
		}

		return mapElements[layer];
	}

	public void setMapElements(int layer, IMapElement[][] mapElements) {

		synchronized (lock) {

			if (null == this.mapElements) {

				synchronized (lock) {

					this.mapElements = new IMapElement[2][][];

				}

			}

		}

		this.mapElements[layer] = mapElements;
	}

	private void toElements() {

		if (null == models) {
			throw new RuntimeException("models is null");
		}

		IMapElement[][] singleLayerObstacles = new IMapElement[models.length][];
		IMapElement[][] multipleLayerObstacles = new IMapElement[models.length][];

		for (int i = 0; i < models.length; i++) {

			singleLayerObstacles[i] = new IMapElement[models[i].length];
			multipleLayerObstacles[i] = new IMapElement[models[i].length];

			for (int j = 0; j < models[i].length; j++) {

				singleLayerObstacles[i][j] = ElementFactory.createElement(
						MapUtil.toRealX(j), MapUtil.toRealY(i), models[i][j]);
			}
		}

		this.setMapElements(Constant.Map.SINGLE_LAYER, singleLayerObstacles);
		this
				.setMapElements(Constant.Map.MULTIPLE_LAYER,
						multipleLayerObstacles);
	}

	public IMapElement getSingleLayerElement(int x, int y) {

		try {
			return mapElements[Constant.Map.SINGLE_LAYER][y][x];
		} catch (ArrayIndexOutOfBoundsException e) {
			return new OutSide(x, y);
		}

	}

	public IMapElement getMultipleLayerElement(int x, int y) {

		try {
			return mapElements[Constant.Map.MULTIPLE_LAYER][y][x];
		} catch (ArrayIndexOutOfBoundsException e) {
			return new OutSide(x, y);
		}

	}

	public void init() {

		for (int x = 0; x < mapElements.length; x++) {
			for (int y = 0; y < mapElements[x].length; y++) {
				for (int z = 0; z < mapElements[x][y].length; z++) {
					if (null != mapElements[x][y][z]) {
						mapElements[x][y][z].init();
					}
				}
			}
		}

	}

	public void draw(Graphics g) {

		// System.out.println("Map draw");

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

	public void cleanMultipleLayer() {

		for (int i = 0; i < mapElements[Constant.Map.MULTIPLE_LAYER].length; i++) {
			for (int j = 0; j < mapElements[Constant.Map.MULTIPLE_LAYER][i].length; j++) {
				mapElements[Constant.Map.MULTIPLE_LAYER][i][j] = null;
			}
		}

	}
}
