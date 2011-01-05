package com.joey.tank.constant;

import java.awt.Color;

public class Constant {

	public interface Scene {

		public int TOP_HEIGHT = 50;

		public int DOWN_HEIGTH = 30;

		public int LEFT_WIDTH = 30;

		public int RIGHT_WIDTH = 50;

		public int WIDTH = 395 + LEFT_WIDTH + RIGHT_WIDTH;

		public int HEIGHT = 395 + TOP_HEIGHT + DOWN_HEIGTH;

		public int CELL_LENGTH = 15;

		public Color SCENE_COLOR = Color.GRAY;

		// 敌坦克总数
		public int ENEMY_TANK_NUM = 30;

		// 同时存在的坦克数量
		public int CURRENT_ENEMY_TANK_NUM = 3;

	}

	public interface ActiviteElement {

		public int DIRECTION_UP = 0;

		public int DIRECTION_LEFT = 1;

		public int DIRECTION_DOWN = 2;

		public int DIRECTION_RIGHT = 3;

		public interface MainTank {

			public int ORIGINAL_X = 9 * Constant.Scene.CELL_LENGTH;

			public int ORIGINAL_Y = 24 * Constant.Scene.CELL_LENGTH
					+ Constant.Scene.TOP_HEIGHT;

		}
		
		public interface SubTank {
			
			public int ORIGINAL_X = 19 * Constant.Scene.CELL_LENGTH;

			public int ORIGINAL_Y = 24 * Constant.Scene.CELL_LENGTH
					+ Constant.Scene.TOP_HEIGHT;
			
		}

		public interface EnemyTank {

			public int[] ORIGINAL_X_ARRAY = {
					0 * Constant.Scene.CELL_LENGTH + Constant.Scene.LEFT_WIDTH,
					12 * Constant.Scene.CELL_LENGTH + Constant.Scene.LEFT_WIDTH,
					24 * Constant.Scene.CELL_LENGTH + Constant.Scene.LEFT_WIDTH };

			public int[] ORIGINAL_Y_ARRAY = {
					0 * Constant.Scene.CELL_LENGTH + Constant.Scene.TOP_HEIGHT,
					0 * Constant.Scene.CELL_LENGTH + Constant.Scene.TOP_HEIGHT,
					0 * Constant.Scene.CELL_LENGTH + Constant.Scene.TOP_HEIGHT };
			
			public interface Ai {
				
				public int STATUS_FIRE = 0;
				
				public int STATUS_MOVE = 1;
				
			}

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
