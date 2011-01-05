package com.joey.tank.beans.tank;

import java.awt.Color;

import com.joey.tank.beans.Bullet;
import com.joey.tank.constant.Constant;
import com.joey.tank.util.MapUtil;

public class SubTank extends Tank {

	private int life = 1;

	public SubTank() {
		super();

		this.color = Color.GREEN;
		this.x = Constant.ActiviteElement.SubTank.ORIGINAL_X;
		this.y = Constant.ActiviteElement.SubTank.ORIGINAL_Y;
		this.width = 30;
		this.height = 30;

		for (int i = 0; i < 3; i++) {
			preparedBulletQueue.add(new Bullet(this));
		}

	}

	public void action() {
		// System.out.println("Sub Tank is action");
	}

	@Override
	public void removeExplode() {

		System.out.println("Sub Tank remove Explode");

		// step.1 ȥ����ǰλ��̹��
		MapUtil.putNothingToMultipleLayer(this);

		// step.2 ����̹��λ��
		this.setX(Constant.ActiviteElement.SubTank.ORIGINAL_X);
		this.setY(Constant.ActiviteElement.SubTank.ORIGINAL_Y);
		MapUtil.putToMultipleLayer(this);

		// step.3 ��ը��������
		this.currentExplodeStep = 0;

		// step.4 ���� �� 1
		this.life--;

	}

	public int getLife() {
		return life;
	}

}
