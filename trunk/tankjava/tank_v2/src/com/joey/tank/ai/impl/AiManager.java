package com.joey.tank.ai.impl;

import java.util.List;

import com.joey.tank.ai.IAi;
import com.joey.tank.ai.IAiManager;
import com.joey.tank.ai.IAiObject;
import com.joey.tank.beans.tank.EnemyTank;
import com.joey.tank.beans.tank.TankFactory;

public class AiManager implements IAiManager {

	public void action() {

		List<EnemyTank> list = TankFactory.getCurrentEnemyTankList();

		for (EnemyTank enemyTank : list) {

			if (enemyTank instanceof IAiObject) {

				IAiObject aiObject = enemyTank;

				IAi tankAi = aiObject.getAi();

				if (null == tankAi) {

					tankAi = new TankAi(enemyTank);
					aiObject.setAi(tankAi);

				}

				tankAi.action();

			} else {
				throw new RuntimeException(
						"In Ai Manager, enemyTank is not instanceof IAiObject");
			}

		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
