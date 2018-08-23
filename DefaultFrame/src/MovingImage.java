import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MovingImage extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8181062310319449530L;

	private final int TIME_INTERVAL = 10;
	private final int FREQUENCY_OF_MOVING = 100;
	private String fileName = "c:/sample.jpg";
	private int currentX;
	private int currentY;
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public void setStartCoordinate(int x, int y) {
		currentX = x;
		currentY = y;
		startX = x;
		startY = y;
	}

	public void setEndCoordinate(int x, int y) {
		endX = x;
		endY = y;
	}

	public void paint(Graphics g) {

		Image img = (Toolkit.getDefaultToolkit()).getImage(fileName);

		g.drawImage(img, currentX, currentY, this);
	}

	public void run() {
		int movingGapOfX = (endX - startX) / FREQUENCY_OF_MOVING;
		int movingGapOfY = (endY - startY) / FREQUENCY_OF_MOVING;
		try {
			while (currentX <= endX) {
				currentX += movingGapOfX;
				currentY += movingGapOfY;
				repaint();
				Thread.sleep(TIME_INTERVAL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
