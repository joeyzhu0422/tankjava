package info.cloverapp.game.pig.beans;

import info.cloverapp.game.pig.constant.Constant;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * –°÷Ì¿‡
 * 
 * @author joey
 *
 */
public class Pig extends ActiviteElement{

	public Pig() {
		super();
		this.x = 0;
		this.y = 0;
		this.width = Constant.Scene.CELL_LENGTH * 4;
		this.height = Constant.Scene.CELL_LENGTH * 4;
		this.direction = Constant.ActiviteElement.DIRECTION_UP;
		this.color = Color.PINK;
	}
	
	@Override
	public void draw(Graphics g) {
		
		g.setColor(this.color);
		g.fill3DRect(x, y, width, height, true);
		
	}

}
