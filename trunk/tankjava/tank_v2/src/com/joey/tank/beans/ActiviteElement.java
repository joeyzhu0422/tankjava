package com.joey.tank.beans;

import java.util.List;

import com.joey.tank.listener.MoveListener;

public abstract class ActiviteElement extends StaticElement {

	protected int direction;

	protected List<MoveListener> moveListenerList;

	public void addMoveListener(MoveListener listener) {
		moveListenerList.add(listener);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public abstract void action() throws Exception;
}
