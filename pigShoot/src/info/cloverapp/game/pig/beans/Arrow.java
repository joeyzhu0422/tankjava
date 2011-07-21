package info.cloverapp.game.pig.beans;

import java.awt.Color;
import java.awt.Graphics;


public class Arrow extends ActiviteElement {

	protected StaticElement element;

	public Arrow(StaticElement element) {
		//this.setMoveListener(new ArrowMoveListenerImpl());
		this.color = Color.WHITE;
		this.width = 5;
		this.height = 5;
		this.element = element;

	}

	public void action() {
		
	}



	public void draw(Graphics g) {
	

		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	public void setXy(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
