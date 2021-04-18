package TheFiles;

import java.awt.Dimension;
import javax.swing.JFrame;

import TheFiles.Panels.LoginPanel;

public class Loader extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Loader page = new Loader();

	public Loader() {
		super("College Management System");
	}

	public static void PrepareGUI() {
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.getContentPane().add(LoginPanel.loginPanel);
		page.setPreferredSize(new Dimension(750, 350));
		page.pack();
		page.setVisible(true);
	}

	public static void main(String[] args) {
		Initiate.Admin();
		Initiate.Reset();
		PrepareGUI();
	}
}