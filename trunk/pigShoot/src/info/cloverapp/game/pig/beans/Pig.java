package info.cloverapp.game.pig.beans;

import info.cloverapp.game.pig.constant.Constant;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * –°÷Ì¿‡
 * 
 * @author joey
 * 
 */
public class Pig extends ActiviteElement {

	protected Queue<Arrow> preparedQueue = new LinkedBlockingQueue<Arrow>();

	public Queue<Arrow> firedQueue = new LinkedBlockingQueue<Arrow>();

	public Pig() {
		super();
		this.x = Constant.ActiviteElement.Pig.ORIGINAL_X;
		this.y = Constant.ActiviteElement.Pig.ORIGINAL_Y;
		this.width = Constant.ActiviteElement.Pig.WIDTH;
		this.height = Constant.ActiviteElement.Pig.HEIGHT;
		this.direction = Constant.ActiviteElement.DIRECTION_UP;
		this.speed = Constant.ActiviteElement.Pig.SPEED;
		this.color = Color.PINK;

		for (int i = 0; i < 3; i++) {
			preparedQueue.add(new Arrow(this));
		}
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(this.color);
		g.fill3DRect(x, y, width, height, true);

	}

	public void fire() {

		final Arrow arrow = this.poll();

		if (null == arrow) {
			return;
		}
		
		System.out.println("firing...");

		new Thread() {

			public void run() {

				while (arrow.move()) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				put(arrow);
			}
		}.start();

	}

	public Arrow poll() {

		Arrow arrow = preparedQueue.poll();
		if (null == arrow) {
			return null;
		}
		arrow.setXy(x, y);
		arrow.setDirection(Constant.ActiviteElement.DIRECTION_LEFT);
		firedQueue.offer(arrow);

		return arrow;
	}

	public void put(Arrow arrow) {

		firedQueue.remove(arrow);
		preparedQueue.offer(arrow);

	}

}
