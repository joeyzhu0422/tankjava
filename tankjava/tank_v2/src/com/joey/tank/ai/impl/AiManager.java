package com.joey.tank.ai.impl;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.List;

import com.joey.tank.ai.IAi;
import com.joey.tank.ai.IAiManager;
import com.joey.tank.ai.IAiObject;
import com.joey.tank.beans.tank.EnemyTank;
import com.joey.tank.beans.tank.TankFactory;
import com.joey.tank.constant.Constant;

public class AiManager implements IAiManager {

	private long lastTime = 0l;

	public void action() {

		long thisTime = Calendar.getInstance().getTimeInMillis();

		if (thisTime - Constant.ActiviteElement.EnemyTank.Ai.AI_SLEEP_TIME > lastTime) {

			lastTime = thisTime;

			List<EnemyTank> list = TankFactory.getCurrentEnemyTankList();

			for (int i = 0; i < list.size(); i++) {

				WeakReference<EnemyTank> enemyTank = new WeakReference<EnemyTank>(
						list.get(i));

				if (enemyTank.get() instanceof IAiObject) {

					WeakReference<IAiObject> aiObject = new WeakReference<IAiObject>(
							enemyTank.get());

					IAi tankAi = aiObject.get().getAi();

					if (null == tankAi) {

						tankAi = new TankAi(enemyTank.get());
						aiObject.get().setAi(tankAi);

					}

					tankAi.action();

				} else {
					throw new RuntimeException(
							"In Ai Manager, enemyTank is not instanceof IAiObject");
				}

			}

		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
