package info.cloverapp.game.pig.move.listener;

import info.cloverapp.game.pig.beans.ActiviteElement;

public interface MoveListener {

	/**
	 * �ж��Ƿ���ײ
	 * 
	 * @param element
	 *            �����
	 * @return boolean �������true�����ʾ��������˶�����֮��Ȼ��
	 */
	public boolean isCollide(ActiviteElement element);

}
