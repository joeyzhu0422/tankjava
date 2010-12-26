package com.joey.tank.main;

import com.joey.tank.beans.tank.MainTank;
import com.joey.tank.listener.MoveListener;
import com.joey.tank.listener.impl.MainTankKeyListenerImpl;
import com.joey.tank.listener.impl.MoveListenerImpl;
import com.joey.tank.scene.Scene;

public class Main {

	public static void main(String[] args) {

		// step.1 scene
		Scene scene = new Scene();
		
		// step.2 craete move listener
		MoveListener moveListener = new MoveListenerImpl();

		// step.3 main tank
		MainTank mainTank = new MainTank();
		mainTank.setMoveListener(moveListener);

		// step.4 set object to scene
		scene.setMainTank(mainTank);

		// step.5 set key listener to scene
		scene.addKeyListener(new MainTankKeyListenerImpl(mainTank));

	}
}
