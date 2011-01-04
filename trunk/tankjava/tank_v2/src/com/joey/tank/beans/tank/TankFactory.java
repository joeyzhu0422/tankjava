package com.joey.tank.beans.tank;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.joey.tank.constant.Constant;

public class TankFactory {

	private static MainTank mainTank;
	
	private static boolean isExistMainTank = true;
	
	private static boolean isExistSubTank = true;

	private static SubTank subTank;

	private static Queue<EnemyTank> reserveEnemyTankQueue;

	private static List<EnemyTank> currentEnemyTankList;

	public static MainTank getMainTank() {

		if (null == mainTank && isExistMainTank) {

			mainTank = new MainTank();

		}

		return mainTank;
	}
	
	public static void removeMainTank() {
		
		mainTank = null;
		isExistMainTank = false;
		
	}

	public static SubTank getSubTank() {

		if (null == subTank && isExistSubTank) {

			subTank = new SubTank();

		}

		return subTank;
	}

	public static void removeSubTank() {
		
		subTank = null;
		isExistSubTank = false;
		
	}
	public static Queue<EnemyTank> geteReserveEnemyTankQueue() {

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

// System.out.println("reserveEnemyTankQueue size is "
// + enemyTankQueue.size());

		if (null == currentEnemyTankList) {

			currentEnemyTankList = new ArrayList<EnemyTank>();

			for (int i = 0; i < Constant.Scene.CURRENT_ENEMY_TANK_NUM; i++) {

				currentEnemyTankList.add(enemyTankQueue.poll());

			}

		} else if (currentEnemyTankList.size() < Constant.Scene.CURRENT_ENEMY_TANK_NUM) {

			for (int i = 0; i < Constant.Scene.CURRENT_ENEMY_TANK_NUM
					- currentEnemyTankList.size(); i++) {

				if (enemyTankQueue.size() > 0) {
					currentEnemyTankList.add(enemyTankQueue.poll());
				}

			}

		}

		return currentEnemyTankList;

	}

	public static void removeEnemyTank(Tank tank) {
		getCurrentEnemyTankList().remove(tank);
	}
}
