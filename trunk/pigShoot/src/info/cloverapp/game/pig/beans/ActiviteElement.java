package info.cloverapp.game.pig.beans;

import info.cloverapp.game.pig.constant.Constant;
import info.cloverapp.game.pig.move.listener.MoveListener;

public abstract class ActiviteElement extends StaticElement {

	/**
	 * 方向
	 */
	protected int direction;

	/**
	 * 移动监听器
	 */
	protected MoveListener moveListener;

	/**
	 * 速度 每次移动的距离
	 */
	protected int speed;

	/**
	 * 是否移动过
	 */
	protected volatile boolean isMoved = true;

	/**
	 * 移动方法
	 * 
	 * @return boolean 当可以移动时返回true，反之，false
	 */
	public boolean move() {

		System.out.println("moveing.....");

		if (isMoved) {

			isMoved = false;

			boolean isMove = moveListener.isCollide(this);

			if (isMove) {

				switch (direction) {
				case Constant.ActiviteElement.DIRECTION_UP:
					this.setY(this.getY() - speed);
					break;
				case Constant.ActiviteElement.DIRECTION_DOWN:
					this.setY(this.getY() + speed);
					break;
				case Constant.ActiviteElement.DIRECTION_LEFT:
					this.setX(this.getX() - speed);
					break;
				case Constant.ActiviteElement.DIRECTION_RIGHT:
					this.setX(this.getX() + speed);
					break;
				}

			}

			isMoved = true;

			return isMove;
		} else {
			return false;
		}
	}

	public void setMoveListener(MoveListener listener) {
		this.moveListener = listener;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
