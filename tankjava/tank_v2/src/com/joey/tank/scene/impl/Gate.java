package com.joey.tank.scene.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.joey.tank.ai.IAiManager;
import com.joey.tank.ai.impl.AiManager;
import com.joey.tank.beans.Bullet;
import com.joey.tank.beans.obstacle.ElementFactory;
import com.joey.tank.beans.tank.EnemyTank;
import com.joey.tank.beans.tank.TankFactory;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.impl.MainTankKeyListenerImpl;
import com.joey.tank.listener.impl.SubTankKeyListenerImpl;
import com.joey.tank.map.Map;
import com.joey.tank.map.MapLoader;
import com.joey.tank.scene.IScene;
import com.joey.tank.util.MapUtil;
import com.joey.tank.window.Window;

public class Gate implements IScene {

	protected Map map;

	protected BufferedImage bufferScene;

	protected List<KeyListener> keyListenerList;

	protected Object lock = new Object();

	protected int players;

	protected IAiManager aiManager;

	protected boolean isRun = true;

	protected boolean isGamgOver = false;

	protected Window window;

	public Gate(Window window, int players) {

		this.window = window;
		this.players = players;

	}

	public void draw(Graphics g, int width, int height) {

		bufferScene = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// step.1 初始化元素
		map.init();

		// step.2 双缓冲区设置
		Graphics bufferG = bufferScene.getGraphics();

		// step.3 涂上背景
		bufferG.setColor(Constant.Scene.SCENE_COLOR);
		bufferG.fillRect(0, 0, width, height);

		// step.4 地图绘制
		map.draw(bufferG);

		// step.4-1 mainTank子弹绘制
		if (players >= 1 && TankFactory.getMainTank() != null) {
			for (Bullet bullet : TankFactory.getMainTank()
					.getFiredBulletQueue()) {
				bullet.draw(bufferG);
			}
		}

		// step.4-2 subTank子弹绘制
		if (players >= 2 && TankFactory.getSubTank() != null) {
			for (Bullet bullet : TankFactory.getSubTank().getFiredBulletQueue()) {
				bullet.draw(bufferG);
			}
		}

		// step.4-3 敌坦克子弹绘制
		for (EnemyTank enemyTank : TankFactory.getCurrentEnemyTankList()) {
			if (null == enemyTank) {
				System.out.println(enemyTank);
			}

			for (Bullet bullet : enemyTank.getFiredBulletQueue()) {
				bullet.draw(bufferG);
			}
		}

		// step.5 敌坦克数量表示
		Queue<EnemyTank> reserveEnemyTankQueue = TankFactory
				.geteReserveEnemyTankQueue();

		for (int i = 0; i < reserveEnemyTankQueue.size(); i++) {

			int x = Constant.Scene.WIDTH - Constant.Scene.RIGHT_WIDTH
					+ Constant.Scene.CELL_LENGTH * (i % 2);
			int y = Constant.Scene.TOP_HEIGHT + Constant.Scene.CELL_LENGTH
					* (i / 2) + (i / 2) * 5;

			this.drawSignEnemyTank(bufferG, x, y);

		}

		// step.6 绘制关卡数
		this.drawGate(bufferG);

		// step.7 剩余生命绘制
		this.drawLife(bufferG);

		// step.8 判断是否游戏结束
		if (this.isGamgOver) {

			this.drawGameOver(bufferG);
			window.stop();

		}

		// step.9 双缓冲区放置到面板
		g.drawImage(bufferScene, 0, 0, width, height, null);
	}

	public void init() {

		// step.1 创建地图
		map = MapLoader.getMap();

		// step.2 放置主坦克
		if (players >= 1) {
			MapUtil.putToMultipleLayer(TankFactory.getMainTank());
		}

		// step.3 放置副坦克
		if (players >= 2) {
			MapUtil.putToMultipleLayer(TankFactory.getSubTank());
		}

		// step.4 创建ai管理器
		aiManager = new AiManager();
	}

	// 绘制敌坦克数量标志
	private void drawSignEnemyTank(Graphics g, int x, int y) {

		int width = 15;
		int height = 15;

		g.setColor(Color.WHITE);

		int barrelWidth = 0, barrelHeight = 0, barrelX = 0, barrelY = 0;

		barrelWidth = width / 10;
		barrelHeight = height / 3;
		barrelX = x + width / 2 - barrelWidth / 2;
		barrelY = y + height;

		g.fill3DRect(x, y, width, height, true);
		g.fill3DRect(barrelX, barrelY, barrelWidth, barrelHeight, true);
	}

	private void drawGate(Graphics g) {

		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 18));

		String gate = String.valueOf(MapLoader.getCurrentGate());
		int x = Constant.Scene.WIDTH - Constant.Scene.RIGHT_WIDTH;
		int y = Constant.Scene.HEIGHT - Constant.Scene.DOWN_HEIGTH
				- Constant.Scene.TOP_HEIGHT;

		g.drawString(gate, x, y);

	}

	private void drawLife(Graphics g) {

		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 18));

		int x = Constant.Scene.WIDTH - Constant.Scene.RIGHT_WIDTH;
		int y = Constant.Scene.HEIGHT - Constant.Scene.DOWN_HEIGTH
				- Constant.Scene.TOP_HEIGHT * 2;

		if (players >= 1) {

			int mainLife = null == TankFactory.getMainTank() ? 0 : TankFactory
					.getMainTank().getLife();
			g.drawString("1P: " + mainLife, x, y);

		}

		if (players >= 2) {

			int subLife = null == TankFactory.getSubTank() ? 0 : TankFactory
					.getSubTank().getLife();
			g.drawString("2P: " + subLife, x, y + 15);

		}

	}

	private void drawGameOver(Graphics g) {

		// step.1 初始化
		g.setColor(Color.RED);
		g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));

		// step.2 game over绘制
		int x = Constant.Scene.RIGHT_WIDTH * 3;
		int y = Constant.Scene.TOP_HEIGHT * 3 + Constant.Scene.DOWN_HEIGTH * 3;

		g.drawString("Game Over", x, y);

	}

	@Override
	public List<KeyListener> getKeyListenerList() {

		if (null == keyListenerList) {

			synchronized (lock) {

				if (null == keyListenerList) {

					keyListenerList = new ArrayList<KeyListener>();

					if (players >= 1) {
						keyListenerList.add(new MainTankKeyListenerImpl());
					}

					if (players >= 2) {
						keyListenerList.add(new SubTankKeyListenerImpl());
					}

				}

			}
		}

		return keyListenerList;
	}

	@Override
	public void action() {

		// step.1 清空 Multiple多层地图
		MapLoader.getMap().cleanMultipleLayer();

		// step.2 敌坦克放置
		List<EnemyTank> currentEnemyTankList = TankFactory
				.getCurrentEnemyTankList();

		for (EnemyTank enemyTank : currentEnemyTankList) {
			MapUtil.putToMultipleLayer(enemyTank);
		}

		// step.3 主坦克放置
		if (players >= 1) {
			MapUtil.putToMultipleLayer(TankFactory.getMainTank());
		}

		// step.4 副坦克放置
		if (players >= 2) {
			MapUtil.putToMultipleLayer(TankFactory.getSubTank());
		}

		if (currentEnemyTankList.size() == 0) {
			this.isRun = false;
		}

		if (null != aiManager) {
			aiManager.action();
		}

		if (null != ElementFactory.getHome()
				&& ElementFactory.getHome().isExploded()) {
			this.isGamgOver = true;
		}

		if (players == 1) {

			if (null == TankFactory.getMainTank()
					|| TankFactory.getMainTank().getLife() <= 0) {

				TankFactory.removeMainTank();
				this.isGamgOver = true;

			}
		} else if (players == 2) {

			int mainTankLife = 0, subTankLife = 0;

			if (null != TankFactory.getMainTank()) {
				mainTankLife = TankFactory.getMainTank().getLife();
			}

			if (mainTankLife <= 0) {
				TankFactory.removeMainTank();
			}

			if (null != TankFactory.getSubTank()) {
				subTankLife = TankFactory.getSubTank().getLife();
			}

			if (subTankLife <= 0) {
				TankFactory.removeSubTank();
			}

			this.isGamgOver = mainTankLife <= 0 && subTankLife <= 0;

		}

	}

	public boolean isRun() {
		return isRun;
	}

}
