package com.joey.tank.listener.impl;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.listener.MoveListener;

public class BulletMoveListenerImpl implements MoveListener {

	public boolean isCollide(ActiviteElement element) {
		System.out.println("Bullet Move Listener isCollide");

		return true;
	}
}
