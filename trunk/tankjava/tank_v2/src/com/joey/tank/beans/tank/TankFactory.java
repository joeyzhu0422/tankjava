package com.joey.tank.beans.tank;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.joey.tank.constant.Constant;

public class TankFactory {

	private static MainTank mainTank;

	private static SubTank subTank;

	private static Queue<EnemyTank> reserveEnemyTankQueue;

	private static List<EnemyTank> currentEnemyTankList;

	public static MainTank getMainTank() {

		if (null == mainTank) {

			mainTank = new MainTank();

		}

		return mainTank;
	}

	public static SubTank getSubTank() {

		if (null == subTank) {

			subTank = new SubTank();

		}

		return subTank;
	}

	private static Queue<EnemyTank> geteReserveEnemyTankQueue() {

		if (null == reserveEnemyTankQueue) {

			reserveEnemyTankQueue = new LinkedBlockingQueue<EnemyTank>();

			for (int i = 0; i < Constant.Scene.ENEMY_TANK_NUM; i++) {

				int _x = Constant.ActiviteElement.EnemyTank.ORIGINAL_X_ARRAY[i % 3];
				int _y = Constant.ActiviteElement.EnemyTank.ORIGINAL_Y_ARRAY[i % 3];

				reserveEnemyTankQueue.add(new EnemyTank(_x, _y));
			}

		}

		return reserveEnemyTankQueue;
	}

	public static List<EnemyTank> getCurrentEnemyTankList() {

		Queue<EnemyTank> enemyTankQueue = geteReserveEnemyTankQueue();

		if (null == currentEnemyTankList) {

			currentEnemyTankList = new ArrayList<EnemyTank>();

			for (int i = 0; i < Constant.Scene.CURRENT_ENEMY_TANK_NUM; i++) {

				currentEnemyTankList.add(enemyTankQueue.poll());

			}

		} else if (currentEnemyTankList.size() < Constant.Scene.CURRENT_ENEMY_TANK_NUM) {

			for (int i = 0; i < Constant.Scene.CURRENT_ENEMY_TANK_NUM
					- currentEnemyTankList.size(); i++) {

				currentEnemyTankList.add(enemyTankQueue.poll());

			}

		}

		return currentEnemyTankList;

	}
}
