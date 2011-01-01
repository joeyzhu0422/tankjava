package com.joey.tank.constant;

import java.awt.Color;

public class Constant {

	public interface Scene {

		public int WIDTH = 450;

		public int HEIGHT = 600;

		public int CELL_LENGTH = 15;

		public int TOP_HEIGHT = 30;

		public Color SCENE_COLOR = Color.BLACK;

	}

	public interface ActiviteElement {

		public int DIRECTION_UP = 0;

		public int DIRECTION_LEFT = 1;

		public int DIRECTION_DOWN = 2;

		public int DIRECTION_RIGHT = 3;

		public interface MainTank {

			public int ORIGINAL_X = 8 * Constant.Scene.CELL_LENGTH;

			public int ORIGINAL_Y = 35 * Constant.Scene.CELL_LENGTH
					+ Constant.Scene.TOP_HEIGHT;

		}

	}

	public interface Obstacle {

		public int TYPE_NOTHING = 0;

		public int TYPE_BRICK = 1;
		
		public int TYPE_SEA = 2;
		
		public int TYPE_STEEL = 3;
		
		public int TYPE_FOREST = 4;
		
		public int TYPE_HOME = 5;

	}

	public interface Map {

		public int SINGLE_LAYER = 0;

		public int MULTIPLE_LAYER = 1;

	}

}
