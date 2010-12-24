package com.joey.tank.listener.impl;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.listener.MoveListener;

public class MoveListenerImpl implements MoveListener {

	public boolean isCollide(ActiviteElement element) throws Exception {
		System.out.println("Move Listener isCollide");
		return false;
	}

}
