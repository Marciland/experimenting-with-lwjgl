package utilities;

import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tools {

	public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image dimg = img.getScaledInstance(width, height,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		return imageIcon;
	}

	public static Font getCalibriFont(int x) {
		Font font =  new Font("Calibri Light", Font.PLAIN, x);
		return font;
	}
}