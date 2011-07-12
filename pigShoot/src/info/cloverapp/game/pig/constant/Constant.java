package info.cloverapp.game.pig.constant;

import java.awt.Color;

public class Constant {

	public interface Scene {

		public int TOP_HEIGHT = 0;

		public int DOWN_HEIGTH = 0;

		public int LEFT_WIDTH = 0;

		public int RIGHT_WIDTH = 0;

		public int WIDTH = 480 + LEFT_WIDTH + RIGHT_WIDTH;

		public int HEIGHT = 320 + TOP_HEIGHT + DOWN_HEIGTH;

		public int CELL_LENGTH = 8;

		public Color SCENE_COLOR = Color.GRAY;

		public int THREAD_SLEEP_TIME = 12;

	}

	public interface ActiviteElement {

		public int DIRECTION_UP = 1;

		public int DIRECTION_LEFT = 2;

		public int DIRECTION_DOWN = 3;

		public int DIRECTION_RIGHT = 4;

	}

	public interface Map {

		public int SINGLE_LAYER = 0;

		public int MULTIPLE_LAYER = 1;

	}

}
