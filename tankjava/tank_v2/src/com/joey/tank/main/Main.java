package com.joey.tank.main;

import com.joey.tank.beans.MainTank;
import com.joey.tank.listener.impl.MainTankKeyListenerImpl;
import com.joey.tank.scene.Scene;

public class Main {

	public static void main(String[] args) {

		// step.1 scene
		Scene scene = new Scene();

		// step.2 main tank
		MainTank mainTank = new MainTank();

		// step.3 set object to scene
		scene.setMainTank(mainTank);

		// step.4 set key listener to scene
		scene.addKeyListener(new MainTankKeyListenerImpl(mainTank));

	}
}
