package com.joey.tank.beans;

import com.joey.tank.constant.Constant;
import com.joey.tank.listener.MoveListener;
import com.joey.tank.util.MapUtil;

public abstract class ActiviteElement extends StaticElement {

	protected int direction;

	protected MoveListener moveListener;

	protected boolean isPutInMap = false;

	protected boolean isMoved = true;

	public void setMoveListener(MoveListener listener) {
		this.moveListener = listener;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public abstract void action();

	public boolean move() {

		if (isMoved) {

			isMoved = false;

			boolean isMove = moveListener.isCollide(this);

			if (isMove) {

				switch (direction) {
				case Constant.ActiviteElement.DIRECTION_UP:
					this.setY(this.getY() - Constant.Scene.CELL_LENGTH);
					break;
				case Constant.ActiviteElement.DIRECTION_DOWN:
					this.setY(this.getY() + Constant.Scene.CELL_LENGTH);
					break;
				case Constant.ActiviteElement.DIRECTION_LEFT:
					this.setX(this.getX() - Constant.Scene.CELL_LENGTH);
					break;
				case Constant.ActiviteElement.DIRECTION_RIGHT:
					this.setX(this.getX() + Constant.Scene.CELL_LENGTH);
					break;
				}

			}

			isMoved = true;

			return isMove;
		} else {
			return false;
		}
	}

}
