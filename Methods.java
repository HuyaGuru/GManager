package gManager;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Methods {
	public static JButton templateButton() {
		JButton button = new JButton();
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setForeground(new Color(36, 134, 189));
		return button;
	}
	public static JButton homeBackButton() {
		JButton button = templateButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loader.page.setContentPane(Loader.homePanel);
				Loader.page.invalidate();
				Loader.page.validate();
			}
		});
		return button;
		
	}
}
