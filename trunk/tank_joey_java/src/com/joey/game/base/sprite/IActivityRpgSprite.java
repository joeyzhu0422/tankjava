package com.joey.game.base.sprite;

public interface IActivityRpgSprite extends IRpgSprite {

	public void useGrid();

	public void freeGrid();

	public void move(MoveCallback callback);

	public boolean toBorder(int der, MoveCallback callback);

	public int[][] probe(int der);

	public int getDer();

	public void setDer(int der);

	public void setMoveDer(int moveDer);

	public int getMoveDer();

	public boolean hit(int moveDer, MoveCallback callback);

	public interface MoveCallback {

		public void execute();
	}
}
