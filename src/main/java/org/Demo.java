package org;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		java.awt.Robot robot = new java.awt.Robot();// ����һ�������˶���
		// ȡ�õ�ǰ��Ļ��С
		Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Dimension dm = tk.getScreenSize();
		Window[]wList=Window.getWindows();
		// ������Ļ���ĵ�
		int x = (int) dm.getWidth() / 2;
		int y = (int) dm.getHeight() / 2;
		robot.mouseMove(x, y);// ������ƶ�����Ļ����
		robot.mousePress(InputEvent.BUTTON1_MASK);// ����������
		robot.mouseRelease(InputEvent.BUTTON1_MASK);// �ɿ�������
		robot.keyPress(KeyEvent.VK_ENTER); // ģ�ⰴ�»س���
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_SHIFT);// ����SHIFT��
		for (int i = 0; i < 10; i++) {
		robot.keyPress('A' + i); // ����Ļ�ϴ���
		robot.keyRelease('A' + i);
	
		Thread.sleep(500);
		}
		robot.keyRelease(KeyEvent.VK_SHIFT);// �ɿ�SHIFT��
		for (int i = 0; i < 11; i++
			) {// ���ղ����������ɾ����
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(500);
		}
		robot.mousePress(KeyEvent.VK_BACK_SPACE);
		robot.mouseRelease(KeyEvent.VK_BACK_SPACE);
		}
		
	static public void maxWindowOnScreen(Window w) { 
		sizeWindowOnScreen(w, 1.0, 1.0); 
		} 
	static public void sizeWindowOnScreen(Window w, double ratioX, 

			double ratioY) 
			{ 
			// java.awt.Toolkit 
			Toolkit tk = w.getToolkit(); 
			// java.awt.Dimension 
			Dimension scrn = tk.getScreenSize(); 
			w.setSize( new Dimension( (int)(scrn.width * ratioX), 
			(int)(scrn.height * ratioY) ) 
			); 
			} 
			static public void sizeWindowOnScreen(Window w, double ratio) { 
			sizeWindowOnScreen(w, ratio, ratio); 
			} 
}
