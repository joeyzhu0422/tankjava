package info.cloverapp.game.pig.scene;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * 
 * 场景接口
 * 
 * @author joey
 *
 */
public interface IScene {

	/**
	 * 初始化方法
	 */
	public void init();

	/**
	 * 
	 */
	public void action();

	/**
	 * 描绘方法
	 * 
	 * @param g
	 * @param width
	 * @param height
	 */
	public void draw(Graphics g, int width, int height);

	/**
	 * 键盘监听器获取
	 * 
	 * @return
	 */
	public List<KeyListener> getKeyListenerList();

	/**
	 * 是否在跑
	 * 
	 * @return
	 */
	public boolean isRun();

}
