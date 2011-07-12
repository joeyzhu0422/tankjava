package info.cloverapp.game.pig.scene;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * 
 * �����ӿ�
 * 
 * @author joey
 *
 */
public interface IScene {

	/**
	 * ��ʼ������
	 */
	public void init();

	/**
	 * 
	 */
	public void action();

	/**
	 * ��淽��
	 * 
	 * @param g
	 * @param width
	 * @param height
	 */
	public void draw(Graphics g, int width, int height);

	/**
	 * ���̼�������ȡ
	 * 
	 * @return
	 */
	public List<KeyListener> getKeyListenerList();

	/**
	 * �Ƿ�����
	 * 
	 * @return
	 */
	public boolean isRun();

}
