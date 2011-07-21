package info.cloverapp.game.pig.beans;

import info.cloverapp.game.pig.constant.Constant;
import info.cloverapp.game.pig.move.listener.impl.ArrowMoveListenerImpl;

import java.awt.Color;
import java.awt.Graphics;

public class Arrow extends ActiviteElement {

	protected StaticElement element;

	public Arrow(StaticElement element) {
		this.setMoveListener(new ArrowMoveListenerImpl());
		this.color = Color.YELLOW;
		this.width = Constant.ActiviteElement.Arrow.WIDTH;
		this.height = Constant.ActiviteElement.Arrow.HEIGHT;
		this.element = element;
		this.speed = Constant.ActiviteElement.Arrow.SPEED;
	}

	public void action() {

	}

	public void draw(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void setXy(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
