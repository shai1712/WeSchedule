package definitions;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class SideFunctions {

	static int xMouse, yMouse;

	public static void frameDragMouseDragged(JFrame frame, MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();

		frame.setLocation(x - xMouse, y - yMouse);
	}

	public static void frameDragMouseClicked(JFrame frame, MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
	}

}
