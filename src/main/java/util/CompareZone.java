package util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ��Ļ�ϲ���ָ��ͼƬ
 * 
 * @author Jeby Sun
 * @date 2014-09-13
 * @website http://www.jebysun.com
 */
public class CompareZone {

	BufferedImage screenShotImage; // ��Ļ��ͼ
	BufferedImage keyImage; // ����Ŀ��ͼƬ

	int scrShotImgWidth; // ��Ļ��ͼ����
	int scrShotImgHeight; // ��Ļ��ͼ�߶�

	int keyImgWidth; // ����Ŀ��ͼƬ����
	int keyImgHeight; // ����Ŀ��ͼƬ�߶�

	int[][] screenShotImageRGBData; // ��Ļ��ͼRGB����
	int[][] keyImageRGBData; // ����Ŀ��ͼƬRGB����

	int[][][] findImgData; // ���ҽ����Ŀ��ͼ��λ����Ļ��ͼ�ϵ���������

	public boolean CompareZone(String keyImagePath) {
		screenShotImage = this.getFullScreenShot();
		keyImage = this.getBfImageFromPath(keyImagePath);
		screenShotImageRGBData = this.getImageGRB(screenShotImage);
		keyImageRGBData = this.getImageGRB(keyImage);
		scrShotImgWidth = screenShotImage.getWidth();
		scrShotImgHeight = screenShotImage.getHeight();
		keyImgWidth = keyImage.getWidth();
		keyImgHeight = keyImage.getHeight();

		// ��ʼ����
		return this.findImage();

	}

	/**
	 * ȫ����ͼ
	 * 
	 * @return ����BufferedImage
	 */
	public BufferedImage getFullScreenShot() {
		BufferedImage bfImage = null;
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		try {
			Robot robot = new Robot();
			bfImage = robot.createScreenCapture(new Rectangle(0, 0, 800, 800));
		} catch (AWTException e) {
			e.printStackTrace();
		}
		return bfImage;
	}

	/**
	 * �ӱ����ļ���ȡĿ��ͼƬ
	 * 
	 * @param keyImagePath
	 *            - ͼƬ����·��
	 * @return ����ͼƬ��BufferedImage����
	 */
	public BufferedImage getBfImageFromPath(String keyImagePath) {
		BufferedImage bfImage = null;
		try {
			bfImage = ImageIO.read(new File(keyImagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bfImage;
	}

	/**
	 * ����BufferedImage��ȡͼƬRGB����
	 * 
	 * @param bfImage
	 * @return
	 */
	public int[][] getImageGRB(BufferedImage bfImage) {
		int width = bfImage.getWidth();
		int height = bfImage.getHeight();
		int[][] result = new int[height][width];
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				// ʹ��getRGB(w,
				// h)��ȡ�õ����ɫֵ��ARGB������ʵ��Ӧ����ʹ�õ���RGB��������Ҫ��ARGBת����RGB����bufImg.getRGB(w,
				// h) & 0xFFFFFF��
				result[h][w] = bfImage.getRGB(w, h) & 0xFFFFFF;
			}
		}
		return result;
	}

	/**
	 * ����ͼƬ
	 */
	public boolean findImage() {
		findImgData = new int[keyImgHeight][keyImgWidth][2];
		// ������Ļ��ͼ���ص�����
		boolean result=false;
		for (int y = 0; y < scrShotImgHeight - keyImgHeight; y++) {
			for (int x = 0; x < scrShotImgWidth - keyImgWidth; x++) {
				// ����Ŀ��ͼ�ĳߴ磬�õ�Ŀ��ͼ�ĸ���ӳ�䵽��Ļ��ͼ�ϵ��ĸ��㣬
				// �жϽ�ͼ�϶�Ӧ���ĸ�����ͼB���ĸ������ص��ֵ�Ƿ���ͬ��
				// �����ͬ�ͽ���Ļ��ͼ��ӳ�䷶Χ�ڵ����еĵ���Ŀ��ͼ�����еĵ���бȽϡ�
				if ((keyImageRGBData[0][0] ^ screenShotImageRGBData[y][x]) == 0
						&& (keyImageRGBData[0][keyImgWidth - 1] ^ screenShotImageRGBData[y][x + keyImgWidth - 1]) == 0
						&& (keyImageRGBData[keyImgHeight - 1][keyImgWidth - 1]
								^ screenShotImageRGBData[y + keyImgHeight - 1][x + keyImgWidth - 1]) == 0
						&& (keyImageRGBData[keyImgHeight - 1][0]
								^ screenShotImageRGBData[y + keyImgHeight - 1][x]) == 0) {

					boolean isFinded = isMatchAll(y, x);
					// ����ȽϽ����ȫ��ͬ����˵��ͼƬ�ҵ��������ҵ���λ���������ݵ����ҽ�����顣
					if (isFinded) {
						/*for (int h = 0; h < keyImgHeight; h++) {
							for (int w = 0; w < keyImgWidth; w++) {
								findImgData[h][w][0] = y + h;
								findImgData[h][w][1] = x + w;
							}
						}
						return;*/
						result=true;
					}
				}
			}
		}
		return result;
	}

	/**
	 * �ж���Ļ��ͼ��Ŀ��ͼӳ�䷶Χ�ڵ�ȫ�����Ƿ�ȫ����Сͼ�ĵ�һһ��Ӧ��
	 * 
	 * @param y
	 *            - ��Ŀ��ͼ���Ͻ����ص���ƥ�����Ļ��ͼy����
	 * @param x
	 *            - ��Ŀ��ͼ���Ͻ����ص���ƥ�����Ļ��ͼx����
	 * @return
	 */
	public boolean isMatchAll(int y, int x) {
		int biggerY = 0;
		int biggerX = 0;
		int xor = 0;
		for (int smallerY = 0; smallerY < keyImgHeight; smallerY++) {
			biggerY = y + smallerY;
			for (int smallerX = 0; smallerX < keyImgWidth; smallerX++) {
				biggerX = x + smallerX;
				if (biggerY >= scrShotImgHeight || biggerX >= scrShotImgWidth) {
					return false;
				}
				xor = keyImageRGBData[smallerY][smallerX] ^ screenShotImageRGBData[biggerY][biggerX];
				if (xor != 0) {
					return false;
				}
			}
			biggerX = x;
		}
		return true;
	}

	/**
	 * ������ҵ�����������
	 */
	/*private void printFindData() {
		for (int y = 0; y < keyImgHeight; y++) {
			for (int x = 0; x < keyImgWidth; x++) {
				System.out.print("(" + this.findImgData[y][x][0] + ", " + this.findImgData[y][x][1] + ")");
			}
			System.out.println();
		}
	}*/

	public static void main(String[] args) {
		String keyImagePath = "D:/key.png";
		//CompareZone demo = new CompareZone(keyImagePath);
		//demo.printFindData();
	}
}