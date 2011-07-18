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
		this.x = Constant.ActiviteElement.Pig.ORIGINAL_X;
		this.y = Constant.ActiviteElement.Pig.ORIGINAL_Y;
		this.width = Constant.ActiviteElement.Pig.WIDTH;
		this.height = Constant.ActiviteElement.Pig.HEIGHT;
		this.direction = Constant.ActiviteElement.DIRECTION_UP;
		this.color = Color.PINK;
	}
	
	@Override
	public void draw(Graphics g) {
		
		g.setColor(this.color);
		g.fill3DRect(x, y, width, height, true);
		
	}

}
