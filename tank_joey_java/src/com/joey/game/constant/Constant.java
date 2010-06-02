package com.joey.game.constant;

public interface Constant {

	public static final int TYPE_WALL = 1;
	
	public static final int TYPE_STON = 2;

	public static final int TYPE_STEEL = 3;

	public static final int TYPE_SEA = 4;

	public static final int TYPE_TANK = 5;

	public static final int TYPE_ETANK = 6;

	public static final int TYPE_HOME = 7;

	public static final int TYPE_BULLET = 10;

	public interface RpgSprite {

		int UP = 0;

		int RIGHT = 1;

		int DOWN = 2;

		int LEFT = 3;

		public interface Bullet {

			public int BULLET_SPEED_7 = 7;
		}

	}

}
