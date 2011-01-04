package com.joey.tank.ai.impl;

import com.joey.tank.ai.IStatus;

public class MoveStatus implements IStatus {

	@Override
	public void reDo() {
		System.out.println("in move status, re do");
	}

	@Override
	public boolean isLeave() {
		System.out.println("leave move status");
		return false;
	}
}
