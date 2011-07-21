package info.cloverapp.game.pig.beans;

import info.cloverapp.game.pig.constant.Constant;
import info.cloverapp.game.pig.move.listener.MoveListener;

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
	 * �ٶ� ÿ���ƶ��ľ���
	 */
	protected int speed;

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
