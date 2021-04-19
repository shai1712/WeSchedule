package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PaintPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7431839618540255226L;
	private final static String BACKGROUND_PATH = "src/images/background.jpg";
	private BufferedImage backgroundImage = null;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// try to read the image
		try {
			backgroundImage = ImageIO.read(new File(BACKGROUND_PATH));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
		g.drawImage(backgroundImage, 0, 0, 350, 400, this);
	}
}
