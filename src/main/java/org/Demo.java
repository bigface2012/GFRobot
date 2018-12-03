package org;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		java.awt.Robot robot = new java.awt.Robot();// 创建一个机器人对象
		// 取得当前屏幕大小
		Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Dimension dm = tk.getScreenSize();
		Window[]wList=Window.getWindows();
		// 计算屏幕中心点
		int x = (int) dm.getWidth() / 2;
		int y = (int) dm.getHeight() / 2;
		robot.mouseMove(x, y);// 将鼠标移动到屏幕中心
		robot.mousePress(InputEvent.BUTTON1_MASK);// 按下鼠标左键
		robot.mouseRelease(InputEvent.BUTTON1_MASK);// 松开鼠标左键
		robot.keyPress(KeyEvent.VK_ENTER); // 模拟按下回车键
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_SHIFT);// 按下SHIFT键
		for (int i = 0; i < 10; i++) {
		robot.keyPress('A' + i); // 在屏幕上打字
		robot.keyRelease('A' + i);
	
		Thread.sleep(500);
		}
		robot.keyRelease(KeyEvent.VK_SHIFT);// 松开SHIFT键
		for (int i = 0; i < 11; i++
			) {// 将刚才输入的内容删除掉
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
