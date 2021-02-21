package gManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Loader {
	static int pageWidth = 800, pageHeight = 600;
	static JFrame page = new JFrame("GManager");
	static JPanel homePanel = new HomePanel();
	public static void main(String args[]) {
		page.setContentPane(homePanel);
		page.setLayout(null);
		page.setSize(pageWidth, pageHeight);
		page.setVisible(true);
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}