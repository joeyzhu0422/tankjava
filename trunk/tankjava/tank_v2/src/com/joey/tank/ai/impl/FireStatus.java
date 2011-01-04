package com.joey.tank.ai.impl;

import com.joey.tank.ai.IStatus;

public class FireStatus implements IStatus {

	@Override
	public void reDo() {
		System.out.println("int fire status, re do");
	}

	@Override
	public boolean isLeave() {
		System.out.println("leave fire status");
		return false;
	}

}
