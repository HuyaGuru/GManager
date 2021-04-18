package TheFiles.Panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import TheFiles.Admin;
import TheFiles.Loader;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	public static LoginPanel loginPanel = new LoginPanel();

	LoginPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel("Password : ");
		c.gridx = 0;
		c.gridy = 0;
		add(label, c);

		JPasswordField pwdfld = new JPasswordField();
		pwdfld.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					ok(pwdfld);
				}
			}

			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}
		});
		pwdfld.setPreferredSize(new Dimension(150, 18));
		c.gridx = 1;
		c.gridy = 0;
		add(pwdfld, c);

		JButton button = new JButton("Login");
		c.insets = new Insets(20, 0, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok(pwdfld);
			}
		});
		add(button, c);
	}

	void ok(JPasswordField pwdfld) {
		Boolean check = Admin.Authenticate(String.valueOf(pwdfld.getPassword()));
		if (check) {
			Loader.page.setContentPane(HomePanel2.homePanel);
			Loader.page.invalidate();
			Loader.page.validate();
		}
		pwdfld.setText("");
	}
}