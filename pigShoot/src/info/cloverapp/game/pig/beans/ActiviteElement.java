package info.cloverapp.game.pig.beans;

import info.cloverapp.game.pig.constant.Constant;
import info.cloverapp.game.pig.listener.MoveListener;

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
	 * 是否移动过
	 */
	protected volatile boolean isMoved = true;

	/**
	 * 移动方法
	 * 
	 * @return boolean 当可以移动时返回true，反之，false
	 */
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

	public void setMoveListener(MoveListener listener) {
		this.moveListener = listener;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
