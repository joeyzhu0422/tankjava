package info.cloverapp.game.pig.constant;

import java.awt.Color;

public class Constant {

	public interface Scene {

		public int TOP_HEIGHT = 0;

		public int DOWN_HEIGTH = 0;

		public int LEFT_WIDTH = 0;

		public int RIGHT_WIDTH = 0;

		public int SCREEN_WIDTH = 480;

		public int SCREEN_HEIGHT = 320;

		public int WIDTH = SCREEN_WIDTH + LEFT_WIDTH + RIGHT_WIDTH;

		public int HEIGHT = SCREEN_HEIGHT + TOP_HEIGHT + DOWN_HEIGTH;

		public int CELL_LENGTH = 4;

		public Color SCENE_COLOR = Color.GRAY;

		public int THREAD_SLEEP_TIME = 50;

	}

	public interface ActiviteElement {

		public int DIRECTION_UP = 1;

		public int DIRECTION_LEFT = 2;

		public int DIRECTION_DOWN = 3;

		public int DIRECTION_RIGHT = 4;

		public interface Pig {

			public int WIDTH = 8 * Constant.Scene.CELL_LENGTH;

			public int HEIGHT = 8 * Scene.CELL_LENGTH;

			public int ORIGINAL_X = Scene.SCREEN_WIDTH - WIDTH
					+ Scene.LEFT_WIDTH;

			public int ORIGINAL_Y = Scene.TOP_HEIGHT + HEIGHT;

			public int SPEED = Scene.CELL_LENGTH * 4;

		}

		public interface Arrow {

			public int WIDTH = 4 * Scene.CELL_LENGTH;

			public int HEIGHT = 1 * Scene.CELL_LENGTH;

			public int SPEED = Scene.CELL_LENGTH * 2;

		}

	}

	public interface Map {

		public int SINGLE_LAYER = 0;

		public int MULTIPLE_LAYER = 1;

	}

}
