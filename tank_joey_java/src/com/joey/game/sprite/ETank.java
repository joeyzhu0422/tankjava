package com.joey.game.sprite;

import java.util.Random;

import com.joey.game.constant.Constant;

public class ETank extends Tank {

	public ETank(String fileName, int width, int height, int x, int y, int size) {
		super(fileName, width, height, x, y, size);
	}

	public void ai() {
		this.locked = false;
		
		MoveCallback callback = new MoveCallback() {

			@Override
			public void execute() {
				// TODO Auto-generated method stub

			}
		};

		int[] ary = new int[] { Constant.RpgSprite.UP, Constant.RpgSprite.DOWN,
				Constant.RpgSprite.LEFT, Constant.RpgSprite.RIGHT };

		int random = new Random().nextInt(3);

		int nextDer = this.moveDer = ary[random];

		this.move(callback);

		final ETank self = this;

		long m = Math.round(Math.random() * 100);

		if (this.toBorder(this.der, callback) || this.hit(this.der, callback)) {
			try {
				self.setPos(nextDer);
				self.fireLocked = false;
				self.fire();
				Thread.sleep(400);
				self.move(callback);
				new Thread() {
			
					public void run() {
						try {
							Thread.sleep(400);
							self.ai();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}.start();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}

		if (m < 20) {
			this.setPos(nextDer);
			this.fireLocked = false;
			this.fire();
		} else if (m < 60) {
			this.fireLocked = false;
			this.fire();
		}
		
		new Thread() {
			
			public void run() {
				try {
					Thread.sleep(400);
					self.ai();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		this.locked = true;
	}
}
