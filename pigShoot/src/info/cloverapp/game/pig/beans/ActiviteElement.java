package info.cloverapp.game.pig.beans;

import info.cloverapp.game.pig.constant.Constant;
import info.cloverapp.game.pig.listener.MoveListener;

public abstract class ActiviteElement extends StaticElement {

	/**
	 * ����
	 */
	protected int direction;

	/**
	 * �ƶ�������
	 */
	protected MoveListener moveListener;

	/**
	 * �Ƿ��ƶ���
	 */
	protected volatile boolean isMoved = true;

	/**
	 * �ƶ�����
	 * 
	 * @return boolean �������ƶ�ʱ����true����֮��false
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
