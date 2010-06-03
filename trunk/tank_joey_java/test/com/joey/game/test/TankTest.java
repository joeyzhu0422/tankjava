package com.joey.game.test;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import org.loon.framework.game.simple.GameScene;
import org.loon.framework.game.simple.core.graphics.Deploy;
import org.loon.framework.game.simple.core.graphics.Screen;
import org.loon.framework.game.simple.core.timer.LTimer;
import org.loon.framework.game.simple.core.timer.LTimerContext;

import com.joey.game.base.sprite.IActivityRpgSprite.MoveCallback;
import com.joey.game.constant.Constant;
import com.joey.game.map.MapFactory;
import com.joey.game.sprite.Bullet;
import com.joey.game.sprite.ETank;
import com.joey.game.sprite.SpriteContainer;
import com.joey.game.sprite.Tank;

public class TankTest {

	public static void main(String[] args) {

		GameScene frame = new GameScene("test", 600, 600);

		Deploy deploy = frame.getDeploy();

		deploy.setScreen(new TestFrame());

		deploy.mainLoop();

		frame.showFrame();

	}

	static class TestFrame extends Screen {

		private Tank tank;
		private ETank eTank;
		private LTimer lTimer = new LTimer(400);
		private boolean flag = true;

		public TestFrame() {
			tank = SpriteContainer.mainTank;
			eTank = SpriteContainer.eTank;
		}

		public void alter(LTimerContext timer) {
			if (flag) {
				eTank.ai();
				flag = false;
			}
			
			if (lTimer.action(19)) {
				tank.move(new MoveCallback() {

					@Override
					public void execute() {
						// TODO Auto-generated method stub

					}

				});

				tank.fire();
				this.draw(this.getScreenImage().createGraphics());
			}
		}

		@Override
		public void draw(Graphics2D g) {
			g.drawImage(tank.getOnlyMove(tank.getDer()), tank.getxValue(), tank
					.getyValue(), null);

			g.drawImage(eTank.getOnlyMove(eTank.getDer()), eTank.getxValue(),
					eTank.getyValue(), null);

			List<Bullet> fireList = SpriteContainer.fireList;

			for (int i = 0; i < fireList.size(); i++) {
				g.drawImage(fireList.get(i).getOnlyMove(0), fireList.get(i)
						.getxValue(), fireList.get(i).getyValue(), null);
			}

			this.createMap(g);
		}

		@Override
		public void leftClick(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void middleClick(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onKey(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_UP:
				tank.setMoveDer(Constant.RpgSprite.UP);
				tank.locked = false;
				break;
			case KeyEvent.VK_DOWN:
				tank.setMoveDer(Constant.RpgSprite.DOWN);
				tank.locked = false;
				break;
			case KeyEvent.VK_LEFT:
				tank.setMoveDer(Constant.RpgSprite.LEFT);
				tank.locked = false;
				break;
			case KeyEvent.VK_RIGHT:
				tank.setMoveDer(Constant.RpgSprite.RIGHT);
				tank.locked = false;
				break;
			}

			if (key == KeyEvent.VK_SPACE) {
				tank.fireLocked = false;
			}
		}

		@Override
		public void onKeyUp(KeyEvent e) {
			int key = e.getKeyCode();

			switch (key) {
			case KeyEvent.VK_UP:
				tank.locked = true;
				break;
			case KeyEvent.VK_DOWN:
				tank.locked = true;
				break;
			case KeyEvent.VK_LEFT:
				tank.locked = true;
				break;
			case KeyEvent.VK_RIGHT:
				tank.locked = true;
				break;
			}

		}

		@Override
		public void rightClick(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void createMap(Graphics2D g) {
			int[][] currentMap = MapFactory.getCurrentMap();

			boolean isDrawHome = false;

			for (int i = 0; i < currentMap.length; i++) {
				for (int j = 0; j < currentMap[i].length; j++) {
					if (!isDrawHome && currentMap[i][j] == Constant.TYPE_HOME) {
						g.drawImage(MapFactory.getHomeImage(), j * 20, i * 20,
								null);
						isDrawHome = true;
					}

					if (currentMap[i][j] < 4 && currentMap[i][j] != 0) {
						g
								.drawImage(
										MapFactory.getBaffleImages()[currentMap[i][j] - 1],
										j * 20, i * 20, null);
					}
				}
			}
		}
	}
}
