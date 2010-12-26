package com.joey.tank.beans;

import com.joey.tank.constant.Constant;
import com.joey.tank.listener.MoveListener;

public abstract class ActiviteElement extends StaticElement {

	protected int direction;

	protected MoveListener moveListener;

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

		boolean isMove = moveListener.isCollide(this);

		if (isMove) {

			switch (direction) {
			case Constant.ActiviteElement.DIRECTION_UP:
				this.setY(this.getY() - 1);
				break;
			case Constant.ActiviteElement.DIRECTION_DOWN:
				this.setY(this.getY() + 1);
				break;
			case Constant.ActiviteElement.DIRECTION_LEFT:
				this.setX(this.getX() - 1);
				break;
			case Constant.ActiviteElement.DIRECTION_RIGHT:
				this.setX(this.getX() + 1);
				break;
			}

		}

		return isMove;
	}
}
