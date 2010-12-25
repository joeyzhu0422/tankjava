package com.joey.tank.constant;

import java.awt.Color;

public class Constant {

	public interface Tank {

		public int DIRECTION_UP = 0;

		public int DIRECTION_LEFT = 1;

		public int DIRECTION_DOWN = 2;

		public int DIRECTION_RIGHT = 3;

	}

	public interface Scene {

		public int WIDTH = 450;

		public int HEIGHT = 600;

		public int CELL_LENGTH = 15;
		
		public Color SCENE_COLOR = Color.BLACK;

	}

	public interface Obstacle {

		public int TYPE_NOTHING = 0;

		public int TYPE_BRICK = 1;

	}

}
